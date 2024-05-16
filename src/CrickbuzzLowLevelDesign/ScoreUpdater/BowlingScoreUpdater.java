package CrickbuzzLowLevelDesign.ScoreUpdater;

import CrickbuzzLowLevelDesign.Innings.BallType;
import CrickbuzzLowLevelDesign.Innings.Balls;
import CrickbuzzLowLevelDesign.Innings.RunType;
import CrickbuzzLowLevelDesign.Team.Player.Player;

public class BowlingScoreUpdater implements ScoreUpdater {
    @Override
    public void update(Balls ballDetails) {
        Player currBowler = ballDetails.bowledBy;
        if (ballDetails.ballNo == 6 && ballDetails.ballType == BallType.NORMAL) {
            currBowler.bowlingScoreCard.overBowled += 1;
        }

        if (RunType.ONE == ballDetails.runType) {
            currBowler.bowlingScoreCard.runsConceded += 1;
        } else if (RunType.TWO == ballDetails.runType) {
            currBowler.bowlingScoreCard.runsConceded += 2;
        } else if (RunType.FOUR == ballDetails.runType) {
            currBowler.bowlingScoreCard.runsConceded += 4;
        } else if (RunType.SIX == ballDetails.runType) {
            currBowler.bowlingScoreCard.runsConceded += 6;
        }

        if (ballDetails.ballType == BallType.NOBALL) {
            currBowler.bowlingScoreCard.noBalls += 1;
        }


        if (ballDetails.ballType == BallType.WIDEBALL) {
            currBowler.bowlingScoreCard.wideBalls += 1;
        }

        if (ballDetails.wicket != null) {
            currBowler.bowlingScoreCard.wicketsTakes += 1;
        }
    }
}
