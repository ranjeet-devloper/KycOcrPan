package com.kyc.entity;

import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.kyc.convertor.JSONObjectConvertor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class OCRDataBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String poa;

	@Column(nullable = false)
	private String poi;
	@Column(nullable = false)
	private String approved;
	@Column(name = "OCR_Response", columnDefinition = "json")
	@Convert(attributeName = "attribute", converter = JSONObjectConvertor.class)
	private Map<String, OcrPanResponse> response;

}
