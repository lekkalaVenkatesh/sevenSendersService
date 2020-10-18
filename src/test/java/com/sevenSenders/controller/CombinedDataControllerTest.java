package com.sevenSenders.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sevenSenders.dto.CombinedDataDto;
import com.sevenSenders.service.CombinedDataService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = CombinedDataController.class)
public class CombinedDataControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CombinedDataService combinedDataService;

	@Test
	public void getCombinedData_valid() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/combinedData")).andExpect(status().isOk());

	}

	@Test
	public void getCombinedData_mock_valid() throws Exception {

		when(combinedDataService.getCombinedData()).thenReturn(getCombinedData());

		mockMvc.perform(MockMvcRequestBuilders.get("/combinedData")).andExpect(status().isOk());

	}

	static List<CombinedDataDto> getCombinedData() {

		List<CombinedDataDto> combinedDataDtos = new ArrayList<CombinedDataDto>();

		return combinedDataDtos;
	}

}
