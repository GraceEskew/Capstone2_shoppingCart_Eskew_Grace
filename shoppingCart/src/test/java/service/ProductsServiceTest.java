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

    List<Products> productsList;

    @Before
    public void setU() {
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

        productsList = Arrays.asList(p1, p2);
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
