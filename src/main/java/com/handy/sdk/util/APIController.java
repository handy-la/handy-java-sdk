package com.handy.sdk.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.json.JSONObject;

import com.handy.sdk.util.beans.APIRequest;
import com.handy.sdk.util.beans.APIResponse;

public class APIController {
	
	public APIResponse call(APIRequest request) throws IOException {
		try (CloseableHttpClient client = HttpClients.createDefault()) {

			ClassicHttpRequest httpRequest = buildHttpRequest(request);
            
            CloseableHttpResponse response = client.execute(httpRequest);
            if(response.getCode() == 200 || response.getCode() == 201 || response.getCode() == 422) {
	            BufferedReader responseReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),"UTF-8"));
	            StringBuilder responseStrBuilder = new StringBuilder();
	            
	            responseReader.lines().forEach(strLine -> responseStrBuilder.append(strLine));
	            
	            APIResponse apiResponse = new APIResponse(response.getCode(), new JSONObject(responseStrBuilder.toString()));

	            return apiResponse;
            }
            
            return new APIResponse(response.getCode());
        }
	}
	
	private ClassicHttpRequest buildHttpRequest(APIRequest request) {
		ClassicHttpRequest httpRequest;
		switch(request.getMethod()) {
		case GET:
			httpRequest = new HttpGet(request.getUrl());
			break;
		case POST:
			httpRequest = new HttpPost(request.getUrl());
			break;
		case PUT:
			httpRequest = new HttpPut(request.getUrl());
			break;
		case DELETE:
			httpRequest = new HttpDelete(request.getUrl());
			break;
		default:
			return null;
		}
		
		httpRequest.addHeader("Authorization", request.getToken());
		if(!request.getBody().isEmpty())
			httpRequest.setEntity(new StringEntity(request.getBody()));

		return httpRequest;
	}
}