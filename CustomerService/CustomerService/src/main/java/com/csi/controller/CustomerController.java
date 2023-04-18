package com.csi.controller;

import com.csi.model.Customer;
import com.csi.repo.CustomerRepo;
import com.csi.service.CustomerServiceImpl;
import com.csi.vo.FeignClientVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerServiceImpl;

    @Autowired
    CustomerRepo customerRepoImpl;

    @PostMapping("/signup")
    public ResponseEntity<Customer> signUp(@Valid @RequestBody Customer customer) {

        return new ResponseEntity<>(customerServiceImpl.signUp(customer), HttpStatus.CREATED);
    }

    @GetMapping("/signin/{custEmailId}/{custPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String custEmailId, @PathVariable String custPassword){

        return ResponseEntity.ok(customerServiceImpl.signIn(custEmailId,custPassword));
    }

    @GetMapping("/getdatabyid/{custId}")
    public ResponseEntity<FeignClientVO> getDataById(@PathVariable long custId) {

        return ResponseEntity.ok(customerServiceImpl.getDataById(custId));
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Customer>> getAllData() {

        return ResponseEntity.ok(customerServiceImpl.getAllData());
    }

    @GetMapping("/getdatabyname/{custName}")
    public ResponseEntity<List<Customer>> getDataByName(@PathVariable String custName){

        return ResponseEntity.ok(customerServiceImpl.getDataByName(custName));
    }

    @GetMapping("/getdatabyemailid/{custEmailId}")
    public ResponseEntity<Customer> getDataByEmailId(@PathVariable String custEmailId){

        return ResponseEntity.ok(customerServiceImpl.getDataByEmailId(custEmailId));
    }

    @PutMapping("/updatedata/{custId}")
    public ResponseEntity<Customer> updateData(@Valid @PathVariable long custId, @RequestBody Customer customer){

        Customer customer1 = customerRepoImpl.findByCustId(custId);

        customer1.setCustName(customer.getCustName());
        customer1.setCustAddress(customer.getCustAddress());
        customer1.setCustContactNumber(customer.getCustContactNumber());
        customer1.setCustEmailId(customer.getCustEmailId());
        customer1.setCustDOB(customer.getCustDOB());
        customer1.setCustPassword(customer.getCustPassword());
        customer1.setCustAccountBalance(customer.getCustAccountBalance());

        return new ResponseEntity<>(customerServiceImpl.updateData(customer1),HttpStatus.CREATED);
    }

    @DeleteMapping("/deletebyid/{custId}")
    public ResponseEntity<String> deleteDataById(@PathVariable long custId){

        customerServiceImpl.deleteById(custId);

        return ResponseEntity.ok("Customer Data Deleted Successfully");
    }
}
