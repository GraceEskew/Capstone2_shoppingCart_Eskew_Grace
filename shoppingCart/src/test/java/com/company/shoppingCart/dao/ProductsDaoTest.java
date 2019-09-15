package com.company.shoppingCart.dao;


import com.company.shoppingCart.dto.Products;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsDaoTest {
    @Autowired
    ProductsRepository productsRepo;

    Products p1;
    Products p2;

    @Before
    public void setUp() {
        productsRepo.deleteAll();

        p1 = new Products();
        p1.setName("Le Chocolat");
        p1.setPrice(10.00f);
        p1.setIsImported(true);
        p1.setImportTax(0.05f);
        p1.setIsTaxed(false);
        p1.setSalesTax(.10f);
        p1.setCategory("Food");
        p1.setQuantity(1);

        p2 = new Products();
        p2.setName("Le Stinque");
        p2.setPrice(47.50f);
        p2.setIsImported(true);
        p2.setImportTax(0.05f);
        p2.setSalesTax(0.10f);
        p2.setIsTaxed(true);
        p2.setCategory("Luxury Items");
        p2.setQuantity(1);
    }

    @Test
    @Transactional
    public void shouldGetProducts() {
        productsRepo.save(p1);
        productsRepo.save(p2);

        List<Products> productsList = new ArrayList<>();
        productsList.add(p1);
        productsList.add(p2);

        List<Products> fromRepo = productsRepo.findAll();

        assertEquals(productsList, fromRepo);

//        assertEquals(productsList, fromRepo);
    }

    @Test
    @Transactional
    public void shouldGetProductById() {
        Products addedProducts = productsRepo.save(p1);
        int id = addedProducts.getId();

        Products fromRepo = productsRepo.getOne(id);

        assertEquals(addedProducts, fromRepo);
    }

    @Test
    @Transactional
    public void shouldUpdateProduct() {
        Products addedProducts = productsRepo.save(p1);
        addedProducts.setName("Marzi's Deadpan Chocolate");

        productsRepo.save(addedProducts);

        List<Products> fromRepo = productsRepo.findAll();

        assertEquals(fromRepo.size(), 1);
        assertEquals(fromRepo.get(0).getName(), "Marzi's Deadpan Chocolate" );
    }

    @Test
    @Transactional
    public void shouldDeleteProduct() {
        Products addedProducts = productsRepo.save(p1);

        productsRepo.deleteById(addedProducts.getId());

        Optional<Products> fromRepo = productsRepo.findById(p1.getId());
        assertFalse(fromRepo.isPresent());

//        List<Products> fromRepo = productsRepo.findAll();
//
//        assertEquals(fromRepo.size(), 0);
    }


}
