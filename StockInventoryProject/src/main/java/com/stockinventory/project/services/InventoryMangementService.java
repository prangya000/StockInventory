package com.stockinventory.project.services;

import com.stockinventory.project.model.Inventory;

public interface InventoryMangementService {

	Inventory saleStock(Inventory inventory);

	Inventory orderStock(Inventory inventory);

}
