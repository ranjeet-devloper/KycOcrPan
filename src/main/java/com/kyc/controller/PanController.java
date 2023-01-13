package com.kyc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.kyc.entity.OcrPanResponse;
import com.kyc.entity.OcrRequest;
import com.kyc.panservice.impl.OCRServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("v1/pan/ocr")
public class PanController {

	@Autowired
	private OCRServiceImpl oCRServiceImpl;

	@Autowired
	Gson gson;

	/**
	 * This end point is use for getting the data from OCR.
	 * 
	 * @param ocrRequest
	 * @return
	 */
	@PostMapping("/getpandetails")
	public ResponseEntity<OcrPanResponse> getData(@RequestBody String ocrRequest) {

		log.info(gson.toJson(String.format("Request for Ocr is %s", ocrRequest)));

		OcrRequest ocrRequestObject = gson.fromJson(ocrRequest, OcrRequest.class);

		log.info(gson.toJson(String.format("Request for Ocr is %s", ocrRequestObject)));
		return ResponseEntity.ok(oCRServiceImpl.getDetails(ocrRequestObject));
	}
}
