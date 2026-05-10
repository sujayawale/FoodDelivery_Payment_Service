package com.example.PaymentServiceApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OrderEvent {
	
	private Long orderId;
	
	private Long userId;
	
	private Long restaurantId;
	
	private Double amount;
	
	private String status;

}
