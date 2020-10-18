package com.sevenSenders.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sevenSenders.dto.CombinedDataDto;
import com.sevenSenders.service.integration.xkcd.XKCDIntegrationService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CombinedDataServiceTest {
	
	
	private CombinedDataService combinedDataService;
	
	@Autowired
	private  XKCDIntegrationService xKCDIntegrationService;


	@BeforeEach
	public void setup() {
		combinedDataService = new CombinedDataService(xKCDIntegrationService);
	}

	
	@Test
	public void getCombinedData_ReturnListCombinedDataDto() {

		List<CombinedDataDto> combinedDataDtos  = combinedDataService.getCombinedData();
		assertNotNull(combinedDataDtos);

	}
	


}
