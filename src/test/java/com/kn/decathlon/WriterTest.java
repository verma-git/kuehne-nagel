package com.kn.decathlon;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.kn.decathlon.constant.DecathlonTestConstant;
import com.kn.decathlon.entity.Result;
import com.kn.decathlon.execption.DecathlonAppException;
import com.kn.decathlon.service.OutputFileGenerator;
import com.kn.decathlon.service.impl.XmlFileGenerator;

public class WriterTest {
    @Test
    public void normalTest() {
    	List<Result> finalResult = new ArrayList<>();
    	Result r = new Result();
    	r.setAthleteName("Gaurav");
    	r.setRank("1");
    	r.setTotalPoints(100);
    	finalResult.add(r);
    	OutputFileGenerator out = new XmlFileGenerator();
    	out.generateFile(finalResult, DecathlonTestConstant.XML_OUTPUT);
    	assertTrue(true, "true");
    }
    
    @Test
    public void exceptionTest() {
    	OutputFileGenerator out = new XmlFileGenerator();
    	assertThrows(DecathlonAppException.class,()->out.generateFile(null, "NA"));
    }
}
