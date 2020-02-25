package com.akp.service;

import com.akp.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Aashish Patel
 * Contract for product services
 */
import java.util.Optional;

public interface ProductService {

    Optional<Product> findById(Long id);

    Page<Product> findAllProductsPageable(Pageable pageable);

}
