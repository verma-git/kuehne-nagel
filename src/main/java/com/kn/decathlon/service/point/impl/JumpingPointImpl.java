package com.kn.decathlon.service.point.impl;

import com.kn.decathlon.constants.ApplicationConstants;
import com.kn.decathlon.entity.Event;
import com.kn.decathlon.service.PointCalculator;

public class JumpingPointImpl implements PointCalculator {

	@Override
	public double calculatePoints(Event event) {
		return event.getEventParameterValue().getParameter_A() * Math.pow(
				event.getAthletePoint() * ApplicationConstants.INT_HUNDRED
						- event.getEventParameterValue().getParameter_B(),
				event.getEventParameterValue().getParameter_C());
	}

}
