package com.stockinventory.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockinventory.project.model.Stock;
import com.stockinventory.project.services.StockMangementService;

@RestController
@RequestMapping("/api/v1")
public class StockController {

	@Autowired
	private StockMangementService stockMangementService;
	
	@GetMapping("/stock")
	ResponseEntity<List<Stock>> getAllStock(){
		return new ResponseEntity<>(stockMangementService.findAllStock(),HttpStatus.OK);
	}
	
	@PostMapping("/stock")
	public ResponseEntity<Stock> addStock(@RequestBody Stock stock) {
		return new ResponseEntity<>(stockMangementService.createStock(stock),HttpStatus.CREATED);
	}
	
	@GetMapping("/stock/{id}")
	public ResponseEntity<Stock> getSingleStock(@PathVariable long id) {
		return new ResponseEntity<>(stockMangementService.findById(id),HttpStatus.OK);
	}
	
	@GetMapping("/stockname/{name}")
	public ResponseEntity<Stock> getSingleStockByName(@PathVariable String name) {
		return new ResponseEntity<>(stockMangementService.findByName(name),HttpStatus.OK);
	}
	
	@PutMapping("/stock/{id}")
	public ResponseEntity<Stock> updateStock(@RequestBody Stock stock,@PathVariable long id) {
		return new ResponseEntity<>(stockMangementService.updateStock(stock,id),HttpStatus.OK);
	}
	
	@DeleteMapping("/stock/{id}")
	public ResponseEntity<String> deleteStock(@PathVariable long id) {
		return new ResponseEntity<String>(stockMangementService.deleteStock(id),HttpStatus.OK);
	}
}
