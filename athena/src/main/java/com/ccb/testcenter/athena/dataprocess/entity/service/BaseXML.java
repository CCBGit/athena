package com.ccb.testcenter.athena.dataprocess.entity.service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/***
 * 
 * @author pandong
 *
 */
public class BaseXML implements XML {
	private Document document;
	
	protected Element TX;
	protected Element TX_HEADER;
	protected Element TX_BODY;
	protected Element COMMON;
	protected Element ENTITY;	

	protected Map<String, Element> COMS = new HashMap<String, Element>();	
	
	public BaseXML() {
		document = DocumentHelper.createDocument();	
		TX = DocumentHelper.createElement("TX");
		TX_HEADER = DocumentHelper.createElement("TX_HEADER");
		TX_BODY = DocumentHelper.createElement("TX_BODY");
		COMMON = DocumentHelper.createElement("COMMON");
		ENTITY = DocumentHelper.createElement("ENTITY");		
	
		document.add(TX);
	
		TX.add(TX_HEADER);
		TX.add(TX_BODY);
		
		TX_BODY.add(COMMON);
		TX_BODY.add(ENTITY);
			
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Element getTX() {
		return TX;
	}

	public void setTX(Element tX) {
		TX = tX;
	}

	public Element getTX_HEADER() {
		return TX_HEADER;
	}

	public void setTX_HEADER(Element tX_HEADER) {
		TX_HEADER = tX_HEADER;
	}

	public Element getTX_BODY() {
		return TX_BODY;
	}

	public void setTX_BODY(Element tX_BODY) {
		TX_BODY = tX_BODY;
	}

	public Element getCOMMON() {
		return COMMON;
	}

	public void setCOMMON(Element cOMMON) {
		COMMON = cOMMON;
	}

	public Element getENTITY() {
		return ENTITY;
	}

	public void setENTITY(Element eNTITY) {
		ENTITY = eNTITY;
	}
	
	public Element getCOM(String com) {
		return COMS.get(com);
	}

	public Map<String, Element> getCOMS() {
		return COMS;
	}

	public void setCOMS(Map<String, Element> cOMS) {
		COMS = cOMS;
	}
	
	public String getContent() {
		return this.getContent(true);
	}
	
	public String getContent(boolean formatted) {
		if(formatted) {
			OutputFormat format = OutputFormat.createPrettyPrint();
			StringWriter writer = new StringWriter();
			XMLWriter xmlwriter = new XMLWriter(writer, format);
			try {
				xmlwriter.write(document);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			return writer.toString();
		}
		
		return document.asXML();
	}

}
