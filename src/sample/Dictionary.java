package sample;

import com.sun.javafx.collections.MappingChange;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Dictionary {
    HashMap<String,String> data = new HashMap();
    ArrayList<String> Words = new ArrayList<String>();
    File path = new File("src/sample/E_V.txt");
    public void  khoiTao(ActionEvent event) throws Exception {
        String line,word,def;
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path),"UTF8");
            BufferedReader reader = new BufferedReader(inputStreamReader);
            while ((line= reader.readLine()) != null) {
                int index1= line.indexOf("<html>");
                int index2= line.indexOf("<ul>");
                if ( index2 != -1 && index1 >index2) index1=index2;
                if (index1!=-1) {
                    word=line.substring(0,index1);
                    word=word.trim();
                    def=line.substring(index1);
                    data.put(word,def);
                    Words.add(word);
                }
            }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("khởi tạo tài nguyên hoàn tất");
        alert.show();
    }
}
