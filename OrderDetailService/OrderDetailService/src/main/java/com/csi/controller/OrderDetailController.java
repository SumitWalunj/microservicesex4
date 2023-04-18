package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.OrderDetail;
import com.csi.service.OrderDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orderdetails")
public class OrderDetailController {

    @Autowired
    OrderDetailServiceImpl orderDetailServiceImpl;

    @PostMapping("/savedata")
    public ResponseEntity<OrderDetail> saveData(@Valid @RequestBody OrderDetail orderDetail) {

        return ResponseEntity.ok(orderDetailServiceImpl.saveData(orderDetail));
    }

    @GetMapping("/getdatabyid/{orderDetailId}")
    public ResponseEntity<OrderDetail> getDataById(@PathVariable long orderDetailId) {

        return ResponseEntity.ok(orderDetailServiceImpl.getDataById(orderDetailId).orElseThrow(() -> new RecordNotFoundException("OrderDetail Id does not Exist!!!!")));
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<OrderDetail>> getAllData() {

        return ResponseEntity.ok(orderDetailServiceImpl.getAllData());
    }

    @GetMapping("/getdatabyname/{companyName}")
    public ResponseEntity<List<OrderDetail>> getDataByName(@PathVariable String companyName) {

        return ResponseEntity.ok(orderDetailServiceImpl.getAllData().stream().filter(emp -> emp.getCompanyName().equals(companyName)).collect(Collectors.toList()));
    }

    @PutMapping("/updatebyid/{orderDetailId}")
    public ResponseEntity<OrderDetail> updateDataById(@PathVariable long orderDetailId, @RequestBody OrderDetail orderDetail) {

        OrderDetail orderDetail1 = orderDetailServiceImpl.getDataById(orderDetailId).orElseThrow(() -> new RecordNotFoundException("OrderDeatilId Does Not Exist!!!!!"));

        orderDetail1.setOrderDetailDate(orderDetail.getOrderDetailDate());
        orderDetail1.setOrderDetailDisc(orderDetail.getOrderDetailDisc());
        orderDetail1.setCompanyName(orderDetail.getCompanyName());

        return ResponseEntity.ok(orderDetailServiceImpl.updateData(orderDetail1));

    }

    @DeleteMapping("/deletebyid/{orderDetailId}")
    public ResponseEntity<String> deleteById(@PathVariable long orderDetailId) {

        orderDetailServiceImpl.deleteById(orderDetailId);

        return ResponseEntity.ok("OrderDetail Deleted successfully");
    }
}
