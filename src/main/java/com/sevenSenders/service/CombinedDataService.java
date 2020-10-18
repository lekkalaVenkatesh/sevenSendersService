package com.sevenSenders.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sevenSenders.dto.CombinedDataDto;
import com.sevenSenders.dto.integration.xkcd.XKCDComicDto;
import com.sevenSenders.service.integration.xkcd.XKCDIntegrationService;

@Service
public class CombinedDataService {

	Logger logger = LoggerFactory.getLogger(CombinedDataService.class);

	private final XKCDIntegrationService xKCDIntegrationService;

	CombinedDataService(XKCDIntegrationService xKCDIntegrationService) {
		this.xKCDIntegrationService = xKCDIntegrationService;
	}

	public List<CombinedDataDto> getCombinedData() {

		List<CombinedDataDto> comicDtos = getXKCDData();

		// Sorting based upon the requirement 
		sortDataBasedOndate(comicDtos);

		return comicDtos;

	}

	void sortDataBasedOndate(List<CombinedDataDto> comicDtos) {

		comicDtos.sort(Comparator.comparing(CombinedDataDto::getPublishingDate));

	}

	List<CombinedDataDto> getXKCDData() {
		List<XKCDComicDto> comicDtos = xKCDIntegrationService.getLatestTenComics();
		return getMappedData(comicDtos);

	}

	List<CombinedDataDto> getMappedData(List<XKCDComicDto> comicDtos) {
		List<CombinedDataDto> combinedDataDtos = new ArrayList<CombinedDataDto>();
		for (XKCDComicDto xKCDComicDto : comicDtos) {
			CombinedDataDto combinedDataDto = new CombinedDataDto();
			combinedDataDto.setPictureUrl(xKCDComicDto.getImg());
			combinedDataDto.setTitle(xKCDComicDto.getTitle());
			combinedDataDto.setWebUrl(xKCDComicDto.getLink());
			String publishingDate = xKCDComicDto.getDay() + "." + xKCDComicDto.getMonth() + "."
					+ xKCDComicDto.getYear();
			combinedDataDto.setPublishingDate(getDate(publishingDate));
			combinedDataDtos.add(combinedDataDto);
		}
		return combinedDataDtos;
	}

	Date getDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		try {
			return formatter.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
		return null;
	}

}
