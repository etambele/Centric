package com.example.Centric.Repository;

import com.example.Centric.Model.DBModel.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String>{
}
