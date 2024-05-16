package CrickbuzzLowLevelDesign.Team.Player;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PlayerBowlingController {
    Deque<Player> bowlers;
    Map<Player, Integer> bowlerOverCount;
    Player currentBowler;

    public PlayerBowlingController(List<Player> bowlers) {
        setBowlersList(bowlers);
    }

    private void setBowlersList(List<Player> bowlers) {
        this.bowlers = new LinkedList<>();
        this.bowlers.addAll(bowlers);
        for (Player bowler : bowlers) {
            this.bowlers.addLast(bowler);
            bowlerOverCount.put(bowler, 0);
        }
    }

    public void getNextBowler(int maxOverCountPerBowler) {
        Player bowler = this.bowlers.poll();
        if (bowlerOverCount.get(bowler) + 1 == maxOverCountPerBowler) {
            // this means it is the last over of bowler
            this.setCurrentBowler(bowler);
        } else {
            // this means, bowler can bowl one more over so moving it to the end of list
            this.setCurrentBowler(bowler);
            this.bowlers.addLast(bowler);
            bowlerOverCount.put(bowler, bowlerOverCount.get(bowler) + 1);
        }
    }

    public Player getCurrentBowler() {
        return currentBowler;
    }

    public void setCurrentBowler(Player currentBowler) {
        this.currentBowler = currentBowler;
    }
}
