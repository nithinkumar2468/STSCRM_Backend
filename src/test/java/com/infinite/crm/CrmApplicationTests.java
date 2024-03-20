package com.infinite.crm;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.infinite.crm.model.Products;
import com.infinite.crm.repository.ProductRepository;
import com.infinite.crm.service.ProductService;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CrmApplicationTests {
	
	

	@Autowired
	private ProductService service;

	@MockBean
	private ProductRepository repository;

	@Test 
	public void getallProducts() {
       when(repository.findAll()).thenReturn(Stream.of (new Products(2L,"Samsung","4",20000L,"samsung"),
    		   new Products(4L,"Realme","5",20000L,"realme")) .collect(Collectors.toList()));
       System.out.println(service.productList());
       assertEquals(2,service.productList().size()); 
  }

	@Test
	public void getProductbyId() {
		Long id = 2L;
		
		  when(repository.findById(id)).thenReturn(Optional.of(new
		  Products(2L,"Samsung","4",20000L,"samsung")));
		 
		assertEquals("Samsung",service.productById(id).getPname());
	}
	
	/*
	 * @Test public void
	 */

}
