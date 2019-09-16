package service;

import com.company.shoppingCart.dao.ProductsRepository;
import com.company.shoppingCart.dto.Products;
import com.company.shoppingCart.service.ProductsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class ProductsServiceTest {

    @Mock
    @Autowired
    ProductsRepository productRepoMock;

    @InjectMocks
    ProductsService productsService;

    Products p1;
    Products p2;
    Products p3;
    Products p4;

    List<Products> productsList;

    @Before
    public void setUp() {

        p1 = new Products();
        p1.setName("Return of Pepe Le Pew");
        p1.setPrice(27.99f);
        p1.setIsImported(true);
        p1.setImportTax(1.40f);
        p1.setIsTaxed(true);
        p1.setSalesTax(2.80f);
        p1.setQuantity(1);
        p1.setCategory("luxury goods");
        p1.setImgUrl("void");

        p2 = new Products();
        p2.setName("Smells Like Teen Spirit (The Perfume)");
        p2.setPrice(18.99f);
        p2.setIsImported(false);
        p2.setImportTax(0.00f);
        p2.setIsTaxed(true);
        p2.setSalesTax(1.90f);
        p2.setQuantity(10);
        p2.setCategory("luxury goods");
        p2.setImgUrl("void");

        p3 = new Products();
        p3.setName("Migraine Relief - Single Pack");
        p3.setPrice(9.75f);
        p3.setIsImported(false);
        p3.setImportTax(0.00f);
        p3.setIsTaxed(false);
        p3.setSalesTax(0.00f);
        p3.setQuantity(10);
        p3.setCategory("medical supplies");
        p3.setImgUrl("void");

        p4 = new Products();
        p4.setName("German Chocolates - 1 box");
        p4.setPrice(11.25f);
        p4.setIsImported(true);
        p4.setImportTax(0.60f);
        p4.setIsTaxed(true);
        p4.setSalesTax(1.15f);
        p4.setQuantity(50);
        p4.setCategory("luxury goods");
        p4.setImgUrl("void");


        productsList = Arrays.asList(p1, p2, p3, p4);
    }

    @Test
    public void shouldGetAllProducts() {
        when(productRepoMock.findAll()).thenReturn(productsList);
        assertEquals(productsList, productsService.getAllProducts());
    }

    @Test
    public void shouldGetProductById() {
        when(productRepoMock.getOne(1)).thenReturn(p1);
        assertEquals(p1, productsService.getProductById(1));
    }

    @Test
    public void shouldAddProduct() {
        when(productRepoMock.save(p2)).thenReturn(p2);
        assertEquals(p2, productsService.addProduct(p2));
    }

    @Test
    public void shouldDeleteProduct() {
        productsService.deleteProductById(1);
        verify(productRepoMock, times(1)).deleteById(1);
    }

    @Test
    public void shouldReturnTotalTaxes() {

    }


}
