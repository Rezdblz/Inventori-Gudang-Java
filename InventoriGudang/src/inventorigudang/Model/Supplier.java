/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorigudang.Model;

/**
 *
 * @author ASUS
 */
public class Supplier extends ModelBase {

    private String alamat;

    public Supplier() {
    }

    public Supplier(String alamat, int id, String nama) {
        super(id, nama);
        this.alamat = alamat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public String toString() {
        return getNama() + " - " + alamat;
    }
}
