package com.sample.product;

import com.sample.exceptions.InvalidBrandNameException;
import com.sample.exceptions.InvalidNameException;
import com.sample.exceptions.InvalidPartNumberException;
import com.sample.exceptions.InvalidPriceException;
import com.sample.validation.ProductValidation;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.*;

public class Product implements Serializable {
    private transient SimpleStringProperty price;
    private transient SimpleStringProperty brandName;
    private transient SimpleStringProperty name;
    private transient SimpleStringProperty partNumber;

    public Product(String name, String partNumber, String price, String brandName){

        if (!ProductValidation.validateName(name)) throw new InvalidNameException("Feil navn");
        if (!ProductValidation.validatePartNumber(partNumber)) throw new InvalidPartNumberException("Feil varenummer");
        if (!ProductValidation.validatePrice(price)) throw new InvalidPriceException("Feil pris");
        if (!ProductValidation.validateBrandName(brandName)) throw new InvalidBrandNameException("Feil varemerke");


        this.name = new SimpleStringProperty(name);
        this.partNumber = new SimpleStringProperty(partNumber);
        this.price = new SimpleStringProperty(price);
        this.brandName = new SimpleStringProperty(brandName);
    }

    public void setName(String name) throws InvalidNameException{
        if (!ProductValidation.validateName(name)) throw new InvalidNameException("Feil navn");
        this.name.set(name);
    }

    public String getName() {
        return name.getValue();
    }

    public void setPartNumber(String partNumber) throws InvalidPartNumberException{
        if (!ProductValidation.validatePartNumber(partNumber)) throw new InvalidPartNumberException("Feil varenummer");
        this.partNumber.set(partNumber);
    }

    public String getPartNumber() {
        return partNumber.getValue();
    }

    public void setPrice(String price) throws InvalidPriceException{
        if (!ProductValidation.validatePrice(price)) throw new InvalidPriceException("Feil pris");
        this.price.set(price);
    }

    public String getPrice() {
        return price.getValue();
    }

    public void setBrandName(String brandName) throws InvalidBrandNameException{
        if (!ProductValidation.validateBrandName(brandName)) throw new InvalidBrandNameException("Feil varemerke");
        this.brandName.set(brandName);
    }

    public String getBrandName() {
        return brandName.getValue();
    }

    public String toString(){
        return getName() +", "+getPartNumber()+", "+getPrice()+", "+getBrandName()+"\n";
    }


    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeUTF(getName());
        oos.writeUTF(getPartNumber());
        oos.writeUTF(getPrice());
        oos.writeUTF(getBrandName());
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException{
        String name = ois.readUTF();
        String partNumber = ois.readUTF();
        String price = ois.readUTF();
        String brandName = ois.readUTF();

        this.name = new SimpleStringProperty(name);
        this.partNumber = new SimpleStringProperty(partNumber);
        this.price = new SimpleStringProperty(price);
        this.brandName = new SimpleStringProperty(brandName);
    }
}

