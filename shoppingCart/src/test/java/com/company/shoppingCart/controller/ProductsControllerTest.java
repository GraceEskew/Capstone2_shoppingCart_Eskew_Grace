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

    //2nd set
    Products p4;
    Products p5;

    //3rd set
    Products p6;
    Products p7;
    Products p8;
    Products p9;

    List<Products> productsList;


    // standalone - used to just test the products Controller
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productsController).build();

        //TEST PRODUCTS SET 1 *************************************************************
        p1 = new Products();
        p1.setName("Children's Book");
        p1.setPrice(12.49f);
        p1.setIsImported(false);
        p1.setIsTaxed(false);
        p1.setCategory("Books");

        p2 = new Products();
        p2.setName("Sing-A-Long");
        p2.setPrice(14.99f);
        p2.setIsImported(false);
        p2.setIsTaxed(true);
        p2.setCategory("Music");

        p3 = new Products();
        p3.setName("Chocolate Bar");
        p3.setPrice(0.85f);
        p3.setIsImported(false);
        p3.setIsTaxed(false);
        p3.setCategory("Food");

        //TEST PRODUCTS SET 2 *************************************************************
        p4 = new Products();
        p4.setName("Le Chocolat");
        p4.setPrice(10.00f);
        p4.setIsImported(true);
        p4.setIsTaxed(false);
        p4.setCategory("Food");

        p5 = new Products();
        p5.setName("Le Stinque");
        p5.setPrice(47.50f);
        p5.setIsImported(true);
        p5.setIsTaxed(true);
        p5.setCategory("Luxury Items");

        //TEST PRODUCTS SET 3 *************************************************************
        p6 = new Products();
        p6.setName("Le Fume");
        p6.setPrice(27.99f);
        p6.setIsImported(true);
        p6.setIsTaxed(true);
        p6.setCategory("Luxury Items");

        p7 = new Products();
        p7.setName("Smells like Teen Spirit");
        p7.setPrice(18.99f);
        p7.setIsImported(false);
        p7.setIsTaxed(true);
        p7.setCategory("Luxury Items");

        p8 = new Products();
        p8.setName("Migraine Relief");
        p8.setPrice(9.75f);
        p8.setIsImported(false);
        p8.setIsTaxed(false);
        p8.setCategory("Medicine");

        p9 = new Products();
        p9.setName("Le Nomz");
        p9.setPrice(11.85f);
        p9.setIsImported(false);
        p9.setIsTaxed(false);
        p9.setCategory("Food");
        //thrown off by the extra sales tax in the requirements. Do I add this as a seperate property?

        productsList = Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9);
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
                .andExpect(jsonPath("$", hasSize(9)))
                .andExpect(jsonPath("$[0].name", is(productsList.get(0).getName())));

        verify(mockProductsService).getAllProducts();
    }

}

