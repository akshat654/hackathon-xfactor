package com.here.hackathon.xfactor.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WebData {
  
  private String name;
  private String address;
  private String contactUrl;
  private String contactNumber;
  private String description;
  private Double latitude;
  private Double longitude;
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public String getContactUrl() {
    return contactUrl;
  }
  public void setContactUrl(String contactUrl) {
    this.contactUrl = contactUrl;
  }
  public String getContactNumber() {
    return contactNumber;
  }
  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public Double getLatitude() {
    return latitude;
  }
  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }
  public Double getLongitude() {
    return longitude;
  }
  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

}
