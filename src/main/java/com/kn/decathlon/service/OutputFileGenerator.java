package com.kn.decathlon.service;

import java.util.List;

import com.kn.decathlon.entity.Result;

public interface OutputFileGenerator {
	 public void generateFile(List<Result> finalResult, String xmlFilePath) ;
}
