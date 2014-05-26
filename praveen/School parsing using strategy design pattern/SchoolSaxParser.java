package com.vl.school.adstractclasses;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.vl.school.beans.School;
import com.vl.school.handlers.MyErrorHandler;
import com.vl.school.handlers.MyThreadLocal;
import com.vl.school.handlers.SaxHandler;

public class SchoolSaxParser implements Parsers{
	private boolean isValidate;
	private School school;
	@Override
	public School parser(String filePath) {
		isValidate=true;
		MyThreadLocal.set(isValidate);
		school=null;
		SAXParserFactory factory=SAXParserFactory.newInstance();
		try {
			factory.setValidating(true);
			factory.setNamespaceAware(true);
			SAXParser parser=factory.newSAXParser();
			XMLReader reader=parser.getXMLReader();
			reader.setErrorHandler(new MyErrorHandler());
			reader.parse(new InputSource(filePath));
			SaxHandler handler=new SaxHandler();
			reader.setContentHandler(handler);
			reader.parse(new InputSource(filePath));
			school=handler.getSchool();
			//System.out.println(school);
//			handler.display();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return school;
	}
	
}
