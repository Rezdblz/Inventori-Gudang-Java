/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorigudang.Model;

/**
 *
 * @author ASUS
 */
public class ModelBase {
    protected int id;
    protected String nama; 

    public ModelBase() {
    }
    
    public ModelBase(int id,String nama){
        this.id=id;
        this.nama=nama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    
}
