package com.gussoft.serviceproduct.repository;

import com.gussoft.serviceproduct.models.Category;
import com.gussoft.serviceproduct.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(Category category);
}
