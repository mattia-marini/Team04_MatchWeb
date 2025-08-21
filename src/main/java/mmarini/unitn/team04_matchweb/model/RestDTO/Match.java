package mmarini.unitn.team04_matchweb.model.RestDTO;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@IdClass(MatchId.class)
@Check(constraints = "home_team <> away_team")
public class Match {

    @Id
    @ManyToOne
    @JoinColumn(name = "home_team", nullable = false)
    private Team homeTeam;

    @Id
    @ManyToOne
    @JoinColumn(name = "away_team", nullable = false)
    private Team awayTeam;

    @Id
    @ManyToOne
    @JoinColumn(name = "championship_id", nullable = false)
    private Championship championship;

    @Id
    @Column(nullable = false)
    private LocalDateTime dateTime;

    // Constructors
    public Match() {
    }

    public Match(Team homeTeam, Team awayTeam, Championship championship, LocalDateTime dateTime) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.championship = championship;
        this.dateTime = dateTime;
    }

    // Getters and Setters
    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Championship getChampionship() {
        return championship;
    }

    public void setChampionship(Championship championship) {
        this.championship = championship;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime date) {
        this.dateTime = date;
    }

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }
}