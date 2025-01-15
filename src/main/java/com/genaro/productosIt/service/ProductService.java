package com.genaro.productosIt.service;

import com.genaro.productosIt.entity.Product;
import com.genaro.productosIt.expections.ResourceNotFoundException;
import com.genaro.productosIt.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ArrayList<Product> getProducts(Product query) {
        return productRepository.find(query);
    }

    public Product getProduct(Product query) {
        return productRepository.findOne(query).orElseThrow(ResourceNotFoundException::new);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product query = new Product();
        query.setId(id);

        return productRepository.update(query, product).orElseThrow(ResourceNotFoundException::new);
    }

    public void deleteProduct(Long id) {
        Product query = new Product();

        query.setId(id);

        productRepository.delete(query);
    }
}
