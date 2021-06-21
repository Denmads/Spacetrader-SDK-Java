package spacetraderapi.entities;

import java.util.List;

public class Leaderboard {
    private List<LeaderboardEntry> topPlayers;

    public Leaderboard(List<LeaderboardEntry> topPlayers) {
        this.topPlayers = topPlayers;
    }

    public List<LeaderboardEntry> getTopPlayers() {
        return topPlayers;
    }

    @Override
    public String toString() {
        return "Leaderboard{" +
                "topPlayers=" + topPlayers +
                '}';
    }
}
