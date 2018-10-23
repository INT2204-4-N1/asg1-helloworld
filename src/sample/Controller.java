package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import java.util.Iterator;

public class Controller extends Dictionary{
    @FXML
    TextField inputWord;
    WebView outputWord;
    public void dich(ActionEvent event) throws Exception{
        Iterator<String> iterator1 = data.keySet().iterator();
        Iterator<String> iterator2 = data.values().iterator();
        while (iterator1.hasNext()) {
            if (String.valueOf(iterator1.next()) == String.valueOf(inputWord)) outputWord.set(String.valueOf(iterator2.next()));
        }
    }

    public void themTuMoi(ActionEvent event) throws Exception {
        Stage stage1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addWordScene.fxml"));
        Parent ViewThemTuMoi = loader.load();
        Scene newScene = new Scene(ViewThemTuMoi);
        AddWordSceneController controller = loader.getController();
        stage1.setScene(newScene);
    }

    public void troGiup(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Trợ giúp đây nhé !");
        alert.setContentText("          ");
        alert.show();
    }
}
