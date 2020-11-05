package com.example.Centric.Controller;

import com.example.Centric.Model.ProductDTO;
import com.example.Centric.Routes.Routes;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ICentricController {

    @RequestMapping(value = Routes.ADD_PRODUCT, method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO itemDTO);

    @RequestMapping(value = Routes.PRODUCT_BY_CATEGORY, method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ProductDTO>> getProductByCategory(@RequestParam String category,
                                                          @RequestParam(required = false) Integer pageSize,
                                                          @RequestParam(required = false) Integer offSet);
}

