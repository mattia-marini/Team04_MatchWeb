package mmarini.unitn.team04_matchweb.service;

import org.springframework.stereotype.Service;
import mmarini.unitn.team04_matchweb.client.ChampionshipNewClient;
import mmarini.unitn.team04_matchweb.client.MatchCalendarClient;
import mmarini.unitn.team04_matchweb.client.MatchResultsClient;
import mmarini.unitn.team04_matchweb.client.TeamClient;
import mmarini.unitn.team04_matchweb.model.RestDTO.ChampionshipNew;
import mmarini.unitn.team04_matchweb.model.RestDTO.Match;
import mmarini.unitn.team04_matchweb.model.RestDTO.Team;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class PartiteWebService {

    private final ChampionshipNewClient championshipNewClient;
    private final MatchCalendarClient matchCalendarClient;
    private final MatchResultsClient matchResultsClient;
    private final TeamClient teamClient;

    public PartiteWebService(ChampionshipNewClient championshipNewClient, MatchCalendarClient matchCalendarClient, MatchResultsClient matchResultsClient, TeamClient teamClient) {
        this.championshipNewClient = championshipNewClient;
        this.matchCalendarClient = matchCalendarClient;
        this.matchResultsClient = matchResultsClient;
        this.teamClient = teamClient;
    }

    public ChampionshipNew getRandomChampionshipNew() {
        return championshipNewClient.getRandomChampionshipNew();
    }

    public Map<Integer, Map<LocalDate, List<Match>>> getMatchCalendar() {
        return matchCalendarClient.getMatchCalendar();
    }

    public Map<Integer, List<Match>> getMatchCalendarByDate(LocalDate date) {
        return matchCalendarClient.getMatchCalendarByDate(date);
    }

    public Map<Integer, Map<Integer, Integer>> getMatchResultsByDate(LocalDate date) {
        return matchResultsClient.getMatchResultsByDate(date);
    }

    public Map<Integer, Integer> getMatchResultsByDateAndChampionshipId(LocalDate date, Integer championshipId) {
        return matchResultsClient.getMatchResultsByDateAndChampionshipId(date, championshipId);
    }

    public List<Team> getAllTeams() {
        return teamClient.getAllTeams();
    }
}