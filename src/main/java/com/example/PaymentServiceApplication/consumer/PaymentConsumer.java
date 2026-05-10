package com.example.PaymentServiceApplication.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.PaymentServiceApplication.dto.OrderEvent;
import com.example.PaymentServiceApplication.service.PaymentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentConsumer {
	
	private final PaymentService paymentService;
	
	@KafkaListener(
			topics = "order-created-topic",
			groupId="payment-group"
	)
	public void consume(OrderEvent event) {
		System.out.println("Order Event Received: "+ event);
		paymentService.processPayment(event);
	}
	
}
