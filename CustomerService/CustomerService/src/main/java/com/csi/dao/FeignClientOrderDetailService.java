package com.csi.dao;

import com.csi.vo.OrderDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "OrderDetailService", url = "http://localhost:9191")
public interface FeignClientOrderDetailService {

    @GetMapping("/orderdetails/getdatabyid/{orderDetailId}")
    OrderDetail getOrderDetailById(@PathVariable long orderDetailId);
}
