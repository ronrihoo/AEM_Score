package AEM_Score.computation;

import AEM_Score.io.FakeInterface;
import AEM_Score.util.Constants;


public class Calculation {

    Acquisition acquisition = new Acquisition();
    FakeInterface fakeInterface = new FakeInterface();

    private int[] amountOfStudentsPerLetterGrade = new int[Constants.MAX_LETTERGRADE_QUANTITY];
    private int[] historicalAverages = new int [Constants.MAX_LETTERGRADE_QUANTITY];
    private int[] classScoreRangeAverages = new int [Constants.MAX_LETTERGRADE_QUANTITY];
    private int[] possibleScoreMinimumForLetterGrade = new int [Constants.MAX_LETTERGRADE_QUANTITY];
    private int studentQuantity = 0;
    private double proportionalityConstant = 0;
    private double tempNum = 0;

    public Calculation() {
        fakeInterface.test(acquisition);
    }

    public int[] createListOfStudentQuotaPerLetterGrade() {
        this.historicalAverages = acquisition.getHistoricalAverages();
        this.classScoreRangeAverages = acquisition.getClassScoreRanges();
        this.studentQuantity = 0;
        if (this.classScoreRangeAverages.length > 0) {
            for (int classScoreRangeAverage : this.classScoreRangeAverages) {
                this.studentQuantity += classScoreRangeAverage;
            }
            //System.out.println("studentQuantity: " + studentQuantity);
            if (this.studentQuantity > 0) {
                this.proportionalityConstant = ((double) this.studentQuantity) / 100;
                //System.out.println("proportionalityConstant: " + proportionalityConstant);
            }
        }
        // Generate the proportionality list called amountOfStudentsPerLetterGrade
        if (this.studentQuantity > 0 && historicalAverages.length > 0) {
            for (int i = 0; i < Constants.MAX_LETTERGRADE_QUANTITY; i++) {
                tempNum = (((double) this.historicalAverages[i])*this.proportionalityConstant);
                //System.out.println("tempNum: " + tempNum);
                if (tempNum - ((double) ((int) tempNum)) - 0.5 > 0) {
                    tempNum = (double) ((int) tempNum + 1);
                    //System.out.println("tempNum_up: " + tempNum);
                } else {
                    tempNum = (double) ((int) tempNum);     // strip the precision and go back to double type
                    //System.out.println("tempNum_dn: " + tempNum);
                }
                this.amountOfStudentsPerLetterGrade[i] = (int) tempNum;
                //System.out.println("this.classScoreRangeAverages[i]: " + this.classScoreRangeAverages[i]);
            }
        }
        return this.amountOfStudentsPerLetterGrade;
    }

    public int[] createListOfPossibleMinimumScorePerLetterGrade () {
        int[] quotaPerLetterGrade = createListOfStudentQuotaPerLetterGrade();

        int a;
        int b = 0;
        int c = quotaPerLetterGrade.length - 1;

        if (quotaPerLetterGrade[0] > -1) {
            a = quotaPerLetterGrade[c];
            for (int i = classScoreRangeAverages.length - 1; i > 0; i--) {
                b += classScoreRangeAverages[i];

                if (b >= a) {
                    possibleScoreMinimumForLetterGrade[c] = i*10;
                    c -= 1;
                    a += quotaPerLetterGrade[c];
                }

            }
        }
        return possibleScoreMinimumForLetterGrade;
    }

}
