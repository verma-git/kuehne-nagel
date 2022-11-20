package com.kn.decathlon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.kn.decathlon.constant.DecathlonTestConstant;
import com.kn.decathlon.constants.EventParameterValue;
import com.kn.decathlon.entity.Athlete;
import com.kn.decathlon.entity.Event;
import com.kn.decathlon.mapper.AthleteDataMapper;
import com.kn.decathlon.service.AthleteService;
import com.kn.decathlon.service.InputFileProcessor;
import com.kn.decathlon.service.impl.AthleteServiceImpl;
import com.kn.decathlon.service.impl.CsvFileProcessor;

public class AthleteServiceTest {

    @Test
    public void allPointCalculationTest() {
    	AthleteService service = new AthleteServiceImpl();
    	InputFileProcessor ifp = new CsvFileProcessor();
		List<List<String>> result = ifp.read(DecathlonTestConstant.ALL_EVENT_CSV);
		List<Athlete> lA = AthleteDataMapper.map(result);
    	Athlete athlete = service.calculateTotalPoints(lA.get(0));
		assertEquals(4208, (int)athlete.getTotalPoints());
    }
    
    @Test
    public void JumpPointCalculationTest() {
    	AthleteService service = new AthleteServiceImpl();
    	Athlete athlete = new Athlete();
    	athlete.setName("Gaurav");
    	List<Event> el = new ArrayList<>();
    	Event e = new Event();
    	e.setAthletePoint(1.0);
    	e.setEventParameterValue(EventParameterValue.HIGH_JUMP);
    	el.add(e);
    	athlete.setEvent(el);
    	Athlete result = service.calculateTotalPoints(athlete);
		assertEquals(81, (int)result.getTotalPoints());
    }
    
    
    @Test
    public void RunningPointCalculationTest() {
    	AthleteService service = new AthleteServiceImpl();
    	Athlete athlete = new Athlete();
    	athlete.setName("Gaurav");
    	List<Event> el = new ArrayList<>();
    	Event e = new Event();
    	e.setAthletePoint(1.0);
    	e.setEventParameterValue(EventParameterValue.RUNNING_100M);
    	el.add(e);
    	athlete.setEvent(el);
    	Athlete result = service.calculateTotalPoints(athlete);
		assertEquals(4290, (int)result.getTotalPoints());
    }
    
    @Test
    public void ThrowingPointCalculationTest() {
    	AthleteService service = new AthleteServiceImpl();
    	Athlete athlete = new Athlete();
    	athlete.setName("Gaurav");
    	List<Event> el = new ArrayList<>();
    	Event e = new Event();
    	e.setAthletePoint(100);
    	e.setEventParameterValue(EventParameterValue.JAVELIN_THROW);
    	el.add(e);
    	athlete.setEvent(el);
    	Athlete result = service.calculateTotalPoints(athlete);
		assertEquals(1355, (int)result.getTotalPoints());
    }
}
