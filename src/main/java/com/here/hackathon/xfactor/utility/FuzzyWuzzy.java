package com.here.hackathon.xfactor.utility;


import me.xdrop.fuzzywuzzy.FuzzySearch;
import me.xdrop.fuzzywuzzy.algorithms.WeightedRatio;
import me.xdrop.fuzzywuzzy.model.ExtractedResult;

import java.util.ArrayList;
import java.util.List;

public class FuzzyWuzzy {
	
	public static int compareAddresses(String crawlAddress, String searchAddress) {
		int tokenSetRatio = FuzzySearch.tokenSetRatio(crawlAddress,searchAddress);
		return tokenSetRatio;
	}
	
	public static void main(String[] args) {
		String cwlAd = "Hotel Sudarshan Palace, RC Datta Rd Alka Puri Vadodara - 390007";
		String srchAd = "R C Dutt Road Vadodara 390007 India";
		System.out.println("Address Compare Result:"+compareAddresses(cwlAd,srchAd));
	}
}
