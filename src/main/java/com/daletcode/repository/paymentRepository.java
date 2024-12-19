package com.daletcode.repository;

import com.daletcode.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface paymentRepository extends JpaRepository<Payment,Long> {
}
