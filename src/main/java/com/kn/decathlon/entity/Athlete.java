package com.kn.decathlon.entity;

import java.util.List;

public class Athlete {
    private String name;
    private double totalPoints;
    private List<Event> event;
    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Event> getEvent() {
		return event;
	}
	public void setEvent(List<Event> event) {
		this.event = event;
	}
	public double getTotalPoints() {
		return totalPoints;
	}
	public void setTotalPoints(double totalPoints) {
		this.totalPoints = totalPoints;
	}
	
	@Override
	public String toString() {
		return this.name + " Earns - " + this.totalPoints;
	}

}
