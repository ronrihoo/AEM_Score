package aemscore;

import aemscore.drivers.Driver;

public class Main {

    private static Driver driver = new Driver();

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        driver.getAndPrintUserScore();
        driver.getAndPrintHistoricalAvgLetterGradeDistro();
        driver.getAndPrintClassAvgNumericGradeScoreDistro();
        driver.getAndPrintClassScoreDistro();
        driver.computeAndPrintClassScoreLetterGradeQuota();
        driver.computeAndPrintClassScoreMinimumGrade();
        driver.computeAndPrintStudentLetterGrade();
    }

}
