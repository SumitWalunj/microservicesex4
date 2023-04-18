package com.csi.repo;

import com.csi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {

    public Customer findByCustId(long custId);

    public List<Customer> findByCustName(String custName);

    public Customer findByCustEmailId(String custEmailId);


}
