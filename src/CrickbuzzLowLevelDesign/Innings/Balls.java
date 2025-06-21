package CrickbuzzLowLevelDesign.Innings;

import CrickbuzzLowLevelDesign.ScoreUpdater.BattingScoreUpdater;
import CrickbuzzLowLevelDesign.ScoreUpdater.BowlingScoreUpdater;
import CrickbuzzLowLevelDesign.ScoreUpdater.ScoreUpdater;
import CrickbuzzLowLevelDesign.Team.Player.Player;
import CrickbuzzLowLevelDesign.Team.Team;
import CrickbuzzLowLevelDesign.Team.Wicket;
import CrickbuzzLowLevelDesign.Team.WicketType;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    public int ballNo;
    public BallType ballType;
    public RunType runType;
    public Player playedBy;
    public Player bowledBy;
    public Wicket wicket;

    List<ScoreUpdater> scoreUpdaterObserverList = new ArrayList<>();

    public Balls(int ballNumber) {
        this.ballNo = ballNumber;
        scoreUpdaterObserverList.add(new BowlingScoreUpdater());
        scoreUpdaterObserverList.add(new BattingScoreUpdater());
    }

    public void startDelivery(Team battingTeam, Team bowlingTeam, Overs over) {
        this.playedBy = battingTeam.getStrikerBatsman();
        this.bowledBy = over.overBowledBy;

        this.ballType = BallType.NORMAL;
        if (isWicketTaken()) {
            this.runType = RunType.ZERO;
            //considering only BOLD
            this.wicket = new Wicket(WicketType.BOLD, bowlingTeam.getCurrentBowler(), over, this);
            //making only striker out for now
            battingTeam.setStrikerBatsman(null);
        } else {
            this.runType = getRunType();

            if (this.runType == RunType.ONE || this.runType == RunType.THREE) {
                //swap striker and non striker
                Player temp = battingTeam.getStrikerBatsman();
                battingTeam.setStrikerBatsman(battingTeam.getNonStrikerBatsman());
                battingTeam.setNonStrikerBatsman(temp);
            }
        }

        //update player scoreboard
        notifyScoreUpdaters(this);


    }

    private void notifyScoreUpdaters(Balls ballDetails) {
        for (ScoreUpdater scoreUpdater : scoreUpdaterObserverList) {
            scoreUpdater.update(ballDetails);
        }
    }

    private RunType getRunType() {
        double val = Math.random();
        if (val <= 0.2) {
            return RunType.ONE;
        } else if (val >= 0.3 && val <= 0.5) {
            return RunType.TWO;
        } else if (val >= 0.6 && val <= 0.8) {
            return RunType.FOUR;
        } else {
            return RunType.SIX;
        }
    }

    private boolean isWicketTaken() {
        //random function return value between 0 and 1
        return Math.random() < 0.2;
    }
}
