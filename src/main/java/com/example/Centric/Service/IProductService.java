package com.example.Centric.Service;

import com.example.Centric.Model.ProductDTO;

import java.util.List;

public interface IProductService {

    public ProductDTO addProduct(ProductDTO productDTO);

    public List<ProductDTO> getProductByCategory(String category);
}
