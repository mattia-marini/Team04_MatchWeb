package mmarini.unitn.team04_matchweb.model.dto.rest;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Match {

    private int id;

    private Team homeTeam;

    private Team awayTeam;

    private Championship championship;

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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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