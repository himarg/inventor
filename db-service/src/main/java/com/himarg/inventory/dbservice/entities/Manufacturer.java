package com.himarg.inventory.dbservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MANUFACTURER",catalog="INVENTORY")
public class Manufacturer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long mfrId;
	
	private String name;

	public Manufacturer() {
		super();
	}

	public Manufacturer(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMfrId() {
		return mfrId;
	}
}
