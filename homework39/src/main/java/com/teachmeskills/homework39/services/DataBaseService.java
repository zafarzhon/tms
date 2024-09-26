package com.teachmeskills.homework39.services;

import com.teachmeskills.homework39.entities.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Service
public class DataBaseService {
    private List<Product> products;

    public void addProduct(Product product) {
        if (products == null) {
            products = new ArrayList<Product>();
        }
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void update(Product product) {
        for (Product product1 : products) {
            if (product1.getId().equals(product.getId())) {
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
                product1.setCount(product.getCount());
                product1.setIsDelivery(product.getIsDelivery());
                return;
            }
        }
    }

}
