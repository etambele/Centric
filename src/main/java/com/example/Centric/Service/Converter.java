package com.example.Centric.Service;

import com.example.Centric.Model.Entity.Product;
import com.example.Centric.Model.ProductDTO;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Component
public class Converter {

    public Product convertProductDTOToProduct(ProductDTO productDTO){
        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setBrand(productDTO.getBrand());
        product.setTags(productDTO.getTags());
        product.setCategory(productDTO.getCategory());
        product.setCreatedAt(ZonedDateTime.now(ZoneId.of("Z")));
        return product;
    }

    public ProductDTO convertProductToProductDTO(Product product){
        return new ProductDTO.Builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .brand(product.getBrand())
                .tags(product.getTags())
                .category(product.getCategory())
                .createdAt(product.getCreatedAt())
                .build();

    }

}
