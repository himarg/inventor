package com.himarg.stockapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="MANUFACTURER",catalog="INVENTORY")
@Getter
@Setter
public class Manufacturer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long mfrId;
	
	private String name;

	public Manufacturer() {
		super();
	}
	
	public Manufacturer(long mfrId) {
		super();
		this.mfrId = mfrId;
	}
}
