package com.kn.decathlon.constants;

public enum EventParameterValue {
	
    RUNNING_100M(EventType.RUNNING, 25.4347, 18.0, 1.81),
    LONG_JUMP(EventType.JUMPING, 0.14354, 220.0, 1.4),
    SHOT_PUT(EventType.THROWING, 51.39, 1.5, 1.05),
    HIGH_JUMP(EventType.JUMPING,0.8465, 75.0, 1.42),
    RUNNING_400M(EventType.RUNNING,1.53775, 82.0, 1.81),
    RUNNING_110M_H(EventType.RUNNING, 5.74352, 28.5, 1.92),
    DISCUS_THROW(EventType.THROWING,12.91, 4.0, 1.1),
    POLE_VAULT(EventType.JUMPING,0.2797, 100.0, 1.35),
    JAVELIN_THROW(EventType.THROWING,10.14, 7.0, 1.08),
    RUNNING_1500M(EventType.RUNNING,0.03768, 480.0, 1.85);

	
	private double parameter_A;
	private double parameter_B;
	private double parameter_C;
	private EventType eventType;
	
	EventParameterValue(EventType eventType, double a, double b, double c) {
		this.parameter_A = a;
		this.parameter_B = b;
		this.parameter_C = c;
		this.eventType = eventType;
	}

	public double getParameter_A() {
		return parameter_A;
	}

	public double getParameter_B() {
		return parameter_B;
	}

	public double getParameter_C() {
		return parameter_C;
	}

	public EventType getEventType() {
		return eventType;
	}

}
