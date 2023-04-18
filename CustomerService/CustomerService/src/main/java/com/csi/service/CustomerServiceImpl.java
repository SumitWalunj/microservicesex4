package com.csi.service;

import com.csi.dao.CustomerDaoImpl;
import com.csi.model.Customer;
import com.csi.vo.FeignClientVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl {

    @Autowired
    CustomerDaoImpl customerDaoImpl;

    public Customer signUp(Customer customer) {

        return customerDaoImpl.signUp(customer);
    }

    public List<Customer> getAllData() {

        return customerDaoImpl.getAllData();
    }

    public FeignClientVO getDataById(long custId) {

        return customerDaoImpl.getDataById(custId);
    }

    public List<Customer> getDataByName(String custName) {

        return customerDaoImpl.getDataByName(custName);
    }

    public Customer getDataByEmailId(String custEmailId) {

        return customerDaoImpl.getDataByEmailId(custEmailId);
    }

    public Customer updateData(Customer customer) {

        return customerDaoImpl.updateData(customer);
    }

    public void deleteById(long custId) {

        customerDaoImpl.deleteById(custId);
    }

    public boolean signIn(String custEmailId, String custPassword) {

        return customerDaoImpl.signIn(custEmailId, custPassword);
    }
}
