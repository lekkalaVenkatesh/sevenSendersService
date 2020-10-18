package com.sevenSenders.service.integration.xkcd;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sevenSenders.constants.ConstantUtilities;
import com.sevenSenders.dto.integration.xkcd.XKCDComicDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application.test.properties")
public class XKCDIntegrationServiceTest {

	String requestUri = ConstantUtilities.XKCD_URL;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private XKCDIntegrationService xKCDIntegrationService;

	@Test
	public void testValidGetCurrentComic() throws Exception {

		ResponseEntity<XKCDComicDto> response = restTemplate.getForEntity(requestUri, XKCDComicDto.class);
		Assertions.assertNotNull(response.getBody().getNum());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

	}

	@Test
	public void testInValidGetComic() throws Exception {

		List<XKCDComicDto> listComicDtos = xKCDIntegrationService.getLatestTenComics();
		Assertions.assertEquals(10, listComicDtos.size());
	}

}
