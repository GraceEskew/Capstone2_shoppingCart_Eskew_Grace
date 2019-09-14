package com.company.shoppingCart.controller;

//Imports
import com.company.shoppingCart.service.ProductsService;
import com.company.shoppingCart.dto.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ProductsController {
    @Autowired
    ProductsService productsService;

    // GET ALL PRODUCTS - working
    @RequestMapping(value="/products", method = RequestMethod.GET)
    public List<Products> getAllProducts() { return productsService.getAllProducts();
    }

    // GET PRODUCT BY ID - working, but need to put "id": idRequested in body
    @RequestMapping(value ="/products/{id}", method = RequestMethod.GET)
    public Products getProductById(@PathVariable Integer id) {
        return productsService.getProductById(id);
    }

    // GET PRODUCT BY CATEGORY - not working (yet)
//    @RequestMapping(value = "/products/{category}", method = RequestMethod.GET)
//    public List<Products> findByCategoryName(@PathVariable String category) {
//        return productsService.findByCategoryName(category);
//    }

    // ADD A PRODUCT - working
    @RequestMapping(value="/products", method = RequestMethod.POST)
    public Products addProduct(@RequestBody @Valid Products products) {
        return productsService.addProduct(products);
    }

    //UPDATE A PRODUCT BY ID - working
    @RequestMapping(value= "/products/{id}", method = RequestMethod.PUT)
    public Products updateProduct(@RequestBody @Valid Products products, @PathVariable Integer id) {
        return productsService.updateProduct(products, id);
    }

    // DELETE A PRODUCT BY ID - working
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public void  deleteProductById(@PathVariable Integer id) {
        productsService.deleteProductById(id);
    }

    // PURCHASE A PRODUCT
    @RequestMapping(value="/purchase", method = RequestMethod.GET)
    public void purchase(@RequestBody @Valid Products[] products) {
        productsService.purchase(products);
    }

}
