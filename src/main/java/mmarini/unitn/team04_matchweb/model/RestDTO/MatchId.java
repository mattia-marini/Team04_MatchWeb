package mmarini.unitn.team04_matchweb.model.RestDTO;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class MatchId implements Serializable {

    private String homeTeam;
    private String awayTeam;
    private Integer championship;
    private LocalDateTime dateTime;

    // Constructors
    public MatchId() {
    }

    public MatchId(String homeTeam, String awayTeam, Integer championship, LocalDateTime dateTime) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.championship = championship;
        this.dateTime = dateTime;
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchId matchId = (MatchId) o;
        return Objects.equals(homeTeam, matchId.homeTeam) &&
                Objects.equals(awayTeam, matchId.awayTeam) &&
                Objects.equals(championship, matchId.championship) &&
                Objects.equals(dateTime, matchId.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam, championship, dateTime);
    }
}