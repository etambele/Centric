package com.example.Centric.Model.DBModel;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private String brand;
    @ElementCollection
    private List<String> tags;
    private String category;
    private ZonedDateTime createdAt;

}