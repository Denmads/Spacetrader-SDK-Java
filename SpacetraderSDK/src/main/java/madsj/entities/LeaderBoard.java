package madsj.entities;

import java.util.List;

public class LeaderBoard {
    private List<LeaderBoardEntry> topPlayers;

    public LeaderBoard(List<LeaderBoardEntry> topPlayers) {
        this.topPlayers = topPlayers;
    }

    public List<LeaderBoardEntry> getTopPlayers() {
        return topPlayers;
    }

    @Override
    public String toString() {
        return "Leaderboard{" +
                "topPlayers=" + topPlayers +
                '}';
    }
}
