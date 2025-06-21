package CrickbuzzLowLevelDesign.Team;

import CrickbuzzLowLevelDesign.Team.Player.Player;
import CrickbuzzLowLevelDesign.Team.Player.PlayerBattingController;
import CrickbuzzLowLevelDesign.Team.Player.PlayerBowlingController;

import java.util.List;
import java.util.Queue;

public class Team {
    String teamName;
    Queue<Player> playingEleven;
    List<Player> extraPlayers;

    PlayerBattingController playerBattingController;
    PlayerBowlingController playerBowlingController;
    public boolean isWinner;

    public Team(String teamName, Queue<Player> playingEleven, List<Player> bowlers, List<Player> extraPlayers) {
        this.teamName = teamName;
        this.playingEleven = playingEleven;
        this.extraPlayers = extraPlayers;
        this.playerBattingController = new PlayerBattingController(playingEleven);
        this.playerBowlingController = new PlayerBowlingController(bowlers);
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void selectNextBatsman() throws Exception {
        this.playerBattingController.getNextBatsman();
    }

    public void selectNextBowler(int maxOverCountPerBowler) {
        this.playerBowlingController.getNextBowler(maxOverCountPerBowler);
    }

    public Player getStrikerBatsman() {
        return this.playerBattingController.getStrikeBatsman();
    }

    public void setStrikerBatsman(Player player) {
        this.playerBattingController.setStrikeBatsman(player);
    }

    public Player getNonStrikerBatsman() {
        return this.playerBattingController.getNonStrikeBatsman();
    }

    public void setNonStrikerBatsman(Player player) {
        this.playerBattingController.setNonStrikeBatsman(player);
    }

    public Player getCurrentBowler() {
        return this.playerBowlingController.getCurrentBowler();
    }

    public void printBattingScoreCard() {
        for (Player batsman : this.playingEleven) {
            batsman.printPlayerBattingScoreCard();
        }
    }

    public void printBowlingScoreCard() {
        for (Player bowler : this.playingEleven) {
            if (bowler.bowlingScoreCard.overBowled > 0) {
                bowler.printPlayerBowlingScoreCard();
            }
        }
    }

    public int getTotalRuns() {
        int totalRun = 0;
        for (Player player : this.playingEleven) {
            totalRun += player.battingScoreCard.totalRuns;
        }

        return totalRun;
    }
}
