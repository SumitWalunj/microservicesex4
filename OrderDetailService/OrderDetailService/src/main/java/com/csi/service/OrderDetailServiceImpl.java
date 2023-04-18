package com.csi.service;

import com.csi.dao.OrderDetailDaoImpl;
import com.csi.model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl {

    @Autowired
    OrderDetailDaoImpl orderDetailDaoImpl;


    public OrderDetail saveData(OrderDetail orderDetail) {

        return orderDetailDaoImpl.saveData(orderDetail);
    }

    public Optional<OrderDetail> getDataById(long orderDetailId) {

        return orderDetailDaoImpl.getDataById(orderDetailId);
    }

    public List<OrderDetail> getAllData() {

        return orderDetailDaoImpl.getAllData();
    }

    public OrderDetail updateData(OrderDetail orderDetail) {

        return orderDetailDaoImpl.updateData(orderDetail);
    }

    public void deleteById(long orderDetailId) {

         orderDetailDaoImpl.deleteById(orderDetailId);
    }
}
