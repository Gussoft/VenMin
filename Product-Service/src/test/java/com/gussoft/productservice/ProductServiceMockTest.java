package com.gussoft.productservice;

import com.gussoft.serviceproduct.models.Category;
import com.gussoft.serviceproduct.models.Product;
import com.gussoft.serviceproduct.repository.ProductRepository;
import com.gussoft.serviceproduct.service.ProductService;
import com.gussoft.serviceproduct.service.impl.ProductServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {

    @Mock
    private ProductRepository repo;

    private ProductService service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        service = new ProductServiceImpl(repo);

        Product computer = Product.builder()
                .id(1L)
                .name("computer")
                .category(Category.builder().id(1L).build())
                .price(Double.parseDouble("15.5"))
                .stock(6)
                .build();

        Mockito.when(repo.findById(1L))
                .thenReturn(Optional.of(computer));


        Mockito.when(repo.save(computer)).thenReturn(computer);
    }

    @Test
    void validGetId_ReturnProduct() {
        Product found = service.getProduct(1L);
        Assertions.assertThat(found.getName()).isEqualTo("computer");
    }

    @Test
    void validUpdateStock_ReturnNewStock() {
        Product newStock = service.updateStock(1L, 8);
        Assertions.assertThat(newStock.getStock()).isEqualTo(14);
    }
}
