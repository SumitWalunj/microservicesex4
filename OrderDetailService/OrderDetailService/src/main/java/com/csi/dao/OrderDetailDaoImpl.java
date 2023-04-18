package com.csi.dao;

import com.csi.model.OrderDetail;
import com.csi.repo.OrderDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderDetailDaoImpl {

    @Autowired
    OrderDetailRepo orderDetailRepoImpl;


    public OrderDetail saveData(OrderDetail orderDetail) {

        return orderDetailRepoImpl.save(orderDetail);
    }

    public Optional<OrderDetail> getDataById(long orderDetailId) {

        return orderDetailRepoImpl.findById(orderDetailId);
    }

    public List<OrderDetail> getAllData() {

        return orderDetailRepoImpl.findAll();
    }

    public OrderDetail updateData(OrderDetail orderDetail) {

        return orderDetailRepoImpl.save(orderDetail);
    }

    public void deleteById(long orderDetailId) {

        orderDetailRepoImpl.deleteById(orderDetailId);
    }
}
