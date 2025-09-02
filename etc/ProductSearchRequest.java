package com.allra.market.product.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductSearchRequest {
    
    private Long categoryId;
    
    private String name;
    
    private BigDecimal minPrice;
    
    private BigDecimal maxPrice;
    
    private Boolean isAvailable;
    
    private Boolean excludeSoldOut;
    
    private int page = 0;
    
    private int size = 20;
    
    private String sortBy = "createdAt";
    
    private String sortDirection = "desc";
}