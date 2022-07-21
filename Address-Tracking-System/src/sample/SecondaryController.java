package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SecondaryController implements Initializable {

    @FXML

    public VBox leftSide;
    public VBox topmainBox2;
    public TextField adressField;
    public VBox rigthSide;





    public void getNormalScene(){

        if (topmainBox2.getChildren().size()!=0){

            topmainBox2.getChildren().remove(0);
        }


        VBox mainBox = new VBox();
        topmainBox2.getChildren().add(mainBox);


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



        Button settingBtn = new Button("Bilgileri Ayarla");
        Button deleteUSerBtn = new Button("Kullanıcı Sil");
        Button exitBtn = new Button("Çıkış Yap");



        settingBtn.setPrefWidth(200);
        settingBtn.setPrefHeight(40);
        settingBtn.getStyleClass().add("btn");

        deleteUSerBtn.setPrefWidth(200);
        deleteUSerBtn.setPrefHeight(40);
        deleteUSerBtn.getStyleClass().add("btn");

        exitBtn.setPrefWidth(200);
        exitBtn.setPrefHeight(40);
        exitBtn.getStyleClass().add("btn");


        settingBtn.setOnMouseClicked(event -> {
            System.out.println("event exe...");
            getSettingScene();
        });

        deleteUSerBtn.setOnMouseClicked(event -> {
            System.out.println("Delete user exe...");
            databaseController.deleteUser(user.currentUser.getID());
            showUser();
            getNormalScene();
        });


        exitBtn.setOnMouseClicked(event -> {
            try {
                App.setRoot("primary","login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        mainBox.getChildren().add(firstTitle);
        mainBox.getChildren().add(name);
        mainBox.getChildren().add(lastName);
        mainBox.getChildren().add(ID);
        mainBox.getChildren().add(age);
        mainBox.getChildren().add(secondTitle);


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
        mainBox.getChildren().add(deleteUSerBtn);
        mainBox.getChildren().add(exitBtn);
    }

    public void getSettingScene(){
        topmainBox2.getChildren().remove(0);


        VBox mainBox = new VBox();
        topmainBox2.getChildren().add(mainBox);

        Label firstTitle = new Label("Kullanıcı Bilgileri");
        firstTitle.getStyleClass().add("titletext");
        Label secondTitle = new Label("Adres Bilgileri");
        secondTitle.getStyleClass().add("titletext");
        TextField name = new TextField(user.currentUser.getName());
        TextField lastName = new TextField(user.currentUser.getSecondName());
        TextField password = new TextField(user.currentUser.getPassword());
        TextField age = new TextField(String.valueOf(user.currentUser.getAge()));
        TextField adressName = new TextField(user.currentUser.getAdressName());
        TextField city = new TextField(user.currentUser.getCity());
        TextField distcrit = new TextField(user.currentUser.getDistrict());
        TextField neighborhood = new TextField(user.currentUser.getNeighborhood());
        TextField streetAdress = new TextField(user.currentUser.getStreetAdress());
        Button normalSceneBtn = new Button("Kaydet");
        normalSceneBtn.getStyleClass().add("btn");

        if (user.currentUser.getAdressName()==null|| user.currentUser.getAdressName().equals("")){
            adressName.setPromptText("ADRES İSMİ");
            city.setPromptText("BÖLGE");
            distcrit.setPromptText("Distcrit");
            neighborhood.setPromptText("SEMT");
            streetAdress.setPromptText("SOKAK");
        }


        normalSceneBtn.setOnMouseClicked(event -> {

            user newuser = new user(name.getText(),lastName.getText(),Integer.parseInt(age.getText()),password.getText(),adressName.getText(),streetAdress.getText(),neighborhood.getText(),city.getText(),distcrit.getText(),true);
            newuser.setID(user.currentUser.getID());

            databaseController.changeUser(newuser);
            user.currentUser=newuser;

            getNormalScene();
            showUser();
        });

        mainBox.getChildren().add(firstTitle);
        mainBox.getChildren().add(name);
        mainBox.getChildren().add(lastName);

        mainBox.getChildren().add(password);
        mainBox.getChildren().add(age);


        mainBox.getChildren().add(secondTitle);
        mainBox.getChildren().add(adressName);
        mainBox.getChildren().add(city);
        mainBox.getChildren().add(distcrit);
        mainBox.getChildren().add(neighborhood);
        mainBox.getChildren().add(streetAdress);
        mainBox.getChildren().add(normalSceneBtn);
    }

    void showBtns(){
        while (rigthSide.getChildren().size()!=0){

            rigthSide.getChildren().remove(0);
        }
        ArrayList<user> database = databaseController.getDatabase();

        String key = adressField.getText();

        if (key!=null&&!key.equals("")&&!key.equals(" ")){
            System.out.println("exe.....:...");
            for (user currentUser :database){
                String adressText = "";
                adressText =" "+ adressText+(currentUser.getAdressName());
                adressText =" "+ adressText+(currentUser.getCity());
                adressText =" "+ adressText+(currentUser.getDistrict());
                adressText =" "+ adressText+(currentUser.getNeighborhood());
                adressText =" "+ adressText+(currentUser.getDistrict());


                if (adressText.contains(key)&&!currentUser.getAccess()){
                    Button newBtn = new Button();

                    newBtn.setPrefWidth(180);
                    newBtn.setPrefHeight(37);
                    newBtn.setOnMouseClicked(event -> {
                        String name = newBtn.getText();
                        for (user cuser :database){
                            if (cuser.getName().equals(name))
                                user.currentUser=cuser;
                        }
                        getNormalScene();
                    });
                    newBtn.setText(currentUser.getName());
                    rigthSide.getChildren().add(newBtn);

                }
            }
        }
    }

    void showUser(){
        while (leftSide.getChildren().size()!=0){

            leftSide.getChildren().remove(0);
        }

        ArrayList<user> database = databaseController.getDatabase();


        for (user user:database){
            if (!user.getAccess()){
                Button newBtn = new Button();
                newBtn.setPrefWidth(160);
                newBtn.setPrefHeight(37);

                newBtn.setOnMouseClicked(event -> {
                    String name = newBtn.getText();
                    for (user cuser :database){
                        if (cuser.getName().equals(name)) {
                            user.currentUser=cuser;
                        }
                    }
                    getNormalScene();
                });

                newBtn.setText(user.getName());
                leftSide.getChildren().add(newBtn);

            }
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        showUser();
        adressField.textProperty().addListener((observable, oldValue, newValue) -> {
            showBtns();

        });
    }
}