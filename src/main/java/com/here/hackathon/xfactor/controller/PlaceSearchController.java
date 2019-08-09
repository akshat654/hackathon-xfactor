package com.here.hackathon.xfactor.controller;

import java.util.*;

import com.jayway.jsonpath.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.here.hackathon.xfactor.bean.DerivedCategory;
import com.here.hackathon.xfactor.bean.Place;
import com.here.hackathon.xfactor.bean.WebData;
import com.here.hackathon.xfactor.service.WebDataService;

@Controller
public class PlaceSearchController implements CommandLineRunner {
  
  Logger logger = LoggerFactory.getLogger(PlaceSearchController.class);
  
  @Value( "${api.categoryDerivation.url}" )
  private String categoryDerivationUrl;
  
  @Value( "${api.search.url}" )
  private String searchApiUrl;

  @Value( "${app.credentials}" )
  private String appCred;

  @Autowired
  WebDataService webDataService;

  public void getAllWebData(WebData webData) {
    List<WebData> webPlaces= webDataService.getWebData();
    logger.info("No of chain adresses found: " + webPlaces.size());
  }

  public List<Place> getSearchPlace(WebData webData) {
    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    headers.setAcceptLanguage(Locale.LanguageRange.parse("en,en-us"));

    HttpEntity<String> entity = new HttpEntity<>("body", headers);

    String searchResult = restTemplate.getForObject(searchApiUrl + "?at=" + webData.getLatitude()+","+webData.getLongitude() + "&q=" + webData.getAddress()
        + appCred, String.class,entity);

    List<String> href= JsonPath.read(searchResult, "$.results.items[?(@.type==\"urn:nlp-types:place\")].href");
    System.out.println(href.size());

    for(String url:href){
      String res = restTemplate.getForObject(url,String.class);
      System.out.println(res);
    }
    return null;
  }

  public void getCategoryDerivation() {
    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

    DerivedCategory input = new DerivedCategory();
    input.setPlaceName("Vmart");
    input.setAdditionalText("");

    ResponseEntity result = restTemplate.postForEntity(categoryDerivationUrl, input, String.class);

    System.out.println(result);
  }

  @Override
  public void run(String... args) throws Exception {
    WebData web =new WebData();
    web.setLatitude(22.3094801);
    web.setLongitude(73.17891);
    web.setAddress("v-mart");
    System.out.println(getSearchPlace(web));

  }

  public static void main(String[] args) {
    List<Locale.LanguageRange> list=Locale.LanguageRange.parse("en,en-us");
    System.exit(1);
  }
}
