package com.company.shoppingCart.dao;

import com.company.shoppingCart.dto.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {

    List<Products> findProductsByCategory(String category);
}


//Done.