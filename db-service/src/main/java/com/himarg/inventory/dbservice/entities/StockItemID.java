package com.himarg.inventory.dbservice.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Embeddable
public class StockItemID implements Serializable{
	
	private String sku;
	
	@OneToOne
    @JoinColumn(name="uom_id")
	private UnitOfMeasure UOM;
	
	private int packingSize;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "yyyy-MM-dd")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date expiryDate;

	public StockItemID(String sku, UnitOfMeasure uOM, int packingSize, Date expiryDate) {
		super();
		this.sku = sku;
		UOM = uOM;
		this.packingSize = packingSize;
		this.expiryDate = expiryDate;
	}

	public StockItemID() {
		super();
	}

	public String getSku() {
		return sku;
	}

	public UnitOfMeasure getUOM() {
		return UOM;
	}

	public int getPackingSize() {
		return packingSize;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((UOM == null) ? 0 : UOM.hashCode());
		result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + packingSize;
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockItemID other = (StockItemID) obj;
		if (UOM == null) {
			if (other.UOM != null)
				return false;
		} else if (!UOM.equals(other.UOM))
			return false;
		if (expiryDate == null) {
			if (other.expiryDate != null)
				return false;
		} else if (!expiryDate.equals(other.expiryDate))
			return false;
		if (packingSize != other.packingSize)
			return false;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		return true;
	}
	
	
}
