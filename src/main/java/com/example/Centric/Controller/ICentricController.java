package com.example.Centric.Controller;

import com.example.Centric.Model.ProductDTO;
import com.example.Centric.Routes.Routes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ICentricController {

    @RequestMapping(value = Routes.ADD_PRODUCT, method= RequestMethod.POST)
    ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO itemDTO);

    @RequestMapping(value = Routes.PRODUCT_BY_CATEGORY, method= RequestMethod.GET)
    ResponseEntity<List<ProductDTO>> getProductByCategory(@RequestParam String category);
}

