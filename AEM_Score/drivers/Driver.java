package aemscore.drivers;

/**
 * Drives specific procedures.
 *
 * Here, information from instances of classes are passed to instances of other classes.
 */
public class Driver {

    private Instances inst = new Instances();

    public Driver() {
        initialize();
    }

    private void initialize() {
        inst.fakeInterface.runTest();
    }

    // Get-and-Printers

    public void getAndPrintUserScore() {
        acquireUserScore_fromFakeInterface();
        inst.fakeInterface.printNumericGrade(inst.data.getStudentNumericGrade());
    }

    public void getAndPrintHistoricalAvgLetterGradeDistro() {
        acquireHistoricalAvgLetterGradeDistro_fromFakeInterface();
        inst.fakeInterface.printLetterGradeDistribution(inst.data.getHistoricalAverageLetterGradeDistribution(),
                "Historical Average Letter-Grade Distribution");
    }

    public void getAndPrintClassAvgNumericGradeScoreDistro() {
        acquireClassAvgNumericGradeDistro_fromFakeInterface();
        inst.fakeInterface.printNumericGradeDistribution(inst.data.getClassAverageNumericGradeDistribution(),
                "Class Average Percentile Distribution");
    }

    public void getAndPrintClassScoreDistro() {
        acquireClassScoreDistro_fromFakeInterface();
        inst.fakeInterface.printNumericGradeDistribution(inst.data.getClassScoreDistribution(),
                "Class Score Distribution");
    }

    // Compute-and-Printers

    public void computeAndPrintClassScoreLetterGradeQuota() {
        computeStudentQuotaPerLetterGrade();
        inst.fakeInterface.printLetterGradeDistribution(inst.data.getClassScoreLetterGradeQuota(),
                "LetterGrade Quota");
    }

    public void computeAndPrintClassScoreMinimumGrade() {
        computeMinimumScoreForEachLetterGrade();
        inst.fakeInterface.printLetterGradeDistribution(inst.data.getClassScoreLetterGradeMinimum(),
                "LetterGrade Minimum Score");
    }

    public void computeAndPrintStudentLetterGrade() {
        computeLetterGrade();
        inst.fakeInterface.printLetterGrade(inst.data.getStudentLetterGrade());
    }

    // Acquisition

    private void acquireUserScore_fromFakeInterface() {
        inst.data.setStudentNumericGrade(inst.fakeInterface.getUserScore()) ;
    }

    private void acquireHistoricalAvgLetterGradeDistro_fromFakeInterface() {
        inst.data.setHistoricalAverageLetterGradeDistribution(inst.fakeInterface.getHistoricalAverageLetterGradeDistribution());
    }

    private void acquireClassAvgNumericGradeDistro_fromFakeInterface() {
        inst.data.setClassAverageNumericGradeDistribution(inst.fakeInterface.getClassAverageNumericGradeDistribution());
    }

    private void acquireClassScoreDistro_fromFakeInterface() {
        inst.data.setClassScoreDistribution(inst.fakeInterface.getClassScoreDistribution());
    }

    // Computation

    private void computeStudentQuotaPerLetterGrade() {
        // for the sake of readability
        int[] historicalAvgDistro = inst.data.getHistoricalAverageLetterGradeDistribution();
        int[] classScoreDistro = inst.data.getClassScoreDistribution();
        int[] letterGradeQuota = inst.statistics.createListOfStudentQuotaPerLetterGrade(historicalAvgDistro, classScoreDistro);
        inst.data.setClassScoreLetterGradeQuota(letterGradeQuota);
    }

    private void computeMinimumScoreForEachLetterGrade() {
        // for the sake of readability
        int[] letterGradeQuota = inst.data.getClassScoreLetterGradeQuota();
        int[] letterGradeMinimumGrade = inst.statistics.createListOfPossibleMinimumScorePerLetterGrade(letterGradeQuota);
        inst.data.setClassScoreLetterGradeMinimum(letterGradeMinimumGrade);
    }

    private void computeLetterGrade() {
        // for the sake of readability
        int[] letterGradeQuota = inst.data.getClassScoreLetterGradeQuota();
        int studentNumericGrade = inst.data.getStudentNumericGrade();
        inst.data.setStudentLetterGrade(inst.grader.assignLetterGradeFromCalculations(letterGradeQuota, studentNumericGrade));
    }

}
