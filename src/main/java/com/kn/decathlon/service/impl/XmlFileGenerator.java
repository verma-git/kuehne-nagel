package com.kn.decathlon.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.kn.decathlon.entity.Result;
import com.kn.decathlon.execption.DecathlonAppException;
import com.kn.decathlon.execption.ExceptionType;
import com.kn.decathlon.service.OutputFileGenerator;

public class XmlFileGenerator implements OutputFileGenerator {

    String xmlFilePath;

    @Override
    public void generateFile(List<Result> finalResult, String xmlFilePath) {
        try {
        	this.xmlFilePath = xmlFilePath;
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("athletes");
            doc.appendChild(rootElement);

            for (Result result: finalResult) {
            	
                Element athlete = doc.createElement("athlete");
                rootElement.appendChild(athlete);

                athlete.setAttribute("name", result.getAthleteName());

                athlete.appendChild(createElement(doc, "rank", result.getRank() + ""));
                athlete.appendChild(createElement(doc, "score", result.getTotalPoints() + ""));
            }

            saveFile(doc);

        } catch (Exception e) {
            throw new DecathlonAppException(e.getLocalizedMessage(), ExceptionType.FILE_WRITER_EXCEPTION);
        }

    
    }
    
    private Element createElement(Document doc, String name, String value) {
        Element element = doc.createElement(name);
        element.appendChild(doc.createTextNode(value));
        return element;
    }

    private void saveFile(Document document) throws TransformerException, IOException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);

        StreamResult result = new StreamResult(new File(xmlFilePath));
        transformer.transform(source, result);
    }
    
    
}
