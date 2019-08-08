package com.here.hackathon.xfactor.bean;

import java.util.ArrayList;
import java.util.List;

public class DerivedCategory {
   
  private List<String> categoryIds = new ArrayList<>();
  private String derivedLevel;
  private String highestScoredCategory;
  private int score;
  private String placeName;
  private String additionalText;
  
  public List<String> getCategoryIds() {
    return categoryIds;
  }
  
  public void setCategoryIds(List<String> categoryIds) {
    this.categoryIds = categoryIds;
  }
  
  public void addCategoryIds(String categoryId) {
    this.categoryIds = categoryIds == null ? new ArrayList<>() : categoryIds;
    categoryIds.add(categoryId);
  }
  
  public String getDerivedLevel() {
    return derivedLevel;
  }
  
  public void setDerivedLevel(String derivedLevel) {
    this.derivedLevel = derivedLevel;
  }
  
  public String getHighestScoredCategory() {
    return highestScoredCategory;
  }
  
  public void setHighestScoredCategory(String highestScoredCategory) {
    this.highestScoredCategory = highestScoredCategory;
  }
  
  public int getScore() {
    return score;
  }
  
  public void setScore(int score) {
    this.score = score;
  }
  
  public String getPlaceName() {
    return placeName;
  }
  
  public void setPlaceName(String placeName) {
    this.placeName = placeName;
  }
  
  public String getAdditionalText() {
    return additionalText;
  }
  
  public void setAdditionalText(String additionalText) {
    this.additionalText = additionalText;
  }
}
