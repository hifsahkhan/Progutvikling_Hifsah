package com.sample.product;

public class ProductRegisterFormatter {
    public static final String DELIMITER = ";";

    public static String formater(ProductRegister register) {
        StringBuilder sb = new StringBuilder();
        for (Product i : register.getRegister()) {
            sb
                    .append(i.getName()).append(DELIMITER)
                    .append(i.getPartNumber()).append(DELIMITER)
                    .append(i.getPrice()).append(DELIMITER)
                    .append(i.getBrandName()).append("\n");
        }
        return sb.toString().trim();
    }
}