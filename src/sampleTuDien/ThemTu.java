package sampleTuDien;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ThemTu extends Controller{
    @FXML
    private TextField addWord;
    @FXML
    private  TextField addMeanWord;

    public void OK(ActionEvent event) throws Exception {
        Stage stage1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml"));
        Parent ViewOK = loader.load();
        Scene newScene = new Scene(ViewOK);
        stage1.setScene(newScene);
        duLieu.put(String.valueOf(addWord.getText()),String.valueOf(addMeanWord.getText()));
    }
}
