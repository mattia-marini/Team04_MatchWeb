package mmarini.unitn.team04_matchweb.model.entity;


import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "BET")
@IdClass(BetId.class)
public class Bet {

    @Id
    @Column(nullable = false)
    private String username;

    @Id
    @Column(nullable = false)
    private LocalDateTime playedAt;

    @Column(nullable = false)
    private int score;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getPlayedAt() {
        return playedAt;
    }

    public void setPlayedAt(LocalDateTime playedAt) {
        this.playedAt = playedAt;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}


class BetId implements Serializable {
    private String username;
    private LocalDateTime playedAt;

    public BetId() {
    }

    public BetId(String username, LocalDateTime assignedAt) {
        this.username = username;
        this.playedAt = assignedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BetId)) return false;
        BetId that = (BetId) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(playedAt, that.playedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, playedAt);
    }
}
