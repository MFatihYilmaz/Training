package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    static Stage stagetop;

    @Override
    public void start(Stage stage) throws IOException {
        stagetop=stage;
        scene = new Scene(loadFXML("primary"), 753, 780);
        scene.getStylesheets().add("sample/stylee.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    static void setRoot(String fxml,String to) throws IOException {
        if (to.equals("login")){
            stagetop.setWidth(753);
            stagetop.setHeight(780);
            stagetop.centerOnScreen();
        }

        else if(to.equals("admin")){
            stagetop.setWidth(1108);
            stagetop.setHeight(710);
            stagetop.centerOnScreen();
        }
        else{
            stagetop.setWidth(753);
            stagetop.setHeight(670);
            stagetop.centerOnScreen();
        }
        scene.setRoot(loadFXML(fxml));

    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}