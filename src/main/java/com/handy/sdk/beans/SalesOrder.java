package com.handy.sdk.beans;

import java.time.LocalDateTime;
import java.util.List;
import org.json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.handy.sdk.util.beans.HandyDateAdapterDeserializer;
import com.handy.sdk.util.beans.HandyDateAdapterSerializer;

public class SalesOrder {
	private int id;
	private LocalDateTime mobileDateCreated;
	private Customer customer;
	private User createdBy;
	private List<SalesOrderItem> items;
	private SalesOrderType type;
	private boolean exported;
	private boolean deleted;
	private String sellerComment;
	private LocalDateTime scheduledDateForDelivery;
	private double latitude;
	private double longitude;
	private float accuracy;
	private boolean tookInPlace;
	private PriceList priceList;
	private float totalSales;
	private float totalTax;
	private float totalBeforeTax;
	private boolean billable;
	private boolean billed;
	private String routeSalePaymentType;
	private LocalDateTime dateCreated;
	private String promoIds;
	private String promoNames;
	private int networkSignalQuality;
	private String creationSource;
	private LocalDateTime dateDeleted;
	private User deletedBy;
	private SalesOrder editedFrom;
	private boolean isEdited;
	private String salesType;
	private Integer externalId;
	
	public SalesOrder() {}

	public SalesOrder(int id, LocalDateTime mobileDateCreated, Customer customer, User createdBy,
			List<SalesOrderItem> items, SalesOrderType type, boolean exported, boolean deleted, String sellerComment,
			LocalDateTime scheduledDateForDelivery, double latitude, double longitude, float accuracy,
			boolean tookInPlace, PriceList priceList, float totalSales, float totalTax, float totalBeforeTax,
			boolean billable, boolean billed, String routeSalePaymentType, LocalDateTime dateCreated, String promoIds,
			String promoNames, int networkSignalQuality, String creationSource, LocalDateTime dateDeleted,
			User deletedBy, SalesOrder editedFrom, boolean isEdited, String salesType, int externalId) {
		this.id = id;
		this.mobileDateCreated = mobileDateCreated;
		this.customer = customer;
		this.createdBy = createdBy;
		this.items = items;
		this.type = type;
		this.exported = exported;
		this.deleted = deleted;
		this.sellerComment = sellerComment;
		this.scheduledDateForDelivery = scheduledDateForDelivery;
		this.latitude = latitude;
		this.longitude = longitude;
		this.accuracy = accuracy;
		this.tookInPlace = tookInPlace;
		this.priceList = priceList;
		this.totalSales = totalSales;
		this.totalTax = totalTax;
		this.totalBeforeTax = totalBeforeTax;
		this.billable = billable;
		this.billed = billed;
		this.routeSalePaymentType = routeSalePaymentType;
		this.dateCreated = dateCreated;
		this.promoIds = promoIds;
		this.promoNames = promoNames;
		this.networkSignalQuality = networkSignalQuality;
		this.creationSource = creationSource;
		this.dateDeleted = dateDeleted;
		this.deletedBy = deletedBy;
		this.editedFrom = editedFrom;
		this.isEdited = isEdited;
		this.salesType = salesType;
		this.externalId = externalId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getMobileDateCreated() {
		return mobileDateCreated;
	}

	public void setMobileDateCreated(LocalDateTime mobileDateCreated) {
		this.mobileDateCreated = mobileDateCreated;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public List<SalesOrderItem> getItems() {
		return items;
	}

	public void setItems(List<SalesOrderItem> items) {
		this.items = items;
	}

	public SalesOrderType getType() {
		return type;
	}

	public void setType(SalesOrderType type) {
		this.type = type;
	}

	public boolean isExported() {
		return exported;
	}

	public void setExported(boolean exported) {
		this.exported = exported;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getSellerComment() {
		return sellerComment;
	}

	public void setSellerComment(String sellerComment) {
		this.sellerComment = sellerComment;
	}

	public LocalDateTime getScheduledDateForDelivery() {
		return scheduledDateForDelivery;
	}

	public void setScheduledDateForDelivery(LocalDateTime scheduledDateForDelivery) {
		this.scheduledDateForDelivery = scheduledDateForDelivery;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public float getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(float accuracy) {
		this.accuracy = accuracy;
	}

	public boolean isTookInPlace() {
		return tookInPlace;
	}

	public void setTookInPlace(boolean tookInPlace) {
		this.tookInPlace = tookInPlace;
	}

	public PriceList getPriceList() {
		return priceList;
	}

	public void setPriceList(PriceList priceList) {
		this.priceList = priceList;
	}

	public float getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(float totalSales) {
		this.totalSales = totalSales;
	}

	public float getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(float totalTax) {
		this.totalTax = totalTax;
	}

	public float getTotalBeforeTax() {
		return totalBeforeTax;
	}

	public void setTotalBeforeTax(float totalBeforeTax) {
		this.totalBeforeTax = totalBeforeTax;
	}

	public boolean isBillable() {
		return billable;
	}

	public void setBillable(boolean billable) {
		this.billable = billable;
	}

	public boolean isBilled() {
		return billed;
	}

	public void setBilled(boolean billed) {
		this.billed = billed;
	}

	public String getRouteSalePaymentType() {
		return routeSalePaymentType;
	}

	public void setRouteSalePaymentType(String routeSalePaymentType) {
		this.routeSalePaymentType = routeSalePaymentType;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getPromoIds() {
		return promoIds;
	}

	public void setPromoIds(String promoIds) {
		this.promoIds = promoIds;
	}

	public String getPromoNames() {
		return promoNames;
	}

	public void setPromoNames(String promoNames) {
		this.promoNames = promoNames;
	}

	public int getNetworkSignalQuality() {
		return networkSignalQuality;
	}

	public void setNetworkSignalQuality(int networkSignalQuality) {
		this.networkSignalQuality = networkSignalQuality;
	}

	public String getCreationSource() {
		return creationSource;
	}

	public void setCreationSource(String creationSource) {
		this.creationSource = creationSource;
	}

	public LocalDateTime getDateDeleted() {
		return dateDeleted;
	}

	public void setDateDeleted(LocalDateTime dateDeleted) {
		this.dateDeleted = dateDeleted;
	}

	public User getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(User deletedBy) {
		this.deletedBy = deletedBy;
	}

	public SalesOrder getEditedFrom() {
		return editedFrom;
	}

	public void setEditedFrom(SalesOrder editedFrom) {
		this.editedFrom = editedFrom;
	}

	public boolean isEdited() {
		return isEdited;
	}

	public void setEdited(boolean isEdited) {
		this.isEdited = isEdited;
	}

	public String getSalesType() {
		return salesType;
	}

	public void setSalesType(String salesType) {
		this.salesType = salesType;
	}

	public Integer getExternalId() {
		return externalId;
	}

	public void setExternalId(Integer externalId) {
		this.externalId = externalId;
	}
	
	public JSONObject toJsonObject() {
		Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDateTime.class, new HandyDateAdapterSerializer()).create();
		return new JSONObject(gson.toJson(this));
	}
	
	public static SalesOrder fromJsonObject(JSONObject jsonSalesOrder) {
		Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new HandyDateAdapterDeserializer()).create();
		return gson.fromJson(jsonSalesOrder.toString(), SalesOrder.class);
	}
	
	public static<T extends SalesOrder> SalesOrder fromSubClass(T salesOrder) {
		return SalesOrder.class.cast(salesOrder);
	}
	
	public<T extends SalesOrder> T toSubClass(Class<T> type) {
		return type.cast(this);
	}

	@Override
	public int hashCode() {
		return 23 * id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesOrder other = (SalesOrder) obj;
		return id == other.id;
	}
}
