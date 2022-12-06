package com.example.demo;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import static org.junit.jupiter.api.Assertions.assertEquals; 


public class ExportLocationDTOTest {
	private Validator validator; 
	
	private ExportLocationDTO dto; 
	
	@BeforeEach
	public void  setUp() throws Exception {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory(); 
		validator = validatorFactory.getValidator(); 
		
		dto = ExportLocationDTO.builder()
				.name("validName")
				.build(); 
	}
	
	@Test
	public void itShouldFailMissingEmailAddressField() {
		dto.setLocationOption(ExportLocationOption.EMAIL);
		Set<ConstraintViolation<ExportLocationDTO>> violations = validator.validate(dto); 
		assertEquals(1, violations.size()); 
		
	}
	
	@Test
	public void itShouldFailOnMissingFTPCredentials() {
		dto.setLocationOption(ExportLocationOption.FTP);
		Set<ConstraintViolation<ExportLocationDTO>> violations = validator.validate(dto); 
		assertEquals(4, violations.size()); 
	}
	
	@Test 
	public void itShouldFailOnMissingSFTPCredentials() {
		dto.setLocationOption(ExportLocationOption.SFTP);
		Set<ConstraintViolation<ExportLocationDTO>> violations = validator.validate(dto); 
		assertEquals(4, violations.size()); 
	}

}
