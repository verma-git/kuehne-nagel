package com.kn.decathlon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.kn.decathlon.constant.DecathlonTestConstant;
import com.kn.decathlon.entity.Athlete;
import com.kn.decathlon.execption.DecathlonAppException;
import com.kn.decathlon.mapper.AthleteDataMapper;
import com.kn.decathlon.service.AthleteService;
import com.kn.decathlon.service.InputFileProcessor;
import com.kn.decathlon.service.impl.AthleteServiceImpl;
import com.kn.decathlon.service.impl.CsvFileProcessor;

public class ReaderTest {
    @Test
    public void normalTest() {
    	AthleteService service = new AthleteServiceImpl();
    	InputFileProcessor ifp = new CsvFileProcessor();
		List<List<String>> result = ifp.read(DecathlonTestConstant.ALL_EVENT_CSV);
		List<Athlete> lA = AthleteDataMapper.map(result);
    	Athlete athlete = service.calculateTotalPoints(lA.get(0));
		assertEquals(4208, (int)athlete.getTotalPoints());
    }
    
    @Test
    public void exceptionTest() {
    	InputFileProcessor ifp = new CsvFileProcessor();
    	assertThrows(DecathlonAppException.class,()->ifp.read("NA"));
    }
}
