package com.here.hackathon.xfactor.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.here.hackathon.xfactor.bean.DerivedCategory;
import com.here.hackathon.xfactor.service.WebDataService;

@Controller
public class PlaceSearchController implements CommandLineRunner {

  @Autowired
  WebDataService webDataService;

  public void getAllWebData() {
    webDataService.getWebData();
  }

  public String getSearchPlace() {
    RestTemplate restTemplate = new RestTemplate();
    String searchResult = restTemplate.getForObject("https://places.cit.api.here.com/places/v1/discover/search?"
        + "at=20.5937,78.9629&q=Vmart&app_id=9XNDZEidH2V3NGYgqYCQ&app_code=078KbqvrokH_F9bAjFRAbw", String.class);
    return searchResult;
  }

  public void getCategoryDerivation() {
    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

    DerivedCategory input = new DerivedCategory();
    input.setPlaceName("Vmart");
    input.setAdditionalText("");

    ResponseEntity result = restTemplate.postForEntity("http://10.127.166.116/getPrediction", input, String.class);

    System.out.println(result);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println(getSearchPlace());
  }

}
