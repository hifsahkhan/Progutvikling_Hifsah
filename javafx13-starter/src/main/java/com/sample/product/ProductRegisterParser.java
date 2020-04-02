package com.sample.product;

import com.sample.exceptions.InvalidFileException;

import java.util.ArrayList;


public class ProductRegisterParser {
    public static ProductRegister parse(ArrayList<String> registerLines) throws InvalidFileException {
        ProductRegister register = new ProductRegister();
        for (String line : registerLines) {
            String[] arr = line.split(ProductRegisterFormatter.DELIMITER);
            if (arr.length != 4) {
                throw new InvalidFileException("Ikke riktig antall felter!");
            }
            register.register(arr[0], arr[1], arr[2], arr[3]);
        }
        return register;
    }
}