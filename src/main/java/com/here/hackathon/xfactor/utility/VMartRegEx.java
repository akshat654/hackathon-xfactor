package com.here.hackathon.xfactor.utility;

import com.here.hackathon.xfactor.bean.PlaceDetails;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VMartRegEx {

    public static void getAddressDataWithPostalCode(String text, PlaceDetails placeDetails)
    {

        String text1 = "V-Mart      Hotel Sudarshan Palace, RC Datta Rd Alka Puri Vadodara  -  390007    +919327916340            Closed for the day   WEEKLY OFF              Departmental Store";
        // Specifies the string pattern which is to be searched
        String delimiter =  "\\d{6}";
        Pattern pattern = Pattern.compile(delimiter,
                Pattern.CASE_INSENSITIVE);
        String pincode = "";
        Matcher matcher = pattern.matcher(text1);
        if (matcher.find()) {
            //System.out.println(matcher.group(0));
            //placeDetails.setContact(matcher.group(0));
            pincode = matcher.group(0);
        }

        // Used to perform case insensitive search of the string
        String[] result = pattern.split(text1);
        //"      "
        /*for (String temp: result) {
            System.out.println(temp);
        }*/
        String address = result[0].split("V-Mart")[1];
        System.out.println(address+pincode);
        /*for (String temp: result1) {
            System.out.println("temp "+temp.trim());
        }*/
    }




    public static void getPhoneNumber(String text, PlaceDetails placeDetails)
    {

        String text1 = "V-Mart      Hotel Sudarshan Palace, RC Datta Rd Alka Puri Vadodara  -  390007    +919327916340            Closed for the day   WEEKLY OFF              Departmental Store";
        // Specifies the string pattern which is to be searched
        String delimiter =  "((\\+*)((0[ -]+)*|(91 )*)(\\d{12}+|\\d{10}+))|\\d{5}([- ]*)\\d{6}";
        Pattern pattern = Pattern.compile(delimiter,
                Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(text1);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
            placeDetails.setContact(matcher.group(0));
        }
    }


    public PlaceDetails getPlaceDetails(String text)
    {
        PlaceDetails placeDetails =  new PlaceDetails();
        getAddressDataWithPostalCode(text,placeDetails);
        getPhoneNumber(text,placeDetails);
        return placeDetails;
    }

    public static void main(String[] args) {

        //getPhoneNumber("",new PlaceDetails());
        getAddressDataWithPostalCode("",null);
    }
}
