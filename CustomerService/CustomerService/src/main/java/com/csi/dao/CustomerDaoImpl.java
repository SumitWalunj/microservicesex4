package com.csi.dao;

import com.csi.model.Customer;
import com.csi.repo.CustomerRepo;
import com.csi.vo.FeignClientVO;
import com.csi.vo.OrderDetail;
import com.csi.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDaoImpl {

    @Autowired
    CustomerRepo customerRepoImpl;

    @Autowired
    FeignClientProductService feignClientProductService;

    @Autowired
    FeignClientOrderDetailService feignClientOrderDetailService;


    public Customer signUp(Customer customer) {

        return customerRepoImpl.save(customer);
    }

    public boolean signIn(String custEmailId, String custPassword) {

        boolean flag = false;

        for (Customer customer : getAllData()) {

            if (customer.getCustEmailId().equals(custEmailId)
                    && customer.getCustPassword().equals(custPassword)) {

                flag = true;
            }
        }
        return flag;
    }

    public List<Customer> getAllData() {

        return customerRepoImpl.findAll();
    }

    public FeignClientVO getDataById(long custId) {

        FeignClientVO feignClientVO = new FeignClientVO();

        Customer customer = customerRepoImpl.findByCustId(custId);
        Product product = feignClientProductService.getProductById(customer.getProductId());
        OrderDetail orderDetail = feignClientOrderDetailService.getOrderDetailById(customer.getOrderDetailId());

        feignClientVO.setCustomer(customer);
        feignClientVO.setProduct(product);
        feignClientVO.setOrderDetail(orderDetail);

        return feignClientVO;
    }

    public List<Customer> getDataByName(String custName) {

        return customerRepoImpl.findByCustName(custName);
    }

    public Customer getDataByEmailId(String custEmailId) {

        return customerRepoImpl.findByCustEmailId(custEmailId);
    }

    public Customer updateData(Customer customer) {

        return customerRepoImpl.save(customer);
    }

    public void deleteById(long custId) {

        customerRepoImpl.deleteById(custId);
    }
}
