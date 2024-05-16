package CrickbuzzLowLevelDesign;

import CrickbuzzLowLevelDesign.Innings.InningsDetails;
import CrickbuzzLowLevelDesign.Team.Team;

import java.util.Date;

public class Match {
    Team teamA;
    Team teamB;

    Date matchDate;
    String venue;
    Team tossWinner;
    InningsDetails[] innings;
    MatchType matchType;
}
