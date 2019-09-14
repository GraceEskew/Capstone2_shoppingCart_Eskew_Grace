package com.company.shoppingCart.service;

import com.company.shoppingCart.dao.ProductsRepository;
import com.company.shoppingCart.dto.Products;
import com.company.shoppingCart.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ProductsService {
    @Autowired
    ProductsRepository productsRepo;

    //GET ALL PRODUCTS
    public List<Products> getAllProducts() {
        return productsRepo.findAll();
    }

    //GET ONE PRODUCT BY ID
    public Products getProductById(Integer id) {
        return productsRepo.getOne(id);
    }

//    public List<Products> getProductByCategory(String category) {
//        return productsRepo.findByCategoryName(category);
//    }

    //ADD ONE PRODUCT
    public Products addProduct(Products products) {
        return productsRepo.save(products);
    }

    //UPDATE PRODUCT BY ID
    public Products updateProduct(Products products, Integer id) {
        if (products.getId() == id) {
            return productsRepo.save(products);
        }

        return null;
    }

    //DELETE PRODUCT BY ID
    public void deleteProductById(Integer id) {
        productsRepo.deleteById(id);
    }

    public void purchase(Products[] products) {
        for (Products p : products) {
            Products currProducts = this.getProductById(p.getId());

            currProducts.setQuantity(currProducts.getQuantity() - p.getQuantity());
            this.updateProduct(currProducts, currProducts.getId());
        }
   }



}

