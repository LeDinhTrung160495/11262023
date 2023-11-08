package com.ra.model;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "price")
    private float price;
    @Column(name = "title")
    private String title;
    @Column(name = "product_status")
    private boolean status;

    public Product() {
    }

    public Product(int productId, String productName, float price, String title, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.title = title;
        this.status = status;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
