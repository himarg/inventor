package com.himarg.trxapp.model;

import java.util.Date;

import lombok.Value;

@Value
public class StockItem {
	private Long stockItemId;
	private String name;
	private UnitOfMeasure UOM;
	private float quantityInStock;
	private int packingSize;
	private Date lastUpdatedDate;
	private Manufacturer manufacturer;
	private Date expiryDate;
}
