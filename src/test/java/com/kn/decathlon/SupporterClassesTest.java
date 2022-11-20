package com.kn.decathlon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.kn.decathlon.config.PropertyConfig;
import com.kn.decathlon.execption.DecathlonAppException;
import com.kn.decathlon.utility.CalculatorUtil;

public class SupporterClassesTest {
    @Test
    public void calculatorUtilNormalTest() {
    	double d = CalculatorUtil.stringToDouble("1.0");
    	assertEquals(1.0, d);
    }
    
    @Test
    public void calculatorUtilTimeTest() {
    	double d = CalculatorUtil.stringToDouble("1.1.1");
    	assertEquals(61.0, d);
    }
    
    @Test
    public void calculatorUtilExceptionTest() {
    	assertThrows(DecathlonAppException.class,()->CalculatorUtil.stringToDouble("Gaurav"));
    }
    
    @Test
    public void propertyConfigTest() {
    	String s = PropertyConfig.props().getProperty("input.file.name");
    	assertEquals("results.csv", s);
    }
}
