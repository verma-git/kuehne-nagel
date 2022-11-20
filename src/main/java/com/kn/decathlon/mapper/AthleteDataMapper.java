package com.kn.decathlon.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.kn.decathlon.constants.EventParameterValue;
import com.kn.decathlon.entity.Athlete;
import com.kn.decathlon.entity.Event;
import com.kn.decathlon.utility.CalculatorUtil;

public class AthleteDataMapper {
	
	public static List<Athlete> map(List<List<String>> row) {
		List<Athlete> athletes  = new ArrayList<>();
		row.stream().forEach(a -> {
			Athlete athlete =  converter(a);
			if(athlete!=null)
				athletes.add(athlete);
		});
		return athletes;
	}
	
	private static Athlete converter(List<String> sList) {
		if (sList.isEmpty() || sList.size() == 0)
			return null;
		else {
			Athlete athlete = new Athlete();
			athlete.setName(sList.get(0));
			List<Event> events = new ArrayList<>();
			IntStream.range(1, sList.size()).forEach(idx -> {
				Event event = new Event();
				event.setAthletePoint(sList.get(idx) != null? CalculatorUtil.stringToDouble(sList.get(idx)) : 0);
				event.setEventParameterValue(EventParameterValue.values()[idx-1]);
				events.add(event);
			});
			athlete.setEvent(events);
			return athlete;
		}
	}

}
