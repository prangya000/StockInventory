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
 * Entity With Table Name Stock
 */
@Entity
@Table(name="stock")
@Data
public class Stock {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long stockId;

	@Column
	private String stockName;
	
	@Column
	private String stockDescription;
	
	@Column 
	private Integer stockSize;
	

}
