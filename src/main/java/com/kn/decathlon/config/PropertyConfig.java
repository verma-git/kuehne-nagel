package com.kn.decathlon.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.kn.decathlon.constants.ApplicationConstants;
import com.kn.decathlon.execption.DecathlonAppException;
import com.kn.decathlon.execption.ExceptionType;

public class PropertyConfig {

	private static final Properties prop = new Properties();
	private PropertyConfig() {
	}

	public static Properties props() {
		try (InputStream input = new FileInputStream(ApplicationConstants.PROPERTY_FILE_PATH)) {
			prop.load(input);
		} catch (IOException ex) {
			throw new DecathlonAppException(ex.getLocalizedMessage(), ExceptionType.ERROR);
		}
		return prop;
	}
}