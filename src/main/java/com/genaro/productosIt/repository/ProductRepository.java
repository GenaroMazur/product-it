package com.genaro.productosIt.repository;

import com.genaro.productosIt.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public class ProductRepository extends AbstractRepository<Product> {
    public ArrayList<Product> find(Product query) {
        return super.entities.stream().filter(product -> {
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
        return super.entities.stream().filter(product -> {
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
}
