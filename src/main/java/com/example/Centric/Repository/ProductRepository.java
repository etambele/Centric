package com.example.Centric.Repository;

import com.example.Centric.Model.DBModel.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, String>{

    List<Product> getProductsByCategory(String category);
}
