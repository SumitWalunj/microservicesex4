package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Customer {

    @Id
    private long custId;

    @Size(min = 2, message = "Customer Name should have 2 Characters")
    private String custName;

    private String custAddress;

    private long custContactNumber;

    private double custAccountBalance;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date custDOB;

    @Column(unique = true)
    @Email(message = "Email must be Valid")
    private String custEmailId;

    @Size(min = 4, message = "Customer Password must have 4 characters")
    private String custPassword;

    private long productId;

    private long orderDetailId;
}
