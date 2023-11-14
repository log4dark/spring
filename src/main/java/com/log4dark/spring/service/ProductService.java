package com.log4dark.spring.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductService {
    private final InventoryService inventoryService;

    public ProductService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
        log.info("ProductService construct");
    }

    public void display() {
        log.info("ProductService display - inventoryService: {}", inventoryService);
    }
}
