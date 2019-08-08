package com.here.hackathon.xfactor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.here.hackathon.xfactor.bean.WebData;

@Service
public class WebDataService{

  @Value( "${chain.url}" )
  private String chainUrl;
  
	public List<WebData> getWebData() {
	  // TODO Auto-generated method stub
	  return null;
	}

}
