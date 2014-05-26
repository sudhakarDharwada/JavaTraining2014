package com.vl.school.handlers;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class MyErrorHandler implements ErrorHandler {
	boolean isValid=true;
    public void warning(SAXParseException e) throws SAXException {
    	isValid=false;
    	MyThreadLocal.set(isValid);
    	System.out.println("The file is invalid");
        System.out.println("warning "+e.getMessage());
    }
    
    public void error(SAXParseException e) throws SAXException {
    	isValid=false;
    	MyThreadLocal.set(isValid);
    	System.out.println("The file is invalid");
    	System.out.println("error "+e.getMessage());
    }

    public void fatalError(SAXParseException e) throws SAXException {
    	isValid=false;
    	MyThreadLocal.set(isValid);
    	System.out.println("The file is invalid");
    	System.out.println("fatalError "+e.getMessage());
    }
}