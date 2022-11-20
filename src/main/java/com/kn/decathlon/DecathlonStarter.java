package com.kn.decathlon;

import java.util.List;
import java.util.stream.Collectors;

import com.kn.decathlon.config.PropertyConfig;
import com.kn.decathlon.constants.ApplicationConstants;
import com.kn.decathlon.entity.Athlete;
import com.kn.decathlon.entity.Result;
import com.kn.decathlon.mapper.AthleteDataMapper;
import com.kn.decathlon.mapper.AthleteResultMapper;
import com.kn.decathlon.service.AthleteService;
import com.kn.decathlon.service.InputFileProcessor;
import com.kn.decathlon.service.OutputFileGenerator;
import com.kn.decathlon.service.impl.AthleteServiceImpl;
import com.kn.decathlon.service.impl.CsvFileProcessor;
import com.kn.decathlon.service.impl.XmlFileGenerator;

public class DecathlonStarter {
	private static InputFileProcessor inputFileProcessor;
	private static OutputFileGenerator fileGenerator;

	public static void main(String[] args) {
		bootUp();
		List<Athlete> athleteList = inputOperation();
		List<Result> finalResult = pointCalculation(athleteList);
		outputOperation(finalResult);
		System.out.println("Success - " + finalResult);
	}

	private static List<Result> pointCalculation(List<Athlete> athleteList) {
		AthleteService athleteService = new AthleteServiceImpl();
		if (athleteList != null && !athleteList.isEmpty())
			athleteList = athleteList.stream().map(a -> athleteService.calculateTotalPoints(a))
					.collect(Collectors.toList());
		List<Result> finalResult = AthleteResultMapper.map(athleteList);
		return finalResult;
	}

	private static void bootUp() {
		inputFileProcessor = new CsvFileProcessor();
		fileGenerator = new XmlFileGenerator();
	}

	private static List<Athlete> inputOperation() {
		String csvFilePath = PropertyConfig.props().getProperty(ApplicationConstants.INPUT_DIR) + "/"
				+ PropertyConfig.props().getProperty(ApplicationConstants.INPUT_FILE);

		List<List<String>> listOfAtheleteData = inputFileProcessor.read(csvFilePath);
		return AthleteDataMapper.map(listOfAtheleteData);
	}

	private static void outputOperation(List<Result> finalResult) {
		String xmlFilePath = PropertyConfig.props().getProperty(ApplicationConstants.OUTPUT_DIR) + "/"
				+ PropertyConfig.props().getProperty(ApplicationConstants.OUTPUT_FILE);
		fileGenerator.generateFile(finalResult, xmlFilePath);
	}
}
