/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorigudang.Model;

import java.util.Date;
/**
 *
 * @author ASUS
 */
public class Transaksi extends ModelBase{
    private Barang barang;
    private String jenis;
    private int jumlah;
    private Date tanggal;
    private double totalHarga;

    public Transaksi() {
    }

    public Transaksi(Barang barang, String jenis, int jumlah, Date tanggal, double totalHarga, int id, String nama) {
        super(id, nama);
        this.barang = barang;
        this.jenis = jenis;
        this.jumlah = jumlah;
        this.tanggal = tanggal;
        this.totalHarga = totalHarga;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }
    
}
