package madsj.entities;

public class LeaderboardEntry {
    private String username;
    private int rank;
    private int netWorth;

    public LeaderboardEntry(String username, int rank, int netWorth) {
        this.username = username;
        this.rank = rank;
        this.netWorth = netWorth;
    }

    public String getUsername() {
        return username;
    }

    public int getRank() {
        return rank;
    }

    public int getNetWorth() {
        return netWorth;
    }

    @Override
    public String toString() {
        return "LeaderboardEntry{" +
                "username='" + username + '\'' +
                ", rank=" + rank +
                ", netWorth=" + netWorth +
                '}';
    }
}
