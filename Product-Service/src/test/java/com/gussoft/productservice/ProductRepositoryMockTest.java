package com.gussoft.productservice;

import com.gussoft.serviceproduct.models.Category;
import com.gussoft.serviceproduct.models.Product;
import com.gussoft.serviceproduct.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductRepositoryMockTest {

    @Autowired
    private ProductRepository repo;

    @Test
    public void whenFindCategory_returnListProduct() {
        Product p1 = Product.builder()
                .name("computer")
                .category(Category.builder().id(1L).build())
                .description("")
                .stock(5)
                .price(Double.parseDouble("905.99"))
                .status("Created")
                .createAt(new Date()).build();

        repo.save(p1);

        List<Product> founds = repo.findByCategory(p1.getCategory());

        Assertions.assertThat(founds.size()).isEqualTo(0);
    }
}
