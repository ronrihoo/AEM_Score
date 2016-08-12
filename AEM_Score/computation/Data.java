package aemscore.computation;

import aemscore.util.Constants;

/**
 * Handles and stores data.
 */
public class Data {
    int[] historicalAverageLetterGradeDistribution = new int[Constants.MAX_LETTERGRADE_QUANTITY];
    int[] classScoreLetterGradeQuota = new int[Constants.MAX_LETTERGRADE_QUANTITY];
    int[] classScoreLetterGradeMinimum = new int[Constants.MAX_GRADE_RANGE_QUANTITY];
    int[] classAverageNumericGradeDistribution = new int[Constants.MAX_GRADE_RANGE_QUANTITY];
    int[] classScoreDistribution = new int[Constants.MAX_GRADE_RANGE_QUANTITY];
    int studentNumericGrade;
    char studentLetterGrade;

    public Data() {

    }

    // Getters

    public int[] getHistoricalAverageLetterGradeDistribution() {
        return historicalAverageLetterGradeDistribution;
    }

    public int[] getClassScoreLetterGradeQuota() {
        return classScoreLetterGradeQuota;
    }

    public int[] getClassScoreLetterGradeMinimum() {
        return classScoreLetterGradeMinimum;
    }

    public int[] getClassAverageNumericGradeDistribution() {
        return classAverageNumericGradeDistribution;
    }

    public int[] getClassScoreDistribution() {
        return this.classScoreDistribution;
    }

    public int getStudentNumericGrade() {
        return studentNumericGrade;
    }

    public char getStudentLetterGrade() {
        return studentLetterGrade;
    }

    // Setters

    public void setHistoricalAverageLetterGradeDistribution(int[] historicalAverages) {
        this.historicalAverageLetterGradeDistribution = historicalAverages;
    }

    public void setClassScoreLetterGradeQuota(int[] classScoreLetterGradeQuota) {
        this.classScoreLetterGradeQuota = classScoreLetterGradeQuota;
    }

    public void setClassScoreLetterGradeMinimum(int[] classScoreLetterGradeMinimum) {
        this.classScoreLetterGradeMinimum = classScoreLetterGradeMinimum;
    }

    public void setClassAverageNumericGradeDistribution(int[] classAverageDistribution) {
        this.classAverageNumericGradeDistribution = classAverageDistribution;
    }

    public void setClassScoreDistribution(int[] classScoreDistribution) {
        this.classScoreDistribution = classScoreDistribution;
    }

    public void setStudentNumericGrade(int studentNumericGrade) {
        this.studentNumericGrade = studentNumericGrade;
    }

    public void setStudentLetterGrade(char studentLetterGrade) {
        this.studentLetterGrade = studentLetterGrade;
    }
}
