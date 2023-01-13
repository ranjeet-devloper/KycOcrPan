package com.kyc.panservice;

import com.kyc.entity.OcrPanResponse;
import com.kyc.entity.OcrRequest;

public interface IOCRService {

	public OcrPanResponse getDetails(OcrRequest ocrRequest);

}
