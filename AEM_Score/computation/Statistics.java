package aemscore.computation;

import aemscore.util.Constants;

/**
 * Provides statistical modeling and computation.
 */
public class Statistics {

    private int[] amountOfStudentsPerLetterGrade = new int[Constants.MAX_LETTERGRADE_QUANTITY];
    private int[] historicalAverageDistribution = new int [Constants.MAX_LETTERGRADE_QUANTITY];
    private int[] classScoreDistribution = new int [Constants.MAX_LETTERGRADE_QUANTITY];
    private int[] possibleScoreMinimumForLetterGrade = new int [Constants.MAX_LETTERGRADE_QUANTITY];
    private int studentQuantity = 0;
    private double proportionalityConstant = 0;
    private double tempNum = 0;

    public Statistics() {

    }

    public int[] createListOfStudentQuotaPerLetterGrade(int[] historicalAvgDistribution, int[] classScoreDistribution) {
        this.historicalAverageDistribution = historicalAvgDistribution;
        this.classScoreDistribution = classScoreDistribution;
        this.studentQuantity = 0;
        if (this.classScoreDistribution.length > 0) {
            for (int classScoreRangeAverage : this.classScoreDistribution) {
                this.studentQuantity += classScoreRangeAverage;
            }
            if (this.studentQuantity > 0) {
                this.proportionalityConstant = ((double) this.studentQuantity) / 100;
            }
        }
        // Generate the proportionality list called amountOfStudentsPerLetterGrade
        if (this.studentQuantity > 0 && historicalAverageDistribution.length > 0) {
            for (int i = 0; i < Constants.MAX_LETTERGRADE_QUANTITY; i++) {
                tempNum = (((double) this.historicalAverageDistribution[i])*this.proportionalityConstant);
                if (tempNum - ((double) ((int) tempNum)) - 0.5 > 0) {
                    tempNum = (double) ((int) tempNum + 1);
                }
                this.amountOfStudentsPerLetterGrade[i] = (int) tempNum;
            }
        }
        return this.amountOfStudentsPerLetterGrade;
    }

    public int[] createListOfPossibleMinimumScorePerLetterGrade (int[] letterGradeQuota) {
        int a;
        int b = 0;
        int c = letterGradeQuota.length - 1;
        if (letterGradeQuota[0] > -1) {
            a = letterGradeQuota[c];
            for (int i = classScoreDistribution.length - 1; i > 0; i--) {
                b += classScoreDistribution[i];
                if (b >= a) {
                    possibleScoreMinimumForLetterGrade[c] = i*10;
                    c -= 1;
                    a += letterGradeQuota[c];
                }
            }
        }
        return possibleScoreMinimumForLetterGrade;
    }
}
