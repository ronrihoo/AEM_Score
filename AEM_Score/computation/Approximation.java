package AEM_Score.computation;

import AEM_Score.util.Constants;


public class Approximation {

    public static Calculation calculation = new Calculation();
    public static Acquisition acquisition = calculation.acquisition;

    public static int[] minimumNumericGradePerLetterGradeList = new int[Constants.MAX_LETTERGRADE_QUANTITY];
    public static int userNumericGrade;
    public static int userLetterGrade;

    public static String letterGrade;

    public Approximation() {

    }

    public static String assignLetterGradeFromConstants(double grade) {
        if (grade > 0 && grade <= 100) {
            if (grade >= Constants.A_MIN) {
                letterGrade = Constants.LETTER_GRADE_A;
            } else if (grade >= Constants.B_MIN) {
                letterGrade = Constants.LETTER_GRADE_B;
            } else if (grade >= Constants.C_MIN) {
                letterGrade = Constants.LETTER_GRADE_C;
            } else if (grade >= Constants.D_MIN) {
                letterGrade = Constants.LETTER_GRADE_D;
            } else if (grade < Constants.D_MIN && grade > Constants.W_CODE) {
                letterGrade = Constants.LETTER_GRADE_F;
            } else if (grade == Constants.W_CODE) {
                letterGrade = Constants.LETTER_GRADE_W;
            } else {
                letterGrade = Constants.LETTER_GRADE_NA;
            }
        } else {
            letterGrade = Constants.LETTER_GRADE_NA;
        }
        return letterGrade;
    }

    public static String assignLetterGradeFromCalculations() {
        minimumNumericGradePerLetterGradeList = calculation.createListOfPossibleMinimumScorePerLetterGrade();
        userNumericGrade = acquisition.getUserScore();

        System.out.println("Score: " + userNumericGrade + "\t\t\t(Debug: this is a debugging write-out from Approximation.java, line 48)");
        for (int i = minimumNumericGradePerLetterGradeList.length - 1; i >= 0; i--) {
            if (i != minimumNumericGradePerLetterGradeList.length - 1 &&
                    userNumericGrade >= minimumNumericGradePerLetterGradeList[i] &&
                    userNumericGrade < minimumNumericGradePerLetterGradeList[i + 1]) {
                userLetterGrade = i;
            } else if (i == minimumNumericGradePerLetterGradeList.length - 1) {
                if (userNumericGrade >= minimumNumericGradePerLetterGradeList[i]) {
                    userLetterGrade = i;
                }
            }
        }
        if (userLetterGrade == 4) {
            letterGrade = Constants.LETTER_GRADE_A;
        } else if (userLetterGrade == 3) {
            letterGrade = Constants.LETTER_GRADE_B;
        } else if (userLetterGrade == 2) {
            letterGrade = Constants.LETTER_GRADE_C;
        } else if (userLetterGrade == 1) {
            letterGrade = Constants.LETTER_GRADE_D;
        } else {
            letterGrade = Constants.LETTER_GRADE_F;
        }
        return letterGrade;
    }

    public static void assignLetterGradeFromCalculations_Test() {
        minimumNumericGradePerLetterGradeList = calculation.createListOfPossibleMinimumScorePerLetterGrade();
        userNumericGrade = acquisition.getUserScore();
        for (int i = minimumNumericGradePerLetterGradeList.length - 1; i >= 0; i--) {
            if (i != minimumNumericGradePerLetterGradeList.length - 1 &&
                    userNumericGrade >= minimumNumericGradePerLetterGradeList[i] &&
                    userNumericGrade < minimumNumericGradePerLetterGradeList[i + 1]) {
                userLetterGrade = i;
            } else if (i == minimumNumericGradePerLetterGradeList.length - 1) {
                if (userNumericGrade >= minimumNumericGradePerLetterGradeList[i]) {
                    userLetterGrade = i;
                }
            }
        }
        if (userLetterGrade == 4) {
            System.out.println("Score: " + userNumericGrade + "\n" + "Lettergrade: " + Constants.LETTER_GRADE_A);
        } else if (userLetterGrade == 3) {
            System.out.println("Score: " + userNumericGrade + "\n" + "Lettergrade: " + Constants.LETTER_GRADE_B);
        } else if (userLetterGrade == 2) {
            System.out.println("Score: " + userNumericGrade + "\n" + "Lettergrade: " + Constants.LETTER_GRADE_C);
        } else if (userLetterGrade == 1) {
            System.out.println("Score: " + userNumericGrade + "\n" + "Lettergrade: " + Constants.LETTER_GRADE_D);
        } else {
            System.out.println("Score: " + userNumericGrade + "\n" + "Lettergrade: " + Constants.LETTER_GRADE_F);
        }
    }

}
