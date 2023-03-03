package com.handy.sdk.beans;

import org.json.JSONObject;

import com.google.gson.Gson;

public class Pagination {
	private int totalCount;
	private int totalPages;
	private int nextPage;
	private int prevPage;
	
	public Pagination() {}

	public Pagination(int totalCount, int totalPages, String currentPage, int nextPage, int prevPage, String firstPage,
			String lastPage) {
		this.totalCount = totalCount;
		this.totalPages = totalPages;
		this.nextPage = nextPage;
		this.prevPage = prevPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	
	public static Pagination fromJsonObject(JSONObject jsonPagination) {
		Gson gson = new Gson();
		return gson.fromJson(jsonPagination.toString(), Pagination.class);
	}
	
}
