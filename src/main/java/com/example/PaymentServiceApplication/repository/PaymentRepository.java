package com.example.PaymentServiceApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PaymentServiceApplication.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
