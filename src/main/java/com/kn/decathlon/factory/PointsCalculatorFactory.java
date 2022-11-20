package com.kn.decathlon.factory;

import com.kn.decathlon.constants.EventType;
import com.kn.decathlon.entity.Event;
import com.kn.decathlon.execption.DecathlonAppException;
import com.kn.decathlon.execption.ExceptionType;
import com.kn.decathlon.service.PointCalculator;
import com.kn.decathlon.service.point.impl.JumpingPointImpl;
import com.kn.decathlon.service.point.impl.RunningPointImpl;
import com.kn.decathlon.service.point.impl.ThrowingPointImpl;

public class PointsCalculatorFactory {
	
	public static PointCalculator getPointsCalculator(Event event) {
		
		if(event.getEventParameterValue().getEventType() == EventType.JUMPING)
			return new JumpingPointImpl();
		else if(event.getEventParameterValue().getEventType() == EventType.RUNNING)
			return new RunningPointImpl();
		else if(event.getEventParameterValue().getEventType() == EventType.THROWING)
			return new ThrowingPointImpl();
		else {
			throw new DecathlonAppException("Event Not Matched No calculator found",
					ExceptionType.CALCULATOR_EXCEPTION);
		}
	}
	

}
