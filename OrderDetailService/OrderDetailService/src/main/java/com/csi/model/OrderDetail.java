package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetail {

    @Id
    private long orderDetailId;

    @Size(min = 2, message = "Company Name should have atleast 2 characters")
    private String companyName;

    private String orderDetailDisc;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date orderDetailDate;


}
