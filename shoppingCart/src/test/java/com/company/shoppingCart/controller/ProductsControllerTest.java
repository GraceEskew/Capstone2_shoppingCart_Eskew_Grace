package com.company.shoppingCart.controller;

import com.company.shoppingCart.service.ProductsService;
import com.company.shoppingCart.dto.Products;
import com.company.shoppingCart.controller.ProductsController;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//Creating the test class
public class ProductsControllerTest {

    //Spring test & Sets up the Mock container
    private MockMvc mockMvc;

    @Mock
    ProductsService mockProductsService;

    @InjectMocks
    ProductsController productsController;

    //1st set
    Products p1;
    Products p2;
    Products p3;

    List<Products> productsList;

    // standalone - used to just test the products Controller
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productsController).build();

        //TEST PRODUCTS SET 1 *************************************************************
        p1 = new Products();
        p1.setName("The Cat in the Hat");
        p1.setPrice(12.49f);
        p1.setIsImported(false);
        p1.setImportTax(0.00f);
        p1.setIsTaxed(false);
        p1.setSalesTax(0.00f);
        p1.setQuantity(5);
        p1.setCategory("books");
        p1.setImgUrl("void");

        p2 = new Products();
        p2.setName("The Great War");
        p2.setPrice(14.99f);
        p2.setIsImported(false);
        p2.setImportTax(0.00f);
        p2.setIsTaxed(true);
        p2.setSalesTax(1.50f);
        p2.setQuantity(50);
        p2.setCategory("music");
        p2.setImgUrl("void");

        p3 = new Products();
        p3.setName("Dark Chocolate Bar - 12oz");
        p3.setPrice(0.85f);
        p3.setIsImported(false);
        p3.setImportTax(0.00f);
        p3.setIsTaxed(true);
        p3.setSalesTax(0.10f);
        p3.setQuantity(100);
        p3.setCategory("luxury goods");
        p3.setImgUrl("void");

        productsList = Arrays.asList(p1, p2, p3);
    }

    //Test 1: Simulates 404
    @Test
    public void rootContext_shouldRespondWith404() throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(status().isNotFound());
    }

    //Test 2
    @Test
    public void shouldReturnAllProducts() throws Exception {
        when(mockProductsService.getAllProducts()).thenReturn(productsList);

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].name", is(productsList.get(0).getName())));

        verify(mockProductsService).getAllProducts();
    }

}

