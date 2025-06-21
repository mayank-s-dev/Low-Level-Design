package CrickbuzzLowLevelDesign.Innings;

import CrickbuzzLowLevelDesign.MatchType;
import CrickbuzzLowLevelDesign.Team.Player.Player;
import CrickbuzzLowLevelDesign.Team.Team;

import java.util.ArrayList;
import java.util.List;

public class InningsDetails {
    Team battingTeam;
    Team bowlingTeam;
    MatchType matchType;
    List<Overs> oversList;

    public InningsDetails(Team battingTeam, Team bowlingTeam, MatchType matchType) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.matchType = matchType;
        this.oversList = new ArrayList<>();
    }

    public void startInnings(int runsToWin) throws Exception {
        try {
            this.battingTeam.selectNextBatsman();
        } catch (Exception e) {
            System.out.println("Some error occurred");
        }

        int noOfOvers = matchType.numberOfOvers();
        for (int overNumber = 1; overNumber <= noOfOvers; overNumber++) {
            this.bowlingTeam.selectNextBowler(matchType.maxOverPerBowler());
            Overs over = new Overs(overNumber, bowlingTeam.getCurrentBowler());
            oversList.add(over);
            try {
                boolean won = over.startOver(battingTeam, bowlingTeam, runsToWin);
                if (won) {
                    break;
                }
            } catch (Exception e) {
                break;
            }

            // after over swap batsman
            Player temp = battingTeam.getStrikerBatsman();
            battingTeam.setStrikerBatsman(battingTeam.getNonStrikerBatsman());
            battingTeam.setNonStrikerBatsman(temp);
        }
    }

    public int getTotalRuns() {
        return battingTeam.getTotalRuns();
    }
}
