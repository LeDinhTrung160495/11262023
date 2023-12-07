package com.ra.service;

import com.ra.model.Account;
import com.ra.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> displayData(String productName, int page, int size, String direction, String sortBy);

    List<Integer> getListPage(String productName, int size);

    Product findById(String productId);

    Product save(Product product);

    Product update(Product product);

    boolean delete(String productId);

    boolean productHaveCatalogId(int catalogId);

    int statisticalProductActive();

    int statisticalProductInactive();

    List<Product> getAllData();
}
