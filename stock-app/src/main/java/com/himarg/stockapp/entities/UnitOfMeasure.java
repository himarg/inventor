package com.himarg.stockapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="UNIT_OF_MEASURE",catalog="INVENTORY")
@Getter
@Setter
@EqualsAndHashCode
public class UnitOfMeasure {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String unitName;
	
	public UnitOfMeasure() {
		super();
	}
	
	public UnitOfMeasure(long id) {
		super();
		this.id = id;
	}
}
