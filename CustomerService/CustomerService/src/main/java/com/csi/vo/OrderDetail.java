package com.csi.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderDetail {

    private long orderDetailId;

    private String companyName;

    private String orderDetailDisc;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date orderDetailDate;
}
