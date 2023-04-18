package com.csi.dao;

import com.csi.model.Product;
import com.csi.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductDaoImpl {

    @Autowired
    ProductRepo productRepoImpl;

    public Product saveData(Product product) {

        return productRepoImpl.save(product);

    }

    public Optional<Product> getDataById(long productId) {

        return productRepoImpl.findById(productId);
    }

    public List<Product> getAllData() {

        return productRepoImpl.findAll();
    }

    public Product updateById(Product product) {

        return productRepoImpl.save(product);
    }

    public void deleteById(long productId) {

        productRepoImpl.deleteById(productId);
    }
}
