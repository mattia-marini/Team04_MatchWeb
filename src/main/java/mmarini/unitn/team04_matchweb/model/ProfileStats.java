package mmarini.unitn.team04_matchweb.model;

import java.util.List;

public class ProfileStats {
    private int pointsToday;
    private int rankingPosition;
    private int totalBets;
    private List<Prize> prizes;


    public List<Prize> getPrizes() {
        return prizes;
    }

    public void setPrizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public int getPointsToday() {
        return pointsToday;
    }

    public void setPointsToday(int pointsToday) {
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
