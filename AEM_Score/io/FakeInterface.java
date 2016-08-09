package AEM_Score.io;

import AEM_Score.computation.Acquisition;
import AEM_Score.util.Constants;


public class FakeInterface {

    Acquisition acquisition;

    int[] historicalAverages = new int[Constants.MAX_LETTERGRADE_QUANTITY];
    int[] classScoreRanges = new int[Constants.MAX_GRADE_RANGE_QUANTITY];

    public void test(Acquisition acquisition) {
        this.acquisition = acquisition;
        useHistoricalAverages_Summer2016();
        useExam2Stats();
        setUserScore(50);                                       // student's exam 2 score
    }

    public void useHistoricalAverages_Summer2016() {
        setHistoricalAverages(27, 24, 31, 5, 12);               // A, B, C, D, F
    }

    public void useExam2Stats() {
        setClassScoreRanges(0, 0, 3, 4, 6, 12, 9, 9, 2, 2);     // high to low; 100-90, 89-80, 79-70, ...
    }

    public void setHistoricalAverages(int A, int B, int C, int D, int F) {
        historicalAverages[4] = A;
        historicalAverages[3] = B;
        historicalAverages[2] = C;
        historicalAverages[1] = D;
        historicalAverages[0] = F;
        acquisition.setHistoricalAverages(historicalAverages);
    }

    public void setClassScoreRanges(int r10, int r9, int r8, int r7, int r6,
                                    int r5, int r4, int r3, int r2, int r1) {
        classScoreRanges[9] = r10;
        classScoreRanges[8] = r9;
        classScoreRanges[7] = r8;
        classScoreRanges[6] = r7;
        classScoreRanges[5] = r6;
        classScoreRanges[4] = r5;
        classScoreRanges[3] = r4;
        classScoreRanges[2] = r3;
        classScoreRanges[1] = r2;
        classScoreRanges[0] = r1;
        acquisition.setClassScoreRanges(classScoreRanges);
    }

    public void setUserScore(int userScore) {
        acquisition.setUserScore(userScore);
    }
}
