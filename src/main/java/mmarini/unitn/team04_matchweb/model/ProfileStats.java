package mmarini.unitn.team04_matchweb.model;

public class ProfileStats {
    private int pointsToday;
    private int rankingPosition;
    private int totalBets;

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
