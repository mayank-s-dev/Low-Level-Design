package CrickbuzzLowLevelDesign.Team;

import CrickbuzzLowLevelDesign.Innings.Balls;
import CrickbuzzLowLevelDesign.Innings.Overs;
import CrickbuzzLowLevelDesign.Team.Player.Player;

public class Wicket {
    public WicketType wicketType;
    public Player takenBy;
    public Overs overDetail;
    public Balls ballDetail;

    public Wicket(WicketType wicketType, Player takenBy, Overs overDetail, Balls ballDetail) {
        this.wicketType = wicketType;
        this.takenBy = takenBy;
        this.overDetail = overDetail;
        this.ballDetail = ballDetail;
    }
}
