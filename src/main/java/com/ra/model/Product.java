package com.ra.model;

import javax.persistence.*;
import java.util.List;

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
    @Column(name = "product_image")
    private String image;
    @OneToMany(mappedBy = "product")
    private List<Images> listImages;

    public Product() {
    }

    public Product(int productId, String productName, float price, String title, boolean status, String image, List<Images> listImages) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.title = title;
        this.status = status;
        this.image = image;
        this.listImages = listImages;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Images> getListImages() {
        return listImages;
    }

    public void setListImages(List<Images> listImages) {
        this.listImages = listImages;
    }
}
