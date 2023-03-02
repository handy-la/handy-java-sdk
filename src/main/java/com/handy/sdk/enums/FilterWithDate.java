package com.handy.sdk.enums;

public enum FilterWithDate {
	MOBILEDATECREATED("mobileDateCreated"),
	DATECREATED("dateCreated"),
	DATEDELETED("dateDeleted");
	
	private String value;
	
	FilterWithDate(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
