package com.sevenSenders.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sevenSenders.dto.CombinedDataDto;
import com.sevenSenders.service.CombinedDataService;

@RestController
@RequestMapping(value = "/combinedData")
public class CombinedDataController {

	Logger logger = LoggerFactory.getLogger(CombinedDataController.class);

	private final CombinedDataService combinedDataService;

	CombinedDataController(CombinedDataService combinedDataService) {
		this.combinedDataService = combinedDataService;
	}

	@GetMapping()
	public List<CombinedDataDto> getCombinedData() {
		return combinedDataService.getCombinedData();
	}

}
