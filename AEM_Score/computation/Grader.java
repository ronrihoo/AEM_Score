package aemscore.computation;

import aemscore.util.Constants;

/**
 * Provides grade approximation(s).
 */
public class Grader {

    public static int equivalentLetterGrade;
    public static char letterGrade;

    public Grader() {

    }

    public char assignLetterGradeFromCalculations(int[] letterGradeMinimumScores, int studentNumericGrade) {
        for (int i = letterGradeMinimumScores.length - 1; i >= 0; i--) {
            if (i != letterGradeMinimumScores.length - 1 &&
                    studentNumericGrade >= letterGradeMinimumScores[i] &&
                    studentNumericGrade < letterGradeMinimumScores[i + 1]) {
                equivalentLetterGrade = i;
            } else if (i == letterGradeMinimumScores.length - 1) {
                if (studentNumericGrade >= letterGradeMinimumScores[i]) {
                    equivalentLetterGrade = i;
                }
            }
        }
        if (equivalentLetterGrade == 4) {
            letterGrade = Constants.LETTER_GRADE_A;
        } else if (equivalentLetterGrade == 3) {
            letterGrade = Constants.LETTER_GRADE_B;
        } else if (equivalentLetterGrade == 2) {
            letterGrade = Constants.LETTER_GRADE_C;
        } else if (equivalentLetterGrade == 1) {
            letterGrade = Constants.LETTER_GRADE_D;
        } else {
            letterGrade = Constants.LETTER_GRADE_F;
        }
        return letterGrade;
    }

    public char assignLetterGradeFromConstants(double grade) {
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

}
