package CrickbuzzLowLevelDesign.Team.Player;

import java.util.LinkedList;
import java.util.Queue;

public class PlayerBattingController {
    Queue<Player> yetToPlay;
    Player strikeBatsman;
    Player nonStrikeBatsman;

    public PlayerBattingController(Queue<Player> playingEleven) {
        this.yetToPlay = new LinkedList<>();
        // addAll is a LinkedList function
        this.yetToPlay.addAll(playingEleven);
    }

    public void getNextBatsman() throws Exception {
        if (this.yetToPlay == null) {
            throw new Exception();
        }

        if (this.strikeBatsman == null) {
            this.strikeBatsman = this.yetToPlay.poll();
        }

        if (this.nonStrikeBatsman == null) {
            this.nonStrikeBatsman = this.yetToPlay.poll();
        }
    }

    public Queue<Player> getYetToPlay() {
        return yetToPlay;
    }

    public void setYetToPlay(Queue<Player> yetToPlay) {
        this.yetToPlay = yetToPlay;
    }

    public Player getStrikeBatsman() {
        return strikeBatsman;
    }

    public void setStrikeBatsman(Player strikeBatsman) {
        this.strikeBatsman = strikeBatsman;
    }

    public Player getNonStrikeBatsman() {
        return nonStrikeBatsman;
    }

    public void setNonStrikeBatsman(Player nonStrikeBatsman) {
        this.nonStrikeBatsman = nonStrikeBatsman;
    }
}
