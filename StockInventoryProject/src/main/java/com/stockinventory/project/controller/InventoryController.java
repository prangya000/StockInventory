package com.stockinventory.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockinventory.project.model.Inventory;
import com.stockinventory.project.services.InventoryMangementService;

@RestController
@RequestMapping("/api/v1")
public class InventoryController {
	
	@Autowired
	private InventoryMangementService inventoryMangementService;
	
	@PostMapping("/inventory/sale")
	ResponseEntity<Inventory> saleStock(@RequestBody Inventory inventory){
		return new ResponseEntity<>(inventoryMangementService.saleStock(inventory),HttpStatus.CREATED);
	}
	
	@PostMapping("/inventory/order")
	ResponseEntity<Inventory> orderStock(@RequestBody Inventory inventory){
		return new ResponseEntity<>(inventoryMangementService.orderStock(inventory),HttpStatus.CREATED);
	}

}
