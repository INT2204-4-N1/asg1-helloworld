package sampleTuDien;

import javafx.scene.Parent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Từ Điển Anh - Việt");
        primaryStage.setScene(new Scene(root,  1125, 635));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
