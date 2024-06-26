package com.stockinventory.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockinventory.project.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
