package CrickbuzzLowLevelDesign.ScoreUpdater;

import CrickbuzzLowLevelDesign.Innings.Balls;
import CrickbuzzLowLevelDesign.Innings.RunType;
import CrickbuzzLowLevelDesign.Team.Player.Player;

public class BattingScoreUpdater implements ScoreUpdater {
    @Override
    public void update(Balls ballDetails) {
        int run = 0;
        Player currBatsman = ballDetails.playedBy;
        if (ballDetails.runType == RunType.ONE) {
            run = 1;
        } else if (ballDetails.runType == RunType.TWO) {
            run = 2;
        } else if (ballDetails.runType == RunType.FOUR) {
            run = 4;
            currBatsman.battingScoreCard.fours += 1;
        } else if (ballDetails.runType == RunType.SIX) {
            run = 6;
            currBatsman.battingScoreCard.sixes += 1;
        }

        currBatsman.battingScoreCard.totalRuns += run;
        currBatsman.battingScoreCard.totalBallsPlayed += 1;

        if (ballDetails.wicket != null) {
            currBatsman.battingScoreCard.wicketDetails = ballDetails.wicket;
        }
    }
}
