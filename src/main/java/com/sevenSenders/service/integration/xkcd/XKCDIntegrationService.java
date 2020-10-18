package com.sevenSenders.service.integration.xkcd;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sevenSenders.constants.ConstantUtilities;
import com.sevenSenders.dto.integration.xkcd.XKCDComicDto;

@Service
public class XKCDIntegrationService {

	private final RestTemplate restTemplate;

	public XKCDIntegrationService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public XKCDComicDto getCurrentComic() {
		String requestUri = ConstantUtilities.XKCD_URL;
		ResponseEntity<XKCDComicDto> entity = restTemplate.getForEntity(requestUri, XKCDComicDto.class);
		return entity.getBody();
	}

	public XKCDComicDto getComic(String comicNUmber) {
		String requestUri =  ConstantUtilities.DYNAMIC_XKCD_URL + comicNUmber +  ConstantUtilities.DYNAMIC_XKCD_INFO_URL;
		ResponseEntity<XKCDComicDto> entity = restTemplate.getForEntity(requestUri, XKCDComicDto.class);
		return entity.getBody();
	}

	public List<XKCDComicDto> getLatestTenComics() {
		List<XKCDComicDto> XKCDComicDtos = new ArrayList<XKCDComicDto>();
		XKCDComicDto xKCDComicDto = getCurrentComic();
		if (xKCDComicDto != null) {
			XKCDComicDtos.add(xKCDComicDto);
			for (int i = 1; i <= 9; i++) {
				xKCDComicDto = getNextComic(xKCDComicDto);
				XKCDComicDtos.add(xKCDComicDto);
			}
		}
		return XKCDComicDtos;
	}

	XKCDComicDto getNextComic(XKCDComicDto xKCDComicDto) {

		if (xKCDComicDto != null && xKCDComicDto.getNum() != null) {
			Integer nextComincNumber = xKCDComicDto.getNum() - 1;
			return getComic(nextComincNumber.toString());
		}
		return null;
	}
}
