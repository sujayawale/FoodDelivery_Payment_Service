package com.example.PaymentServiceApplication.service;

import org.springframework.stereotype.Service;

import com.example.PaymentServiceApplication.dto.OrderEvent;
import com.example.PaymentServiceApplication.dto.PaymentEvent;
import com.example.PaymentServiceApplication.entity.Payment;
import com.example.PaymentServiceApplication.producer.PaymentProducer;
import com.example.PaymentServiceApplication.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {
	
	private final PaymentRepository repository;
	
	private final PaymentProducer producer;
	
	public void processPayment(OrderEvent orderEvent) {
		Payment payment = Payment.builder()
				.orderId(orderEvent.getOrderId())
				.amount(orderEvent.getAmount())
				.paymentStatus("SUCCESS")
				.build();
		Payment savePayment= repository.save(payment);
		
		PaymentEvent paymentEvent= PaymentEvent.builder()
				.paymentId(savePayment.getId())
				.orderId(savePayment.getOrderId())
				.amount(savePayment.getAmount())
				.paymentStatus(savePayment.getPaymentStatus())
				.build();
		producer.publish(paymentEvent);
		
		System.out.println("Payment Processed Successfully");
	}

}
