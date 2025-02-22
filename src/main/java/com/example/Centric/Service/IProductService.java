package com.example.Centric.Service;

import com.example.Centric.Model.ProductDTO;

import java.util.List;

public interface IProductService {

    ProductDTO addProduct(ProductDTO productDTO);

    List<ProductDTO> getProductByCategory(String category, Integer pageSize, Integer offSet);
}
