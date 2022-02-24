package com.abc.ecom.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.ecom.entity.Product;
import com.abc.ecom.repository.ProductRepository;

@SpringBootTest
public class ProductServiceTest {
	
	@InjectMocks
	private ProductService productService = new ProductServiceImpl();
	
	@Mock
	private ProductRepository productRepository;
	
	@Test
	public void testSaveProduct() {
		
		Product product = new Product();
		product.setProductName("Iphone13");
		product.setProductId(1);
		product.setProductPrice(150000);
		product.setProductCategory("Mobile");
		product.setCreateOn(LocalDate.of(2000, 10, 15));
		
		Optional<Product> optionalProduct = Optional.of(product);
		int productId = 1;
		
		when(productRepository.findById(1)).thenReturn(optionalProduct);
		
		Product existingProduct = productService.getProductById(productId);
		
		assertEquals(product.getProductName(),existingProduct.getProductName());
	}

	@Test
    public void deleteProductById() {

        int productId = 222;

        Product product = new Product();
        product.setProductId(222);
        product.setProductName("dummyname");
        product.setProductPrice(11111);
        product.setCreateOn(LocalDate.of(2000, 10, 10));
        product.setProductCategory("dummy");

        Optional<Product> optionalProduct = Optional.of(product);

        when(productRepository.findById(222)).thenReturn(optionalProduct);   

        productService.deleteProduct(product.getProductId());

        verify(productRepository,times(1)).deleteById(productId);   

        //doNothing().when(productRepository).deleteById(product.getProductId());

    }
}