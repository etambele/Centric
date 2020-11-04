package com.example.Centric.Service;

import com.example.Centric.Model.DBModel.Product;
import com.example.Centric.Model.ProductDTO;
import com.example.Centric.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService{

    private final Converter converter;
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(Converter converter, ProductRepository productRepository) {
        this.converter = converter;
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        Product productToSave = converter.convertProductDTOToProduct(productDTO);
        productRepository.save(productToSave);
        return converter.convertProductToProductDTO(productToSave);
    }

    @Override
    public List<ProductDTO> getProductByCategory(String category) {

        List<Product> products = productRepository.getProductsByCategory(category);
        System.out.println(products.size());
        return products.stream()
                .map(converter::convertProductToProductDTO)
                .collect(Collectors.toList());
    }
}
