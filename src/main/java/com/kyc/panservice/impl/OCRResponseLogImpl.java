package com.kyc.panservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyc.entity.OCRDataBase;
import com.kyc.panservice.IOCRResponseLog;
import com.kyc.repository.IOcrResponseRepository;

@Service
public abstract class OCRResponseLogImpl implements IOCRResponseLog {

	@Autowired
	private IOcrResponseRepository iOcrResponseRepository;

	/**
	 * this method is use for save the response return by OCR API.
	 * 
	 * @param oCRDataBase:-this is the response model which will be save.
	 */
	@Override
	public void saveResponse(OCRDataBase oCRDataBase) {

		iOcrResponseRepository.save(oCRDataBase);

	}

}
