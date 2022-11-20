package com.kn.decathlon.service.point.impl;

import com.kn.decathlon.entity.Event;
import com.kn.decathlon.service.PointCalculator;

public class RunningPointImpl implements PointCalculator {

	@Override
	public double calculatePoints(Event event) {
		return event.getEventParameterValue().getParameter_A()
				* Math.pow(event.getEventParameterValue().getParameter_B() - event.getAthletePoint(),
						event.getEventParameterValue().getParameter_C());
	}

}
