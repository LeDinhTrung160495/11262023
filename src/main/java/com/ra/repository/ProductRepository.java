package com.ra.repository;

import com.ra.model.Account;
import com.ra.model.Categories;
import com.ra.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("select p from Product p where p.productName like %?1%")
    Page<Product> findByProductName(String productName, Pageable pageable);

    int countByProductNameContains(String productName);

    List<Product> findAll();

    List<Product> findProductByStatusIsTrue();
}
