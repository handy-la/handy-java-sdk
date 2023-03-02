package com.handy.sdk.job;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONObject;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.handy.sdk.beans.SalesOrder;
import com.handy.sdk.beans.SalesOrderFilter;
import com.handy.sdk.beans.SalesOrderResponse;
import com.handy.sdk.business.HandySDKConfiguration;
import com.handy.sdk.business.SalesOrderController;
import com.handy.sdk.exceptions.HandyAuthorizationException;
import com.handy.sdk.exceptions.HandySDKException;
import com.handy.sdk.job.beans.JobHandler;

public class HandySDKJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		SalesOrderController salesOrderController = new SalesOrderController();
		SalesOrderFilter filter = new SalesOrderFilter();
		LocalDateTime startDateTime = readLastDateTime();
		LocalDateTime endDateTime = LocalDateTime.now();
		Set<SalesOrder> salesOrderList = new HashSet<>();
		
		filter.setStart(startDateTime);
		filter.setEnd(endDateTime);
		
		try {
			SalesOrderResponse salesOrderResponse = salesOrderController.getSalesOrder(filter);
			salesOrderList.addAll(salesOrderResponse.getSalesOrderList());
			
			int totalPages = salesOrderResponse.getPagination().getTotalPages();
			for(int currPage = 2; currPage <= totalPages; currPage++) {
				filter.setPage(currPage);
				salesOrderResponse = salesOrderController.getSalesOrder(filter);
				salesOrderList.addAll(salesOrderResponse.getSalesOrderList());
			}
			
			JobHandler jobHandler = HandySDKConfiguration.getJobHandler();
			
			jobHandler.process(salesOrderList);
			
			writeLastDateTime(endDateTime);
			
		} catch (HandyAuthorizationException | HandySDKException e) {
			e.printStackTrace();
		}

	}
	
	private LocalDateTime readLastDateTime() {
		LocalDateTime lastDateTime = LocalDateTime.now();
		File salesOrderLastTime = new File("./salesOrderLastTime.json");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
		
		try {
			if(salesOrderLastTime.exists()) {
				InputStream is = new FileInputStream(salesOrderLastTime);
				
				BufferedReader responseReader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
				StringBuilder responseStrBuilder = new StringBuilder();
				
				responseReader.lines().forEach(strLine -> responseStrBuilder.append(strLine));
	
				JSONObject jsonEndDate = new JSONObject(responseStrBuilder.toString());
				String endDateStr = jsonEndDate.getString("endDate");
				
				lastDateTime = endDateStr.isEmpty() ? LocalDateTime.now() : LocalDateTime.parse(endDateStr, formatter);
				
				responseReader.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return lastDateTime;
	}
	
	private void writeLastDateTime(LocalDateTime newDateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
		try {
		BufferedWriter writer = new BufferedWriter(new FileWriter("./salesOrderLastTime.json"));
		writer.write("{\"endDate\":\"" + newDateTime.format(formatter) + "\"}");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
