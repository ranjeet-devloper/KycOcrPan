package com.kyc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class OcrRequest {

	private String fileB64;
	private boolean maskAadhar;
	private boolean hideAadhaar;
	private boolean conf;
	private String docType;

}
