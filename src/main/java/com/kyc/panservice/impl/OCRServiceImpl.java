package com.kyc.panservice.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kyc.entity.OCRDataBase;
import com.kyc.entity.OcrPanResponse;
import com.kyc.entity.OcrRequest;
import com.kyc.panservice.IOCRService;

@Service
public class OCRServiceImpl implements IOCRService {

	private OCRResponseLogImpl oCRResponseLogImpl;

	/**
	 * this method is used to get the detail from PAN card using OCR Api.
	 * 
	 * @param ocrRequest:- it has base64 of given document(i.e PAN card) in from of
	 *                     string.
	 * @return OcrPanResponse:-after scanning the document it send the all details
	 *         as response.
	 */
	@Override
	public OcrPanResponse getDetails(OcrRequest ocrRequest) {
		RestTemplate restTemplat = new RestTemplate();
		String uri = "https://testapi.karza.in/v3/ocr/kyc";
		HttpHeaders headers = new HttpHeaders();
		headers.add("x-karza-key", "RvOtIFlQRfLVW9YL");
		HttpEntity<Object> entity = new HttpEntity<>(ocrRequest, headers);
		ResponseEntity<OcrPanResponse> resp = restTemplat.exchange(uri, HttpMethod.POST, entity, OcrPanResponse.class);
		Map<String, OcrPanResponse> detail = new HashMap<>();
		detail.put("PAN", resp.getBody());
		OCRDataBase oCRDataBase = OCRDataBase.builder().approved("no").poa("no").poi("yes").response(detail).build();
		oCRResponseLogImpl.saveResponse(oCRDataBase);
		return resp.getBody();
	}

}
