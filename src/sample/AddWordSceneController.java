package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddWordSceneController extends Dictionary{
    @FXML
    TextField addWord;
    @FXML
    TextField addMeanWord;

    public void OK(ActionEvent event) throws Exception {
        Stage stage1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DictionaryScene.fxml"));
        Parent ViewOK = loader.load();
        Scene newScene = new Scene(ViewOK);
        stage1.setScene(newScene);
        data.put(String.valueOf(addWord),String.valueOf(addMeanWord));
    }
}
