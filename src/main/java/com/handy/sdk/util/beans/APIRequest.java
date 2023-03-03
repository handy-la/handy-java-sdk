package com.handy.sdk.util.beans;

import com.handy.sdk.enums.HTTPMethod;

public class APIRequest {
	private HTTPMethod method;
	private String url;
	private String token;
	private String body;
	
	public APIRequest() {
		this(null,"","","");
	}

	public APIRequest(HTTPMethod method, String url, String token, String body) {
		this.method = method;
		this.url = url;
		this.token = token;
		this.body = body;
	}
	
	public APIRequest(HTTPMethod method, String url, String token) {
		this(method, url, token, "");
	}

	public HTTPMethod getMethod() {
		return method;
	}

	public void setMethod(HTTPMethod method) {
		this.method = method;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	
}
