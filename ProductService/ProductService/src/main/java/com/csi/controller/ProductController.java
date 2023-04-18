package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Product;
import com.csi.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductServiceImpl productServiceImpl;

    @PostMapping("/savedata")
    public ResponseEntity<Product> saveData(@Valid @RequestBody Product product) {

        return new ResponseEntity<>(productServiceImpl.saveData(product), HttpStatus.CREATED);
    }

    @GetMapping("/getdatabyid/{productId}")
    public ResponseEntity<Product> getDataByid(@PathVariable long productId) {

        return ResponseEntity.ok(productServiceImpl.getDataById(productId).orElseThrow(() -> new RecordNotFoundException("Product Id Does not Exist !!!!")));
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Product>> getAllData() {

        return ResponseEntity.ok(productServiceImpl.getAllData());
    }

    @GetMapping("/getdatabyname/{productName}")
    public ResponseEntity<List<Product>> getDataByName(@PathVariable String productName) {

        return ResponseEntity.ok(productServiceImpl.getAllData().stream().filter(emp -> emp.getProductName().equals(productName)).collect(Collectors.toList()));
    }

    @PutMapping("/updatebyid/{productId}")
    public ResponseEntity<Product> updateById(@PathVariable long productId, @RequestBody Product product) {

        Product product1 = productServiceImpl.getDataById(productId).orElseThrow(() -> new RecordNotFoundException("Product Id does not Exist!!!!!"));

        product1.setProductPrice(product.getProductPrice());
        product1.setProductName(product.getProductName());
        product1.setProductLaunchDate(product.getProductLaunchDate());

        return ResponseEntity.ok(productServiceImpl.updateById(product1));
    }

    @DeleteMapping("/deletebyid/{productId}")
    public ResponseEntity<String> deleteById(@PathVariable long productId) {

        productServiceImpl.deleteById(productId);

        return ResponseEntity.ok("Product Data Deleted Successfully");
    }

}
