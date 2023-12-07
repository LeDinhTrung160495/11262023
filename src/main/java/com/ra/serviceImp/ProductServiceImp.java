package com.ra.serviceImp;

import com.ra.model.Categories;
import com.ra.model.Product;
import com.ra.repository.CategoriesRepository;
import com.ra.repository.ProductRepository;
import com.ra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public List<Product> displayData(String productName, int page, int size, String direction, String sortBy) {
        //Khởi tạo đối tượng Pageable
        Pageable pageable = PageRequest.of(page, size,
                direction.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
        List<Product> listProduct = productRepository.findByProductName(productName, pageable).getContent();
        return listProduct;
    }

    @Override
    public List<Integer> getListPage(String productName, int size) {
        int countProduct = productRepository.countByProductNameContains(productName);
        List<Integer> listPage = new ArrayList<>();
        for (int i = 0; i < (int) Math.ceil((double) countProduct / (double) size); i++) {
            listPage.add(i + 1);
        }
        return listPage;
    }

    @Override
    public Product findById(String productId) {
        try {
            Product productById = productRepository.findById(productId).get();
            return productById;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Product save(Product product) {
        try {
            Product proNew = productRepository.save(product);
            return proNew;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Product update(Product product) {
        try {
            Product updatedProduct = productRepository.save(product);
            return updatedProduct;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(String productId) {
        try {
            productRepository.deleteById(productId);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean productHaveCatalogId(int catalogId) {
        List<Product> productList = productRepository.findAll().stream().filter(product -> product.getCatalog().getCatalogId() == catalogId).collect(Collectors.toList());
        return productList.size() > 0;
    }

    @Override
    public int statisticalProductActive() {
        return productRepository.findProductByStatusIsTrue().size();
    }

    @Override
    public int statisticalProductInactive() {
        return (productRepository.findAll().size() - productRepository.findProductByStatusIsTrue().size());
    }

    @Override
    public List<Product> getAllData() {
        return productRepository.findAll();
    }
}
