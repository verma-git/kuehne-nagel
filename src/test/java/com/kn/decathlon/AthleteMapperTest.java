package com.kn.decathlon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.kn.decathlon.constant.DecathlonTestConstant;
import com.kn.decathlon.entity.Athlete;
import com.kn.decathlon.entity.Result;
import com.kn.decathlon.mapper.AthleteDataMapper;
import com.kn.decathlon.mapper.AthleteResultMapper;
import com.kn.decathlon.service.InputFileProcessor;
import com.kn.decathlon.service.impl.CsvFileProcessor;

public class AthleteMapperTest {
	

	@Test
	public void mapAllEventData(){
		InputFileProcessor ifp = new CsvFileProcessor();
		List<List<String>> result = ifp.read(DecathlonTestConstant.ALL_EVENT_CSV);
		
		List<Athlete> lA = AthleteDataMapper.map(result);
		List<Result> rA = AthleteResultMapper.map(lA);
		
		assertEquals("John Smith", lA.get(0).getName());
		assertEquals("John Smith", rA.get(0).getAthleteName());
		
	}
	
	
	@Test
	public void mapPartialEventData(){
		InputFileProcessor ifp = new CsvFileProcessor();
		List<List<String>> result = ifp.read(DecathlonTestConstant.PARTIAL_EVENT_CSV);
		List<Athlete> lA = AthleteDataMapper.map(result);
		assertEquals("John Smith", lA.get(0).getName());
		
	}

	@Test
	public void mapSameScoreEventData(){
		InputFileProcessor ifp = new CsvFileProcessor();
		List<List<String>> result = ifp.read(DecathlonTestConstant.SAME_POINT_EVENT_CSV);
		List<Athlete> lA = AthleteDataMapper.map(result);
		assertEquals(lA.get(1).getTotalPoints(), lA.get(0).getTotalPoints());
	}
	
	@Test
	public void mapEmptyEventData(){
		InputFileProcessor ifp = new CsvFileProcessor();
		List<List<String>> result = ifp.read(DecathlonTestConstant.PARTIAL_EVENT_CSV);
		result.add(new ArrayList<>());
		List<Athlete> lA = AthleteDataMapper.map(result);
		assertEquals(1, lA.size());
	}
	
	@Test
	public void mapSameScoreEventDataForResult(){
		InputFileProcessor ifp = new CsvFileProcessor();
		List<List<String>> result = ifp.read(DecathlonTestConstant.SAME_POINT_EVENT_CSV);
		List<Athlete> lA = AthleteDataMapper.map(result);
		lA.get(0).setTotalPoints(989);
		lA.get(1).setTotalPoints(989);
		List<Result> rA = AthleteResultMapper.map(lA);
		assertEquals(rA.get(1).getTotalPoints(), rA.get(0).getTotalPoints());
	}

	@Test
	public void athleteToStringTest(){
		InputFileProcessor ifp = new CsvFileProcessor();
		List<List<String>> result = ifp.read(DecathlonTestConstant.PARTIAL_EVENT_CSV);
		List<Athlete> lA = AthleteDataMapper.map(result);
		lA.get(0).setTotalPoints(989);
		Athlete athlete = lA.get(0);
		assertEquals("John Smith Earns - 989.0", athlete.toString());
	}
	
	@Test
	public void resultToStringTest(){
		InputFileProcessor ifp = new CsvFileProcessor();
		List<List<String>> result = ifp.read(DecathlonTestConstant.ALL_EVENT_CSV);
		List<Athlete> lA = AthleteDataMapper.map(result);
		lA.get(0).setTotalPoints(989);
		List<Result> rA = AthleteResultMapper.map(lA);
		Result rO = rA.get(0);
		assertEquals("John Smith 's Total Score is - 989 And The Rank is - 1", rO.toString());
	}
}
