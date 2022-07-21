package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.LightBase;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class userController implements Initializable {
    @FXML
    public Label userNameFieldd;
    public VBox topmainBox;


    public void getNormalScene(){

        topmainBox.getChildren().remove(0);



        VBox mainBox = new VBox();
        topmainBox.getChildren().add(mainBox);


        Label firstTitle = new Label("Kullanıcı Bilgileri");
        firstTitle.setAlignment(Pos.CENTER);
        firstTitle.getStyleClass().add("titletext");
        Label name = new Label("İSİM : "+ user.currentUser.getName());
        name.getStyleClass().add("userinfolabel");
        Label lastName = new Label("SOY İSİM : "+ user.currentUser.getSecondName());
        lastName.getStyleClass().add("userinfolabel");
        Label ID = new Label("ID : "+ user.currentUser.getID());
        ID.getStyleClass().add("userinfolabel");
        Label age = new Label("YAŞ : "+ user.currentUser.getAge());
        age.getStyleClass().add("userinfolabel");

        Label secondTitle = new Label("Adres Bilgileri");
        secondTitle.setAlignment(Pos.CENTER);
        secondTitle.getStyleClass().add("titletext");

        mainBox.getChildren().add(firstTitle);
        mainBox.getChildren().add(name);
        mainBox.getChildren().add(lastName);
        mainBox.getChildren().add(ID);
        mainBox.getChildren().add(age);
        mainBox.getChildren().add(secondTitle);

        Button settingBtn = new Button("Bilgileri Ayarla");
        Button exitBtn = new Button("Çıkış Yap");

        settingBtn.getStyleClass().add("btn");
        exitBtn.getStyleClass().add("btn");


        exitBtn.setPrefWidth(200);
        exitBtn.setPrefHeight(40);
        exitBtn.setCursor(Cursor.HAND);
        exitBtn.setFont(new Font(18));

        settingBtn.setPrefWidth(200);
        settingBtn.setPrefHeight(40);
        settingBtn.setCursor(Cursor.HAND);
        settingBtn.setFont(new Font(18));


        settingBtn.setOnMouseClicked(event -> {
            getSettingScene();
        });


        exitBtn.setOnMouseClicked(event -> {
            try {
                App.setRoot("primary","login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        if (!(user.currentUser.getAdressName()+user.currentUser.getCity()+user.currentUser.getNeighborhood()+user.currentUser.getDistrict()+user.currentUser.getStreetAdress()).equals("")){
            Label adressName = new Label("ADRES İSMİ : "+user.currentUser.getAdressName());
            adressName.getStyleClass().add("userinfolabel");
            Label city = new Label("ŞEHİR : "+user.currentUser.getCity());
            city.getStyleClass().add("userinfolabel");
            Label distcrit = new Label("BÖLGE : "+user.currentUser.getDistrict());
            distcrit.getStyleClass().add("userinfolabel");
            Label neighborhood = new Label("SEMT : "+user.currentUser.getNeighborhood());
            neighborhood.getStyleClass().add("userinfolabel");
            Label streetAdress = new Label("SOKAK : "+user.currentUser.getStreetAdress());
            streetAdress.setStyle("-fx-font-family: 'Times New Roman'");
            streetAdress.setStyle("-fx-font-size: 30");
            streetAdress.setStyle("-fx-font-weight: bold");
            streetAdress.setPadding(new Insets(5,5,50,5));


            adressName.setFont(new Font(17));
            city.setFont(new Font(17));
            distcrit.setFont(new Font(17));
            neighborhood.setFont(new Font(17));
            streetAdress.setFont(new Font(17));


            mainBox.getChildren().add(adressName);
            mainBox.getChildren().add(city);
            mainBox.getChildren().add(distcrit);
            mainBox.getChildren().add(neighborhood);
            mainBox.getChildren().add(streetAdress);
        }else{
            Label newlb = new Label("ADRES BİLGİLERİ KAYIT EDİLMEDİ");
            newlb.setId("noaddresslb");
            mainBox.getChildren().add(newlb);
        }



        mainBox.getChildren().add(settingBtn);
        mainBox.getChildren().add(exitBtn);
    }

    public void getSettingScene(){
        topmainBox.getChildren().remove(0);


        VBox mainBox = new VBox();
        topmainBox.getChildren().add(mainBox);

        Label firstTitle = new Label("Kullanıcı Bilgileri");
        firstTitle.setAlignment(Pos.CENTER);
        firstTitle.getStyleClass().add("titletext");
        Label secondTitle = new Label("Adres Bilgileri");
        secondTitle.setAlignment(Pos.CENTER);
        secondTitle.getStyleClass().add("titletext");
        TextField name = new TextField(user.currentUser.getName());
        name.getStyleClass().add("settextfield");
        TextField lastName = new TextField(user.currentUser.getSecondName());
        name.getStyleClass().add("settextfield");
        TextField password = new TextField(user.currentUser.getPassword());
        name.getStyleClass().add("settextfield");
        TextField age = new TextField(String.valueOf(user.currentUser.getAge()));
        name.getStyleClass().add("settextfield");
        Button normalSceneBtn = new Button("Kaydet");
        normalSceneBtn.getStyleClass().add("btn");


        mainBox.getChildren().add(firstTitle);
        mainBox.getChildren().add(name);
        mainBox.getChildren().add(lastName);
        mainBox.getChildren().add(password);
        mainBox.getChildren().add(age);


        mainBox.getChildren().add(secondTitle);

        TextField adressName = new TextField(user.currentUser.getAdressName());
        TextField city = new TextField(user.currentUser.getCity());
        TextField distcrit = new TextField(user.currentUser.getDistrict());
        TextField neighborhood = new TextField(user.currentUser.getNeighborhood());
        TextField streetAdress = new TextField(user.currentUser.getStreetAdress());

        if (user.currentUser.getAdressName()==null||user.currentUser.getAdressName().equals("")){
            adressName.setPromptText("ADRES İSMİ");
            city.setPromptText("ŞEHİR");
            distcrit.setPromptText("BÖLGE");
            neighborhood.setPromptText("SEMT");
            streetAdress.setPromptText("SOKAK");
        }

        mainBox.getChildren().add(adressName);
        mainBox.getChildren().add(city);
        mainBox.getChildren().add(distcrit);
        mainBox.getChildren().add(neighborhood);
        mainBox.getChildren().add(streetAdress);



        normalSceneBtn.setOnMouseClicked(event -> {

            user newuser = new user(name.getText(),lastName.getText(),Integer.parseInt(age.getText()),password.getText(),adressName.getText(),streetAdress.getText(),neighborhood.getText(),city.getText(),distcrit.getText(),true);
            newuser.setID(user.currentUser.getID());
            databaseController.changeUser(newuser);
            user.currentUser=newuser;

            getNormalScene();
        });

        mainBox.getChildren().add(normalSceneBtn);
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {

        topmainBox.setPadding(new Insets(5,5,5,5));


        VBox mainBox = new VBox();
        topmainBox.getChildren().add(mainBox);

        getNormalScene();




    }


}
