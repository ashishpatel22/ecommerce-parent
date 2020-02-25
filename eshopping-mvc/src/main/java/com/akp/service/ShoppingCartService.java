package com.akp.service;

import com.akp.exception.NotEnoughProductsInStockException;
import com.akp.model.Product;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author Aashish Patel
 * Contract for shopping cart services
 */
public interface ShoppingCartService {

    void addProduct(Product product);

    void removeProduct(Product product);

    Map<Product, Integer> getProductsInCart();

    void checkout() throws NotEnoughProductsInStockException;

    BigDecimal getTotal();
}
