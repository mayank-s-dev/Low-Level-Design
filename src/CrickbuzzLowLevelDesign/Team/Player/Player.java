package CrickbuzzLowLevelDesign.Team.Player;

import CrickbuzzLowLevelDesign.Team.Player.ScoreCards.BattingScoreCard;
import CrickbuzzLowLevelDesign.Team.Player.ScoreCards.BowlingScoreCard;

public class Player {
    Person person;
    PlayerType playerType;
    public BattingScoreCard battingScoreCard;
    public BowlingScoreCard bowlingScoreCard;

    public Player(Person person, PlayerType playerType) {
        this.person = person;
        this.playerType = playerType;
        this.battingScoreCard = new BattingScoreCard();
        this.bowlingScoreCard = new BowlingScoreCard();
    }

    public void printPlayerBattingScoreCard() {
        System.out.println("PlayerName: " + person.name + " -- totalRuns: " + battingScoreCard.totalRuns
                + " -- totalBallsPlayed: " + battingScoreCard.totalBallsPlayed + " -- 4s: " + battingScoreCard.fours
                + " -- 6s: " + battingScoreCard.sixes + " -- outby: " + ((battingScoreCard.wicketDetails != null) ? battingScoreCard.wicketDetails.takenBy.person.name : "notout"));
    }

    public void printPlayerBowlingScoreCard() {
        System.out.println("PlayerName: " + person.name + " -- totalOversThrown: " + bowlingScoreCard.overBowled
                + " -- totalRunsGiven: " + bowlingScoreCard.runsConceded + " -- WicketsTaken: " + bowlingScoreCard.wicketsTakes);
    }
}
