package CrickbuzzLowLevelDesign.Innings;

import CrickbuzzLowLevelDesign.Team.Player.Player;
import CrickbuzzLowLevelDesign.Team.Team;

import java.util.ArrayList;
import java.util.List;

public class Overs {
    int overNo;
    List<Balls> balls;
    int extraCount;
    Player overBowledBy;

    public Overs(int overNo, Player player) {
        this.overNo = overNo;
        this.overBowledBy = player;
        this.balls = new ArrayList<>();
    }

    public boolean startOver(Team battingTeam, Team bowlingTeam, int runsToWin) throws Exception {
        int ballCount = 1;
        while (ballCount <= 6) {
            Balls ball = new Balls(ballCount);

            ball.startDelivery(battingTeam, bowlingTeam, this);

            if (ball.ballType == BallType.NORMAL) {
                balls.add(ball);
                ballCount++;
                if (ball.wicket != null) {
                    battingTeam.selectNextBatsman();
                }

                if (runsToWin != -1 && battingTeam.getTotalRuns() >= runsToWin) {
                    battingTeam.isWinner = true;
                    return true;
                }
            } else {
                this.extraCount += 1;
            }
        }
        return false;
    }
}
