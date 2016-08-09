package AEM_Score.computation;

import AEM_Score.util.Constants;


public class Acquisition {

    int[] historicalAverages = new int[Constants.MAX_LETTERGRADE_QUANTITY];
    int[] classScoreRanges = new int[Constants.MAX_GRADE_RANGE_QUANTITY];
    int userScore;

    public Acquisition () {

    }

    public int[] getHistoricalAverages() {
        return this.historicalAverages;
    }

    public int[] getClassScoreRanges() {
        return this.classScoreRanges;
    }

    public int getUserScore() {
        return this.userScore;
    }


    public void setHistoricalAverages(int[] historicalAverages) {
        this.historicalAverages = historicalAverages;
    }

    public void setClassScoreRanges(int[] classScoreRanges) {
        this.classScoreRanges = classScoreRanges;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }
}
