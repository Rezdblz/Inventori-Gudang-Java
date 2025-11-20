/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorigudang.gudang;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 *
 * @author ASUS
 */
public class ReadDbData {
    private final String DB_DATA = "Db_Data.txt";
    private Properties properties;
    
    public ReadDbData() {
        this.properties=new Properties();
        try {
            FileInputStream input=new FileInputStream(DB_DATA);
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key,"");
    }
    
    
}
