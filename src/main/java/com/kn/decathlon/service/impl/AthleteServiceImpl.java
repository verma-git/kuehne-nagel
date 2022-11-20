package com.kn.decathlon.service.impl;

import com.kn.decathlon.entity.Athlete;
import com.kn.decathlon.factory.PointsCalculatorFactory;
import com.kn.decathlon.service.AthleteService;
import com.kn.decathlon.service.PointCalculator;

public class AthleteServiceImpl implements AthleteService {

	@Override
	public Athlete calculateTotalPoints(Athlete athlete) {
		double finalPoint = athlete.getEvent().stream().mapToDouble(e -> {
			PointCalculator calculator = PointsCalculatorFactory.getPointsCalculator(e);
			return calculator.calculatePoints(e);
		}).sum();
		athlete.setTotalPoints(finalPoint);
		return athlete;
	}

}
