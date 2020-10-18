
package com.sevenSenders.dto.integration.xkcd;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "month",
    "num",
    "link",
    "year",
    "news",
    "safe_title",
    "transcript",
    "alt",
    "img",
    "title",
    "day"
})
public class XKCDComicDto {

    @JsonProperty("month")
    private String month;
    @JsonProperty("num")
    private Integer num;
    @JsonProperty("link")
    private String link;
    @JsonProperty("year")
    private String year;
    @JsonProperty("news")
    private String news;
    @JsonProperty("safe_title")
    private String safeTitle;
    @JsonProperty("transcript")
    private String transcript;
    @JsonProperty("alt")
    private String alt;
    @JsonProperty("img")
    private String img;
    @JsonProperty("title")
    private String title;
    @JsonProperty("day")
    private String day;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public XKCDComicDto() {
    }

    /**
     * 
     * @param news
     * @param img
     * @param transcript
     * @param month
     * @param year
     * @param num
     * @param link
     * @param alt
     * @param title
     * @param safeTitle
     * @param day
     */
    public XKCDComicDto(String month, Integer num, String link, String year, String news, String safeTitle, String transcript, String alt, String img, String title, String day) {
        super();
        this.month = month;
        this.num = num;
        this.link = link;
        this.year = year;
        this.news = news;
        this.safeTitle = safeTitle;
        this.transcript = transcript;
        this.alt = alt;
        this.img = img;
        this.title = title;
        this.day = day;
    }

    @JsonProperty("month")
    public String getMonth() {
        return month;
    }

    @JsonProperty("month")
    public void setMonth(String month) {
        this.month = month;
    }

    @JsonProperty("num")
    public Integer getNum() {
        return num;
    }

    @JsonProperty("num")
    public void setNum(Integer num) {
        this.num = num;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("year")
    public String getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(String year) {
        this.year = year;
    }

    @JsonProperty("news")
    public String getNews() {
        return news;
    }

    @JsonProperty("news")
    public void setNews(String news) {
        this.news = news;
    }

    @JsonProperty("safe_title")
    public String getSafeTitle() {
        return safeTitle;
    }

    @JsonProperty("safe_title")
    public void setSafeTitle(String safeTitle) {
        this.safeTitle = safeTitle;
    }

    @JsonProperty("transcript")
    public String getTranscript() {
        return transcript;
    }

    @JsonProperty("transcript")
    public void setTranscript(String transcript) {
        this.transcript = transcript;
    }

    @JsonProperty("alt")
    public String getAlt() {
        return alt;
    }

    @JsonProperty("alt")
    public void setAlt(String alt) {
        this.alt = alt;
    }

    @JsonProperty("img")
    public String getImg() {
        return img;
    }

    @JsonProperty("img")
    public void setImg(String img) {
        this.img = img;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("day")
    public String getDay() {
        return day;
    }

    @JsonProperty("day")
    public void setDay(String day) {
        this.day = day;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


}
