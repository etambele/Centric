package com.example.Centric.Service;

import com.example.Centric.Model.DBModel.Product;
import com.example.Centric.Model.ProductDTO;
import com.example.Centric.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
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
    public List<ProductDTO> getProductByCategory(String category, Integer pageSize, Integer offSet){

        List<Product> products = productRepository.getProductsByCategory(category);
        List<ProductDTO> productDTOS = products.stream()
                .sorted(Comparator.comparing(Product::getCreatedAt))
                .map(converter::convertProductToProductDTO)
                .collect(Collectors.toList());
        if(pageSize != null && offSet != null && offSet <= productDTOS.size()){
            productDTOS = productDTOS.subList(offSet, Math.min(offSet + pageSize, productDTOS.size()));
        }

        return productDTOS;
    }
}
