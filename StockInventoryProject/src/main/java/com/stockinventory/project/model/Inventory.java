package com.stockinventory.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


/**
 * @author prangya 
 * Entity With Table Name Inventory
 */
@Entity
@Table(name="inventory")
@Data
public class Inventory {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long inventoryId;

	@Column
	private String inventoryStockname;
	
	@Column(columnDefinition = "integer default 0")
	private Integer inventorySaleStockPrevioussize;
	
	@Column(columnDefinition = "integer default 0")
	private Integer inventorySaleStockCurrentsize;
	
	@Column(columnDefinition = "integer default 0")
	private Integer inventoryOrderStockPrevioussize;
	
	@Column(columnDefinition = "integer default 0")
	private Integer inventoryOrderStockCurrentsize;
}
