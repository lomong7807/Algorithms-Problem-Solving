package com.allra.market.product.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
public class ProductResponse {
    
    private Long id;
    
    private String name;
    
    private String description;
    
    private BigDecimal price;
    
    private Integer stockQuantity;
    
    private Boolean isAvailable;
    
    private Boolean isSoldOut;
    
    private CategoryInfo category;
    
    private Instant createdAt;
    
    private Instant updatedAt;
    
    @Getter
    @Setter
    public static class CategoryInfo {
        private Long id;
        private String name;
        
        public CategoryInfo(Long id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}