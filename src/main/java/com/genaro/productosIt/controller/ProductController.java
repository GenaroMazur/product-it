package com.genaro.productosIt.controller;

import com.genaro.productosIt.entity.Product;
import com.genaro.productosIt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ArrayList<Product> getProducts(@RequestParam Map<String, String> params) {
        Product query = new Product();

        params.forEach((key, value) -> {
            switch (key) {
                case "id":
                    query.setId(Long.parseLong(value));
                    break;
                case "name":
                    query.setName(value);
                    break;
                case "description":
                    query.setDescription(value);
                    break;
                case "price":
                    query.setPrice(Double.parseDouble(value));
                    break;
                case "photo":
                    query.setPhoto(value);
                    break;
            }
        });

        return productService.getProducts(query);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {

        Product query = new Product();

        query.setId(id);

        return productService.getProduct(query);
    }

    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {

        return new ResponseEntity<Product>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {

        return new ResponseEntity<Product>(productService.updateProduct(id, product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}