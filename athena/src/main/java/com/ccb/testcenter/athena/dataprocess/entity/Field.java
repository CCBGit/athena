package com.ccb.testcenter.athena.dataprocess.entity;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.ccb.testcenter.athena.dataprocess.enums.DataType;

/**
 * 
 * @author pandong
 *
 * 报文接口字段
 */

public class Field {
	
	private String tagName;
	private String fullName;
	private String nameZh;
	private String identifier;
	private String length;
	private DataType dataType;
	private boolean required;
	private String note;
	private String encoding;
	private String secure;
	
	private int level;		//层级

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getNameZh() {
		return nameZh;
	}

	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getSecure() {
		return secure;
	}

	public void setSecure(String secure) {
		this.secure = secure;
	}

	public boolean isGroup() {
		return DataType.GROUP.equals(dataType);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ToStringBuilder.reflectionToString(this);
	}
}
