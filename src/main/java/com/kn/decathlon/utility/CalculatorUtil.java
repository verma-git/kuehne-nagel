package com.kn.decathlon.utility;

import java.time.LocalTime;

import com.kn.decathlon.execption.DecathlonAppException;
import com.kn.decathlon.execption.ExceptionType;

public class CalculatorUtil {

    public static double stringToSeconds(String value) {
        try {
            String[] time = value.trim().split("\\.");
            LocalTime lTime = LocalTime.of(0, Integer.parseInt(time[0]), Integer.parseInt(time[1]), Integer.parseInt(time[2]));
            return lTime.toSecondOfDay();
        } catch (Exception ex) {
            throw new DecathlonAppException("Exception in Util", ExceptionType.CALCULATOR_EXCEPTION);
        }
    }
    
    public static double stringToDouble(String value) {
        try {
        	return Double.parseDouble(value);
        } catch (Exception ex) {
        	return stringToSeconds(value);
        }
    }
}
