package madsj.entities;

import java.time.LocalDateTime;
import java.util.Date;

public class Account {
    private String username;
    private int credits;
    private int shipCount;
    private int structureCount;
    private LocalDateTime joinedAt;

    public Account(String username, int credits, int shipCount, int structureCount, LocalDateTime joinedAt) {
        this.username = username;
        this.credits = credits;
        this.shipCount = shipCount;
        this.structureCount = structureCount;
        this.joinedAt = joinedAt;
    }

    public String getUsername() {
        return username;
    }

    public int getCredits() {
        return credits;
    }

    public int getShipCount() {
        return shipCount;
    }

    public int getStructureCount() {
        return structureCount;
    }

    public LocalDateTime getJoinedAt() {
        return joinedAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", credits=" + credits +
                ", shipCount=" + shipCount +
                ", structureCount=" + structureCount +
                ", joinedAt=" + joinedAt +
                '}';
    }
}
