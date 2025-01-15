package com.genaro.productosIt.repository;

import com.genaro.productosIt.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public class ProductRepository implements RepositoryI<Product> {
    private final ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> find(Product query) {
        return products.stream().filter(product -> {
            if (query.getId() != null && !query.getId().equals(product.getId())) {
                return false;
            }
            if (query.getName() != null && !product.getName().toLowerCase().contains(query.getName().toLowerCase())) {
                return false;
            }
            if (query.getDescription() != null && !product.getDescription().toLowerCase().contains(query.getDescription().toLowerCase())) {
                return false;
            }
            if (query.getPrice() != null && !product.getPrice().equals(query.getPrice())) {
                return false;
            }
            return true;
        }).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public Optional<Product> findOne(Product query) {
        return products.stream().filter(product -> {
            if (query.getId() != null && !query.getId().equals(product.getId())) {
                return false;
            }
            if (query.getName() != null && !product.getName().toLowerCase().contains(query.getName().toLowerCase())) {
                return false;
            }
            if (query.getDescription() != null && !product.getDescription().toLowerCase().contains(query.getDescription().toLowerCase())) {
                return false;
            }
            if (query.getPrice() != null && !product.getPrice().equals(query.getPrice())) {
                return false;
            }
            return true;
        }).findFirst();
    }

    public Product save(Product product) {

        product.setId(Product.getAutoIncrement());

        products.add(product);

        return product;
    }

    public Optional<Product> update(Product query, Product product) {

        Product productToUpdate = findOne(query).orElse(null);

        if (productToUpdate != null) {
            productToUpdate.setName(product.getName());
            productToUpdate.setDescription(product.getDescription());
            productToUpdate.setPrice(product.getPrice());
            productToUpdate.setPhoto(product.getPhoto());
            return Optional.of(productToUpdate);
        }

        return Optional.empty();
    }

    public void delete(Product entity) {

        products.removeIf(product -> product.getId().equals(entity.getId()));
    }

}
