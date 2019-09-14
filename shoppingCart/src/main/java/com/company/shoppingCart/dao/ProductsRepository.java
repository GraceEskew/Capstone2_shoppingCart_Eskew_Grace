package com.company.shoppingCart.dao;

import com.company.shoppingCart.dto.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {
}


//Done.