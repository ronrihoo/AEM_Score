package aemscore.io;

import aemscore.util.Constants;

/**
 * Provides a fake interface to use for testing, until a real interface has been developed.
 *
 * However, this class can be considered as the interface class, since it can easily be
 * adapted into handling the actual user-interface.
 */
public class FakeInterface {

    int[] historicalAverageLetterGradeDistribution = new int[Constants.MAX_LETTERGRADE_QUANTITY];
    int[] classAverageNumericGradeDistribution = new int[Constants.MAX_GRADE_RANGE_QUANTITY];
    int[] classScoreDistribution = new int[Constants.MAX_GRADE_RANGE_QUANTITY];
    int userScore = 0;

    public void runTest() {
        useHistoricalAverages_Summer2016();
        useExam2Stats();
        fakeClassAverageNumericGradeDistro();
        setUserScore(50);                                                   // student's exam 2 score
    }

    // Manual hard input

    public void useHistoricalAverages_Summer2016() {
        this.setHistoricalAvgLetterGradeDistribution(27, 24, 31, 5, 12);    // A, B, C, D, F
    }

    public void fakeClassAverageNumericGradeDistro() {
        this.setClassAverageNumericGradeDistribution(0, 0, 2, 3, 5, 13, 8, 10, 3, 3);
    }

    public void useExam2Stats() {
        this.setClassScoreDistribution(0, 0, 3, 4, 6, 12, 9, 9, 2, 2);      // high to low; 100-90, 89-80, 79-70, ...
    }

    // Getters

    public int[] getHistoricalAverageLetterGradeDistribution() {
        return this.historicalAverageLetterGradeDistribution;
    }

    public int[] getClassAverageNumericGradeDistribution() {
        return this.classAverageNumericGradeDistribution;
    }

    public int[] getClassScoreDistribution() {
        return this.classScoreDistribution;
    }

    public int getUserScore() {
        return this.userScore;
    }

    // Setters

    public void setHistoricalAvgLetterGradeDistribution(int A, int B, int C, int D, int F) {
        this.historicalAverageLetterGradeDistribution[4] = A;
        this.historicalAverageLetterGradeDistribution[3] = B;
        this.historicalAverageLetterGradeDistribution[2] = C;
        this.historicalAverageLetterGradeDistribution[1] = D;
        this.historicalAverageLetterGradeDistribution[0] = F;
    }

    public void setClassAverageNumericGradeDistribution(int r10, int r9, int r8, int r7, int r6,
                                                        int r5, int r4, int r3, int r2, int r1) {
        this.classAverageNumericGradeDistribution[9] = r10;
        this.classAverageNumericGradeDistribution[8] = r9;
        this.classAverageNumericGradeDistribution[7] = r8;
        this.classAverageNumericGradeDistribution[6] = r7;
        this.classAverageNumericGradeDistribution[5] = r6;
        this.classAverageNumericGradeDistribution[4] = r5;
        this.classAverageNumericGradeDistribution[3] = r4;
        this.classAverageNumericGradeDistribution[2] = r3;
        this.classAverageNumericGradeDistribution[1] = r2;
        this.classAverageNumericGradeDistribution[0] = r1;
    }

    /**
     * Set class score distribution for specific assignments, exams, quizzes, or modules
     * <p>
     * This should probably take in an int[] of an expected size from Constants.java and
     * loop foreach item to set the int[]
     *
     * @param r10 90-100%
     * @param r9  80-89%
     * @param r8  70-79%
     * @param r7  60-69%
     * @param r6  50-59%
     * @param r5  40-49%
     * @param r4  30-39%
     * @param r3  20-29%
     * @param r2  10-19%
     * @param r1  0-9%
     */
    public void setClassScoreDistribution(int r10, int r9, int r8, int r7, int r6,
                                          int r5, int r4, int r3, int r2, int r1) {
        this.classScoreDistribution[9] = r10;
        this.classScoreDistribution[8] = r9;
        this.classScoreDistribution[7] = r8;
        this.classScoreDistribution[6] = r7;
        this.classScoreDistribution[5] = r6;
        this.classScoreDistribution[4] = r5;
        this.classScoreDistribution[3] = r4;
        this.classScoreDistribution[2] = r3;
        this.classScoreDistribution[1] = r2;
        this.classScoreDistribution[0] = r1;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    // Printers

    public void printLetterGradeDistribution(int[] letterGradeDistribution, String title) {
        String spacing = "\n\t";
        System.out.print(title + spacing);
        // prints array in reverse order to achieve high-to-low print out
        for (int i = letterGradeDistribution.length - 1; i >= 0; i--) {
            System.out.print(Constants.LETTER_GRADES[i] + ": " + letterGradeDistribution[i]);
            if (i > 0) {
                System.out.print(spacing);
            } else {
                System.out.println();
            }
        }
    }

    public void printNumericGradeDistribution(int[] numericGradeDistribution, String title) {
        String spacing = "\n\t";
        System.out.print(title + spacing);
        // prints array in reverse order to achieve high-to-low print out
        for (int i = numericGradeDistribution.length - 1; i >= 0; i--) {
            System.out.print(Constants.NUMERIC_GRADES[i] + ": " + numericGradeDistribution[i]);
            if (i > 1) {
                System.out.print(spacing);
            } else if (i == 1) {
                System.out.print(spacing + " ");
            } else {
                System.out.println();
            }
        }
    }

    public void printClassScoreDistribution(int[] classScoreDistribution) {
        String spacing = "\n\t";
        System.out.print("Class Score Distribution" + spacing);
        // prints array in reverse order to achieve high-to-low print out
        for (int i = classScoreDistribution.length - 1; i >= 0; i--) {
            System.out.print(Constants.NUMERIC_GRADES[i] + ": " + classScoreDistribution[i]);
            if (i > 1) {
                System.out.print(spacing);
            } else if (i == 1) {
                System.out.print(spacing + " ");
            } else {
                System.out.println();
            }
        }
    }

    public void printNumericGrade(int numericGrade) {
        System.out.println("Numeric-Grade: " + numericGrade);
    }

    public void printLetterGrade(char letterGrade) {
        System.out.println("Letter-Grade: " + letterGrade);
    }

}
