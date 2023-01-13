package com.kyc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Getter
public class OcrPanResponse {
	
	private Integer statusCode;
	private String requestId;
	private Result[] result;
}
