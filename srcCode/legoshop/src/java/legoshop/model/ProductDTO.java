/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legoshop.model;

import java.io.Serializable;


public class ProductDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private String productName;
    private int categoryId;
    private String description;
    private int stock;
    private String images;
    private float discount;
    private double price;

    public ProductDTO() {
    }

    public ProductDTO(int id, String productName, int categoryId, String description, int stock, String images, float discount, double price) {
        this.id = id;
        this.productName = productName;
        this.categoryId = categoryId;
        this.description = description;
        this.stock = stock;
        this.images = images;
        this.discount = discount;
        this.price = price;
    }
    
    public ProductDTO(String productName, int categoryId, String description, int stock, String images, float discount, double price) {
        this.productName = productName;
        this.categoryId = categoryId;
        this.description = description;
        this.stock = stock;
        this.images = images;
        this.discount = discount;
        this.price = price;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
