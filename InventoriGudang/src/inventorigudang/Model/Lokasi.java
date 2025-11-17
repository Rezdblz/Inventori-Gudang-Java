/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorigudang.Model;

/**
 *
 * @author ASUS
 */
public class Lokasi extends ModelBase {

    private String deskripsi;

    public Lokasi() {
    }

    public Lokasi(String deskripsi, int id, String nama) {
        super(id, nama);
        this.deskripsi = deskripsi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    @Override
    public String toString() {
        return getNama();
    }
}
