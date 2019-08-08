package com.here.hackathon.xfactor.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
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

  @Autowired
  WebDataService webDataService;

  public void getAllWebData() {
    List<WebData> webPlaces= webDataService.getWebData();
    logger.info("No of chain adresses found: " + webPlaces.size());
  }

  public List<Place> getSearchPlace() {
    RestTemplate restTemplate = new RestTemplate();
    String latlong = "20.5937,78.9629";
    String searchQuery = "Vmart";
    
    String searchResult = restTemplate.getForObject(searchApiUrl + "?at=" + latlong + "&q=" + searchQuery
        + "&app_id=9XNDZEidH2V3NGYgqYCQ&app_code=078KbqvrokH_F9bAjFRAbw", String.class);
    System.out.println(searchResult);
    
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
    System.out.println(getSearchPlace());
  }

}
