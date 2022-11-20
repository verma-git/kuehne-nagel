package com.kn.decathlon.entity;

import com.kn.decathlon.constants.EventParameterValue;

public class Event {
	private double athletePoint;
	private EventParameterValue eventParameterValue;
	
	public double getAthletePoint() {
		return athletePoint;
	}
	public void setAthletePoint(double athletePoint) {
		this.athletePoint = athletePoint;
	}
	public EventParameterValue getEventParameterValue() {
		return eventParameterValue;
	}
	public void setEventParameterValue(EventParameterValue eventParameterValue) {
		this.eventParameterValue = eventParameterValue;
	}

}
