/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorigudang.Model;

/**
 *
 * @author ASUS
 */
public class Barang extends ModelBase {

    private String kategori;
    private int stok;
    private double harga;
    private Supplier supplier;
    private Lokasi lokasi;

    public Barang() {
    }

    public Barang(String kategori, int stok, double harga, Supplier supplier, Lokasi lokasi, int id, String nama) {
        super(id, nama);
        this.kategori = kategori;
        this.stok = stok;
        this.harga = harga;
        this.supplier = supplier;
        this.lokasi = lokasi;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Lokasi getLokasi() {
        return lokasi;
    }

    public void setLokasi(Lokasi lokasi) {
        this.lokasi = lokasi;
    }

    @Override
    public String toString() {
        return getNama();
    }
}
