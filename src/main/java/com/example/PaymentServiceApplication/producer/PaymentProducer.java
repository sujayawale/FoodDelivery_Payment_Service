package com.example.PaymentServiceApplication.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.PaymentServiceApplication.dto.PaymentEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentProducer {

	private final KafkaTemplate<String, PaymentEvent> kafkaTemplate;
//	private PaymentProducer(KafkaTemplate<String, PaymentEvent> kafkaTemplate) {
//		this.kafkaTemplate=kafkaTemplate;
	    public void publish(PaymentEvent event) {
	    	kafkaTemplate.send(
               "payment-completed-topic", event
	    	);
	}
}
