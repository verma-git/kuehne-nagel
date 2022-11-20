package com.kn.decathlon.service.impl;

import com.kn.decathlon.entity.Event;
import com.kn.decathlon.factory.PointsCalculatorFactory;
import com.kn.decathlon.service.PointCalculator;

public class PointsCalculatorImpl implements PointCalculator{

	@Override
	public double calculatePoints(Event event) {
		PointCalculator calculator = PointsCalculatorFactory.getPointsCalculator(event);
		return calculator.calculatePoints(event);
	}

}
