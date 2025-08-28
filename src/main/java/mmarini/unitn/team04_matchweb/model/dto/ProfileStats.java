package mmarini.unitn.team04_matchweb.model.dto;

import mmarini.unitn.team04_matchweb.model.entity.Prize;

import java.util.List;
import java.util.Optional;

public class ProfileStats {
    private Optional<Long> pointsToday;
    private int rankingPosition;
    private int totalBets;
    private List<Prize> prizes;


    public List<Prize> getPrizes() {
        return prizes;
    }

    public void setPrizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public Optional<Long> getPointsToday() {
        return pointsToday;
    }

    public void setPointsToday(Optional<Long> pointsToday) {
        this.pointsToday = pointsToday;
    }

    public int getRankingPosition() {
        return rankingPosition;
    }

    public void setRankingPosition(int rankingPosition) {
        this.rankingPosition = rankingPosition;
    }

    public int getTotalBets() {
        return totalBets;
    }

    public void setTotalBets(int totalBets) {
        this.totalBets = totalBets;
    }
}
