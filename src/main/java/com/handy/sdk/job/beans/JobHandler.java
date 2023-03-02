package com.handy.sdk.job.beans;

import java.util.Set;

import com.handy.sdk.beans.SalesOrder;

public interface JobHandler {
	public void process(Set<SalesOrder> dataToProcess);
}
