package com.gussoft.serviceproduct.service;

import com.gussoft.serviceproduct.models.Category;
import com.gussoft.serviceproduct.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> listAllProduct();

    Product getProduct(Long id);

    Product createProduct(Product obj);

    Product updateProduct(Product obj);

    Product deleteProduct(Long id);

    List<Product> findByCategory(Category obj);

    Product updateStock(Long id, Integer quantity);
}
