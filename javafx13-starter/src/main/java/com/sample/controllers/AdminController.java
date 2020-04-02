package com.sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sample.App;
import com.sample.exceptions.InvalidNameException;
import com.sample.files.FileOpener;
import com.sample.files.FileSaver;
import com.sample.product.Product;
import com.sample.product.ProductRegister;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LocalDateStringConverter;

public class AdminController implements Initializable{

    private FileChooser fileChooser = new FileChooser();
    private ProductRegister register = new ProductRegister();
    private FileOpener opener;
    private FileSaver saver;

    @FXML
    private Button secondaryButton;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPartNumber;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtBrand;



    @FXML
    private TextField txtFilter;

    @FXML
    private ChoiceBox<?> selectFilter;

    @FXML
    TableColumn<Product, String> intAlderColumn, intMobilColumn, intFødtdatoColumn;

    private ProductRegister pRegister = new ProductRegister();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pRegister.attachTableView(productTableView);

    }

    ObservableList<Product> liste = FXCollections.observableArrayList();

    @FXML
    private TableView<Product> productTableView;


    @FXML
    void btnFiltrer(ActionEvent event) {

    }

    @FXML
    void btnRegisterProduct() {
        try{
            register.register(txtName.getText(), txtPartNumber.getText(), txtPrice.getText(), txtBrand.getText());
            nullStill();
            System.out.println("TEST::: PRODUKT " + register.showProduct());
        } catch (Exception e){
            showErrorMessage(e);
        }
        Product product = new Product("Skjerm","12345","600","Windows");
        liste.add(product);
    }

    public void nullStill(){
        txtName.setText("");
        txtPartNumber.setText("");
        txtPrice.setText("");
        txtBrand.setText("");
    }

    public void showErrorMessage(Throwable e){
        showErrorMessage(e.getMessage());
    }

    public void showErrorMessage(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Feil!");
        alert.setHeaderText("Ugyldig data!");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @FXML
    void btnChangeToMainView(ActionEvent event) throws IOException{
        App.changeView("mainview.fxml");
    }

    public AdminController() {
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Tekstfiler", "*.txt"),
                new FileChooser.ExtensionFilter("JOBJ-filer", "*.jobj")
        );
    }


    @FXML
    void onCommitName(TableColumn.CellEditEvent<Product, String> event) {
        try {
            event.getRowValue().setName(event.getNewValue());
        } catch (InvalidNameException e) {
            showErrorMessage(e);
        }
        productTableView.refresh();
    }







}