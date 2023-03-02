package com.handy.sdk.beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.handy.sdk.enums.FilterWithDate;
import com.handy.sdk.enums.SalesTypeFilter;

public class SalesOrderFilter {
	private boolean deleted;
	private LocalDateTime start;
	private LocalDateTime end;
	private int page;
	private int max;
	private boolean orderAsc;
	private String sort;
	private Boolean exported;
	private Boolean billable;
	private Boolean billed;
	private SalesTypeFilter salesType;
	private FilterWithDate filterWithDate;
	
	public SalesOrderFilter() {
		this.deleted = false;
		this.page = 1;
		this.max = 10;
		this.orderAsc = true;
		this.exported = null;
		this.billable = null;
		this.billed = null;
	}

	public SalesOrderFilter(boolean deleted, LocalDateTime start, LocalDateTime end, int page, int max,
			boolean orderAsc, String sort, boolean exported, boolean billable, boolean billed,
			SalesTypeFilter salesType, FilterWithDate filterWithDate) {
		this.deleted = deleted;
		this.start = start;
		this.end = end;
		this.page = page;
		this.max = max;
		this.orderAsc = orderAsc;
		this.sort = sort;
		this.exported = exported;
		this.billable = billable;
		this.billed = billed;
		this.salesType = salesType;
		this.filterWithDate = filterWithDate;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public void setOrderAsc(boolean orderAsc) {
		this.orderAsc = orderAsc;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public void setExported(boolean exported) {
		this.exported = exported;
	}

	public void setBillable(boolean billable) {
		this.billable = billable;
	}

	public void setBilled(boolean billed) {
		this.billed = billed;
	}

	public void setSalesType(SalesTypeFilter salesType) {
		this.salesType = salesType;
	}

	public void setFilterWithDate(FilterWithDate filterWithDate) {
		this.filterWithDate = filterWithDate;
	}

	@Override
	public String toString() {
		StringBuilder paramBuilder = new StringBuilder();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy%20HH:mm:ss");
		
		paramBuilder.append("?deleted=" + this.deleted);
		if(this.start != null) paramBuilder.append("&start=" + this.start.format(formatter));
		if(this.end != null) paramBuilder.append("&end=" + this.end.format(formatter));
		paramBuilder.append("&page=" + this.page);
		paramBuilder.append("&max=" + this.max);
		paramBuilder.append("&order=" + (this.orderAsc ? "asc" : "desc"));
		if(this.sort != null) paramBuilder.append("&sort=" + this.sort);
		if(this.exported != null) paramBuilder.append("&exported=" + this.exported);
		if(this.billable != null) paramBuilder.append("&billable=" + this.billable);
		if(this.billed != null) paramBuilder.append("&billed=" + this.billed);
		if(this.salesType != null) paramBuilder.append("&salesType=" + this.salesType);
		if(this.filterWithDate != null) paramBuilder.append("&filterWithDate=" + this.filterWithDate.getValue());
		
		
		return paramBuilder.toString();
	}
}
