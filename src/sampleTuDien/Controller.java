package sampleTuDien;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.*;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    TextField tuKhoa;
    @FXML
    ListView<String> listView = new ListView<>();
    @FXML
    static Map<String,String> duLieu = new HashMap<>();
    @FXML
    WebView webView;
    WebEngine webEngine;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            khoiTaoDuLieu();
            xuLiNgoaiLe();

    }

    public void xuLiNgoaiLe(){
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    @Override
                    public void checkClientTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }
                }
        };

        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }

    public void khoiTaoDuLieu() {
        String line,word,def;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("src\\sampleTuDien\\E_V.txt"), "UTF8");
            BufferedReader reader = new BufferedReader(inputStreamReader);
            while ((line = reader.readLine()) != null) {
                int index1 = line.indexOf("<html>");
                int index2 = line.indexOf("<ul>");
                if (index2 != -1 && index1 > index2) index1 = index2;
                if (index1 != -1) {
                    word = line.substring(0, index1);
                    word = word.trim();
                    def = line.substring(index1);
                    duLieu.put(word.toLowerCase(), def);
                }
            }
            reader.close();
        } catch (Exception e) { e.printStackTrace();}
    }

    public void dich() throws Exception {
        String tukhoa = tuKhoa.getText().toLowerCase();
        String nghiaCuaTu = duLieu.get(tukhoa);
        if (nghiaCuaTu != null) {
            webEngine=webView.getEngine();
            webEngine.loadContent(nghiaCuaTu);
        }
        else {
            webEngine = webView.getEngine();
            webEngine.load("https://translate.google.com/?hl=vi#en");
        }
        listView.getItems().add(tuKhoa.getText());
    }

    public void themTu(ActionEvent event) throws Exception {
        Stage stage1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ThemTu.fxml"));
        Parent ViewThemTuMoi = loader.load();
        Scene newScene = new Scene(ViewThemTuMoi);
        ThemTu controller = loader.getController();
        stage1.setScene(newScene);
    }

    public void xoaTu(ActionEvent event) throws Exception {
        Stage stage2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("XoaTu.fxml"));
        Parent ViewXoaTu = loader1.load();
        Scene newScene1 = new Scene(ViewXoaTu);
        XoaTu controller = loader1.getController();
        stage2.setScene(newScene1);
    }

    public void troGiup () {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("HELP");
        alert.setContentText("Có cho đẹp thôi , ahihi Đồ Ngốk =)) ");
        alert.show();
    }
}
