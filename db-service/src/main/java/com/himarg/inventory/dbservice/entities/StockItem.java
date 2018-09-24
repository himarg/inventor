package com.himarg.inventory.dbservice.entities;

import java.time.Instant;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="STOCK_ITEM",catalog="INVENTORY")
public class StockItem {
	
	@Id
	private String stockItemId;
	
	private String name;
	
	@OneToOne
    @JoinColumn(name="uom_id")
	private UnitOfMeasure UOM;
	
	private float quantityInStock;
	
	private int packingSize;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "yyyy-MM-dd'T'hh:mm:ss.SSSZ")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'hh:mm:ss.SSSZ")
	private Date lastUpdatedDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="mfr_id")
	private Manufacturer manufacturer;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "yyyy-MM-dd")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date expiryDate;
	
	public StockItem() {
		super();
	}
	
	public StockItem(String stockItemId, String name, float quantityInStock, UnitOfMeasure uOMId, Date lastUpdatedDate, int packingSize, Manufacturer manufacturer) {
		super();
		this.stockItemId = stockItemId;
		this.name = name;
		this.quantityInStock = quantityInStock;
		UOM = uOMId;
		this.lastUpdatedDate = lastUpdatedDate;
		this.packingSize = packingSize;
		this.manufacturer = manufacturer;
		this.lastUpdatedDate = Date.from(Instant.now());
	}
	
	public String getStockItemId() {
		return stockItemId;
	}

	public void setStockItemId(String stockItemId) {
		this.stockItemId = stockItemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(float quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public UnitOfMeasure getUOM() {
		return UOM;
	}

	public void setUOM(UnitOfMeasure uOMId) {
		UOM = uOMId;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public int getPackingSize() {
		return packingSize;
	}

	public void setPackingSize(int packingSize) {
		this.packingSize = packingSize;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
}
