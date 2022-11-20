package com.kn.decathlon.entity;

public class Result {
	
    private String athleteName;
    private int totalPoints;
    private String rank;
	public String getAthleteName() {
		return athleteName;
	}
	public void setAthleteName(String athleteName) {
		this.athleteName = athleteName;
	}
	public int getTotalPoints() {
		return totalPoints;
	}
	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
    
    @Override
	public String toString() {
		return this.getAthleteName() + " 's Total Score is - " + this.getTotalPoints() + " And The Rank is - "
				+ this.getRank();
	}

}
