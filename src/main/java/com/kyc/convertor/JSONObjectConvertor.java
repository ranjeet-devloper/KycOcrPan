package com.kyc.convertor;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Converter(autoApply = true)
public class JSONObjectConvertor implements AttributeConverter<Map<String, Object>, String> {

	private static final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn(Map<String, Object> attribute) {
		try {
			return objectMapper.writeValueAsString(attribute);
		} catch (JsonProcessingException e) {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> convertToEntityAttribute(String dbData) {
		try {
			return objectMapper.readValue(dbData, Map.class);
		} catch (IOException e) {
			return Collections.emptyMap();
		}
	}

}
