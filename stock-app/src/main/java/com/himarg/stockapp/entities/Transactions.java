package com.himarg.stockapp.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TRANSACTIONS",catalog="INVENTORY")
@Getter
@Setter
public class Transactions {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long transactionId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss")
	private Date transactionDate;
	
	@OneToOne
	@JoinColumn(name="stockItemId")
	private StockItem item;
	
	private float quantity;

	public Transactions() {
		super();
	}
}
