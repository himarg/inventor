package com.himarg.stockapp.entities;

import java.time.Instant;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="STOCK_ITEM",catalog="INVENTORY")
@Getter
@Setter
public class StockItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long stockItemId;
	
	private String name;
	
	@OneToOne
    @JoinColumn(name="uom_id")
	private UnitOfMeasure UOM;
	
	private float quantityInStock;
	
	private int packingSize;
	
	@Column(name = "last_updated_date", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss", timezone = "UTC")
	private Date lastUpdatedDate;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="mfr_id")
	private Manufacturer manufacturer;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date expiryDate;
	
	public StockItem() {
		super();
	}
	
	public StockItem(Long stockItemId, String name, float quantityInStock, UnitOfMeasure uOMId, Date lastUpdatedDate, int packingSize, Manufacturer manufacturer) {
		super();
		this.stockItemId = stockItemId;
		this.name = name;
		this.quantityInStock = quantityInStock;
		this.UOM = uOMId;
		this.lastUpdatedDate = lastUpdatedDate;
		this.packingSize = packingSize;
		this.manufacturer = manufacturer;
		this.lastUpdatedDate = Date.from(Instant.now());
	}
}
