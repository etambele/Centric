package com.example.Centric.Controller;

import com.example.Centric.Model.ProductDTO;
import com.example.Centric.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class CentricController implements ICentricController{

    ProductService productService;

    @Autowired
    public CentricController(ProductService productService){
        this.productService = productService;
    }

    @Override
    public ResponseEntity<ProductDTO> addProduct(ProductDTO productDTO) {
        return new ResponseEntity<>(productService.addProduct(productDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ProductDTO>> getProductByCategory(String category) {
        return new ResponseEntity<>(productService.getProductByCategory(category), HttpStatus.OK);
    }
}
