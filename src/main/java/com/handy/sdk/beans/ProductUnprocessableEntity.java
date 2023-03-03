package com.handy.sdk.beans;

import org.json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class ProductUnprocessableEntity {
	private String object;
	private String field;
	@SerializedName(value="rejected-value")
	private String rejectedValue;
	private String message;
	
	public ProductUnprocessableEntity() {}
	
	public ProductUnprocessableEntity(String object, String field, String rejectedValue, String message) {
		this.object = object;
		this.field = field;
		this.rejectedValue = rejectedValue;
		this.message = message;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getRejectedValue() {
		return rejectedValue;
	}

	public void setRejectedValue(String rejectedValue) {
		this.rejectedValue = rejectedValue;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public static ProductUnprocessableEntity fromJsonObject(JSONObject jsonProductUnprocessableEntity) {
	    Gson gson = new Gson();
	    return gson.fromJson(jsonProductUnprocessableEntity.toString(), ProductUnprocessableEntity.class);
	}
}
