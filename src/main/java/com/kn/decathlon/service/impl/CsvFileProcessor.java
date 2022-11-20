package com.kn.decathlon.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.kn.decathlon.execption.DecathlonAppException;
import com.kn.decathlon.execption.ExceptionType;
import com.kn.decathlon.service.InputFileProcessor;

public class CsvFileProcessor implements InputFileProcessor {


    @Override
	public List<List<String>> read(String filePath) {
		List<List<String>> values = null;
		try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
			values = lines.map(line -> Arrays.asList(line.split(";"))).filter(i -> i.size() > 0 && !i.get(0).isEmpty())
					.collect(Collectors.toList());
			//values.forEach(value -> System.out.println(value));
		} catch (IOException e) {
			throw new DecathlonAppException(e.getLocalizedMessage(), ExceptionType.FILE_READER_EXCEPTION);
		}
		return values;
	}

}
