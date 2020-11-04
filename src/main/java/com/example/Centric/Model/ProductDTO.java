package com.example.Centric.Model;

import java.util.List;

public class ProductDTO {

    private String id;
    private String name;
    private String description;
    private String brand;
    private List<String> tags;
    private String category;
    private String createdAt;

    private ProductDTO(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public static class Builder{
        private String id;
        private String name;
        private String description;
        private String brand;
        private List<String> tags;
        private String category;
        private String createdAt;

        public Builder(){

        }

        public Builder id(String id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder brand(String brand){
            this.brand = brand;
            return this;
        }

        public Builder tags(List<String> tags){
            this.tags = tags;
            return this;
        }

        public Builder category(String category){
            this.category = category;
            return this;
        }
        public Builder createdAt(String createdAt){
            this.createdAt = createdAt;
            return this;
        }

        public ProductDTO build(){
            ProductDTO productDTO = new ProductDTO();
            productDTO.id = this.id;
            productDTO.name = this.name;
            productDTO.description = this.description;
            productDTO.brand = this.brand;
            productDTO.tags = this.tags;
            productDTO.category = this.category;
            productDTO.createdAt = this.createdAt;
            return productDTO;
        }

    }
}
