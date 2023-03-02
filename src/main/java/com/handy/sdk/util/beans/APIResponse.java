package com.handy.sdk.util.beans;

import org.json.JSONObject;

public final class APIResponse {
	private int code;
	private JSONObject body;
	
	public APIResponse() {}
	
	public APIResponse(int code) {
		this(code, null);
	}
	
	public APIResponse(int code, JSONObject body) {
		this.code = code;
		this.body = body;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public JSONObject getBody() {
		return body;
	}
	public void setBody(JSONObject body) {
		this.body = body;
	}
	
	
}
