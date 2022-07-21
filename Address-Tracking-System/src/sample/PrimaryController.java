package sample;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.StageStyle;

public class PrimaryController implements Initializable {

    @FXML
    public TextField userSignInID;
    public PasswordField userSıgnInPassword;
    public TextField adminSignInID;
    public PasswordField adminSıgnInPassword;

    public VBox rigthSide;
    public VBox leftSide;

    public boolean adminsignupstate = false;
    public boolean usersignupstate = false;
    public Button copyhelp;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BackgroundImage img = new BackgroundImage(new Image("sample/bg3.jpg"), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Paint paint = new ImagePattern(img.getImage());
        Background bg = new Background(new BackgroundFill(paint,null,null));
        leftSide.setBackground(bg);
        rigthSide.setBackground(bg);


    }

    @FXML
    private void userChangePasswords(){
        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setHeaderText("ID Girin");
        textInputDialog.setTitle("Şifre Değiştirme");



        TextInputDialog textInputDialog2 = new TextInputDialog();
        textInputDialog2.setHeaderText("Yeni şifre Girin");
        textInputDialog2.setTitle("Şifre Değiştirme");

        Optional<String> result =textInputDialog.showAndWait();


        if (result.isPresent()){
            String ID = textInputDialog.getEditor().getText();
            if (databaseController.isexist(ID)){
                Optional<String> result2 = textInputDialog2.showAndWait();
                if (result2.isPresent()){
                    String password = textInputDialog2.getEditor().getText();
                    databaseController.cbhangePassword(ID,password);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.initStyle(StageStyle.UTILITY);
                    alert.setHeaderText(null);
                    alert.setContentText("Şifre Değiştirildi");
                    alert.showAndWait();
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.initStyle(StageStyle.UTILITY);
                    alert.setHeaderText(null);
                    alert.setContentText("Şifre Değiştirilmedi");
                    alert.showAndWait();
                }
            }
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("HATA");
                alert.setHeaderText(null);
                alert.setContentText(textInputDialog.getEditor().getText()+" ID numarasına ait bir kullanıcı sisteme kayıtlı değil.");
                alert.showAndWait();

            }
        }






    }

    @FXML
    private void adminChangeUser(){
        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setHeaderText("ID Girin");
        textInputDialog.setTitle("Şifre Değiştirme");



        TextInputDialog textInputDialog2 = new TextInputDialog();
        textInputDialog2.setHeaderText("Yeni şifre Girin");
        textInputDialog2.setTitle("Şifre Değiştirme");

        Optional<String> result =textInputDialog.showAndWait();


        if (result.isPresent()){
            String ID = textInputDialog.getEditor().getText();
            if (databaseController.isexist(ID)){
                Optional<String> result2 = textInputDialog2.showAndWait();
                if (result2.isPresent()){
                    String password = textInputDialog2.getEditor().getText();
                    databaseController.cbhangePassword(ID,password);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.initStyle(StageStyle.UTILITY);
                    alert.setHeaderText(null);
                    alert.setContentText("Şifre Değiştirildi");
                    alert.showAndWait();
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.initStyle(StageStyle.UTILITY);
                    alert.setHeaderText(null);
                    alert.setContentText("Şifre Değiştirilmedi");
                    alert.showAndWait();
                }
            }
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("HATA");
                alert.setHeaderText(null);
                alert.setContentText(textInputDialog.getEditor().getText()+" ID numarasına ait bir kullanıcı sisteme kayıtlı değil.");
                alert.showAndWait();

            }
        }
    }


    @FXML
    private void signIn() throws IOException {
        if (userSignInID.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("HATA");
            alert.setHeaderText(null);
            alert.setContentText("ID numara alanı boş");
            alert.showAndWait();
        }
        else if (userSıgnInPassword.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("HATA");
            alert.setHeaderText(null);
            alert.setContentText("Şifre alanı boş");
            alert.showAndWait();
        }
        else {

            String state = signInsignUp.signIn(userSignInID.getText(),userSıgnInPassword.getText());
            if (state.equals("devam")){
                App.setRoot("user","user");

            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("HATA");
                alert.setHeaderText(null);
                alert.setContentText(state);
                alert.showAndWait();
            }
        }
    }


    @FXML
    private void userOpensignUp(){
        if (!usersignupstate){
            usersignupstate=true;
            VBox vBox = new VBox();

            Label lb = new Label("Kaydol");
            lb.getStyleClass().add("signUpLabel");
            TextField userSignUpName = new TextField();
            TextField userSignUpLastName = new TextField();
            TextField userSignUpAge = new TextField();
            PasswordField userSignUpPassword = new PasswordField();
            PasswordField userSignUpPassword2 = new PasswordField();
            Button userSignUpBtn = new Button("Kaydol");
            userSignUpBtn.getStyleClass().add("btn");


            userSignUpName.setPromptText("İsim");
            userSignUpLastName.setPromptText("Soy İsim");
            userSignUpAge.setPromptText("Yaş");

            userSignUpBtn.setOnMouseClicked(event -> {
                if (leftSide.getChildren().size()==10){
                    leftSide.getChildren().remove(8);
                    leftSide.getChildren().remove(8);
                }
                boolean errorState = false;
                for (Node node :vBox.getChildren()){
                    if (node instanceof TextField){
                        if (((TextField) node).getText().equals("")){
                            errorState=true;
                        }
                    }
                    if (node instanceof PasswordField){
                        if (((PasswordField) node).getText().equals("")){
                            errorState=true;
                        }
                    }
                }
                if (errorState){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.initStyle(StageStyle.UTILITY);
                    alert.setTitle("HATA");
                    alert.setHeaderText(null);
                    alert.setContentText("Kayıt bilgilerini eksiksiz doldurun.");
                    alert.showAndWait();
                }
                else {

                    if (!userSignUpPassword.getText().equals(userSignUpPassword2.getText())){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.initStyle(StageStyle.UTILITY);
                        alert.setTitle("HATA");
                        alert.setHeaderText(null);
                        alert.setContentText("Şifreler Farklı");
                        alert.showAndWait();
                    }
                    else {
                        user newUser = new user(userSignUpName.getText(),userSignUpLastName.getText(),Integer.parseInt(userSignUpAge.getText()),userSignUpPassword.getText(),"","","","","",false);
                        signInsignUp.signUp(newUser);

                        userSignUpName.setText("");
                        userSignUpLastName.setText("");
                        userSignUpAge.setText("");
                        userSignUpPassword.setText("");
                        userSignUpPassword2.setText("");


                        Label userID = new Label();
                        userID.setText("ID numaranızı kesinlikle saklayınız: "+databaseController.getDatabase().get(databaseController.getDatabase().size()-1).getID());
                        userID.getStyleClass().add("textsaveID");
                        Button btn = new Button("ID kopyala");
                        btn.getStyleClass().add("btn");
                        btn.setOnMouseClicked(event2 -> {

                            ClipboardContent content = new ClipboardContent();
                            content.putString(databaseController.getDatabase().get(databaseController.getDatabase().size()-1).getID());
                            Clipboard.getSystemClipboard().setContent(content);

                        });
                        leftSide.getChildren().add(userID);
                        leftSide.getChildren().add(btn);
                    }

                }

            });

            vBox.getChildren().add(lb);
            vBox.getChildren().add(userSignUpName);
            vBox.getChildren().add(userSignUpLastName);
            vBox.getChildren().add(userSignUpAge);
            vBox.getChildren().add(userSignUpPassword);
            vBox.getChildren().add(userSignUpPassword2);
            vBox.getChildren().add(userSignUpBtn);

            leftSide.getChildren().add(vBox);
            userSignUpPassword.setPromptText("Şifre");
            userSignUpPassword2.setPromptText("Şifre Yeniden");

        }
        else {

            int size = leftSide.getChildren().size();

            for (int i = 7 ; i<size;i++)
                leftSide.getChildren().remove(7);

            usersignupstate=false;

        }

    }

    @FXML
    private void adminsignIn() throws IOException {
        if (adminSignInID.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("HATA");
            alert.setHeaderText(null);
            alert.setContentText("ID numara alanı boş");
            alert.showAndWait();
        }
        else if (adminSıgnInPassword.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("HATA");
            alert.setHeaderText(null);
            alert.setContentText("Şifre alanı boş");
            alert.showAndWait();
        }
        else {

            String state = signInsignUp.signIn(adminSignInID.getText(),adminSıgnInPassword.getText());
            if (state.equals("devam")){
                App.setRoot("secondary","admin");

            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("HATA");
                alert.setHeaderText(null);
                alert.setContentText(state);
                alert.showAndWait();
            }
        }
    }



    @FXML
    private void adminOpensignUp(){

        if(!adminsignupstate){
            adminsignupstate=true;
            VBox vBox = new VBox();
            Label lb = new Label("Kaydol");
            lb.getStyleClass().add("signUpLabel");
            TextField adminSignUpName = new TextField();
            TextField adminSignUpLastName = new TextField();
            TextField adminSignUpAge = new TextField();
            PasswordField adminSignUpPassword = new PasswordField();
            PasswordField adminSignUpPassword2 = new PasswordField();
            Button adminSignUpBtn = new Button("Kaydol");
            adminSignUpBtn.getStyleClass().add("btn");

            adminSignUpName.setPromptText("İsim");
            adminSignUpLastName.setPromptText("Soy İsim");
            adminSignUpAge.setPromptText("Yaş");
            adminSignUpPassword.setPromptText("Şifre");
            adminSignUpPassword2.setPromptText("Şifre Yeniden");

            adminSignUpBtn.setOnMouseClicked(event -> {
                if (rigthSide.getChildren().size()==10){
                    rigthSide.getChildren().remove(8);
                    rigthSide.getChildren().remove(8);
                }
                boolean errorState = false;
                for (Node node :vBox.getChildren()){
                    if (node instanceof TextField){
                        if (((TextField) node).getText().equals("")){
                            errorState=true;
                        }
                    }
                    if (node instanceof PasswordField){
                        if (((PasswordField) node).getText().equals("")){
                            errorState=true;
                        }
                    }
                }
                if (errorState){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.initStyle(StageStyle.UTILITY);
                    alert.setTitle("HATA");
                    alert.setHeaderText(null);
                    alert.setContentText("Kayıt bilgilerini eksiksiz doldurun.");
                    alert.showAndWait();
                }
                else {

                    if (!adminSignUpPassword.getText().equals(adminSignUpPassword2.getText())){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.initStyle(StageStyle.UTILITY);
                        alert.setTitle("HATA");
                        alert.setHeaderText(null);
                        alert.setContentText("Şifreler Farklı");
                        alert.showAndWait();
                    }
                    else {
                        user newUser = new user(adminSignUpName.getText(),adminSignUpLastName.getText(),Integer.parseInt(adminSignUpAge.getText()),adminSignUpPassword.getText(),"","","","","",true);
                        signInsignUp.signUp(newUser);
                        adminSignUpName.setText("");
                        adminSignUpLastName.setText("");
                        adminSignUpAge.setText("");
                        adminSignUpPassword.setText("");
                        adminSignUpPassword2.setText("");


                        System.out.println( databaseController.getDatabase());
                        Label adminID = new Label();
                        adminID.getStyleClass().add("textsaveID");
                        adminID.setText("ID numaranızı kesinlikle saklayınız: "+databaseController.getDatabase().get(databaseController.getDatabase().size()-1).getID());
                        Button btn = new Button("ID kopyala");
                        btn.getStyleClass().add("btn");
                        btn.setOnMouseClicked(event2 -> {
                            ClipboardContent content = new ClipboardContent();
                            content.putString(databaseController.getDatabase().get(databaseController.getDatabase().size()-1).getID());
                            Clipboard.getSystemClipboard().setContent(content);
                        });
                        rigthSide.getChildren().add(adminID);
                        rigthSide.getChildren().add(btn);
                    }



                }
            });

            vBox.getChildren().add(lb);
            vBox.getChildren().add(adminSignUpName);
            vBox.getChildren().add(adminSignUpLastName);
            vBox.getChildren().add(adminSignUpAge);
            vBox.getChildren().add(adminSignUpPassword);
            vBox.getChildren().add(adminSignUpPassword2);
            vBox.getChildren().add(adminSignUpBtn);

            rigthSide.getChildren().add(vBox);
        }
        else {
            int size = rigthSide.getChildren().size();

            for (int i = 7 ; i<size;i++)
                rigthSide.getChildren().remove(7);

            adminsignupstate=false;
        }
    }
}
