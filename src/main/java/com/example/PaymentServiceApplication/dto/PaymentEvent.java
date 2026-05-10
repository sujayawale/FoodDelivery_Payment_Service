package com.example.PaymentServiceApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentEvent {

	private Long paymentId;
	
	private Long orderId;
	
	private Double amount;
	
	private String paymentStatus;
}
