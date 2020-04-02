package com.sample.product;

import com.sample.exceptions.InvalidPriceException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ProductRegister implements Serializable {

    private transient ObservableList<Product> register;
    private transient ObservableList<Product> filterRegister;
    private transient boolean filtered = false;

    public void attachTableView(TableView <Product> tv){
        tv.setItems(getRegister());
    }

    public ProductRegister(){
        this.register = FXCollections.observableArrayList();
    }

    public void register(String name, String partNumber, String price, String brandName){
        try {
            register.add(new Product(name, partNumber, price, brandName));
        } catch (NumberFormatException e){
            throw new InvalidPriceException("Pris må kun inneholde heltall");
        }
    }

    public String showProduct(){
        String out = "";
        for (Product i : register){
            out += i.getName() + ", " + i.getPartNumber() + ", " + i.getPrice() + ", " + i.getBrandName() + "\n";
        }
        return out;
    }

    public ObservableList<Product> getRegister(){
        if (filtered){
            return filterRegister;
        }
        return register;
    }

    public void removeFilter(){
        filtered = false;
    }

    public void setFiltered (String filter, String felt){
        switch (felt) {
            case "Varenavn":
                filterRegister = register.stream().filter(product -> product.getName().toLowerCase().matches(".*" + Pattern.quote(filter.toLowerCase()) + ".*")).
                        collect(Collectors.toCollection(FXCollections::observableArrayList));
                break;
            case "Varenummer":
                filterRegister = register.stream().filter(product -> product.getPartNumber().toLowerCase().matches(".*" + Pattern.quote(filter.toLowerCase()) + ".*")).
                        collect(Collectors.toCollection(FXCollections::observableArrayList));
                break;
            case "Merke":
                filterRegister = register.stream().filter(product -> product.getBrandName().toLowerCase().matches(".*" + Pattern.quote(filter.toLowerCase()) + ".*")).
                        collect(Collectors.toCollection(FXCollections::observableArrayList));
                break;
            default:
                removeFilter();
                return;
        }
            filtered = true;
        }

    private void writeObject(ObjectOutputStream os) throws IOException {
        os.defaultWriteObject();
        os.writeObject(new ArrayList<>(register));
    }

    private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
        List<Product> list = (List<Product>) is.readObject();
        register = FXCollections.observableArrayList();
        register.addAll(list);
    }

}



