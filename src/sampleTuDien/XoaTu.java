package sampleTuDien;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class XoaTu extends Controller {
    @FXML
    private TextField deleteWord ;

    public void OK(ActionEvent event) throws Exception{
        Stage stage2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml"));
        Parent ViewOK = loader.load();
        Scene newScene = new Scene(ViewOK);
        stage2.setScene(newScene);
        duLieu.put(String.valueOf(deleteWord.getText()).toLowerCase(), null);
    }
}
