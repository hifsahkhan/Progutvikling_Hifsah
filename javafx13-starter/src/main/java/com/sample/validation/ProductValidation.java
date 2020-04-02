package com.sample.validation;

public class ProductValidation {
    public static boolean validateName(String name) {
        // https://regex101.com/r/STDMva/1
        //return !(name.isBlank() || name.isEmpty()) && name.matches("^([A-ZÆØÅ][a-zæøå]*[- ]?)*");
        return true;
    }

    public static boolean validateBrandName(String brandName){
        return true;
    }

    public static boolean validatePrice(String price){
        return true;
    }

    public static boolean validatePartNumber(String partNumber){
        return true;
    }


}
