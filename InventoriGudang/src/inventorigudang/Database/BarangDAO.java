/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorigudang.Database;

import inventorigudang.Model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class BarangDAO implements DBAction<Barang>{
    private Connection conn= DBConnection.getConnection();
    
    public BarangDAO() {
        
    }

    @Override
    public void insert(Barang item) {
        String sql="INSERT INTO barang (nama, kategori, harga, stok, supplier_id, lokasi_id) VALUES (?, ?, ?, ?, ?, ?)";
        try(PreparedStatement stmt=conn.prepareStatement(sql)){
            stmt.setString(1, item.getNama());
            stmt.setString(2, item.getKategori());
            stmt.setDouble(3, item.getHarga());
            stmt.setInt(4, item.getStok());
            stmt.setInt(5, item.getSupplier().getId());
            stmt.setInt(6, item.getLokasi().getId());
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Barang item) {
        String sql = "UPDATE barang SET nama=?, kategori=?, harga=?, stok=?, supplier_id=?, lokasi_id=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, item.getNama());
            stmt.setString(2, item.getKategori());
            stmt.setDouble(3, item.getHarga());
            stmt.setInt(4, item.getStok());
            stmt.setInt(5, item.getSupplier().getId());
            stmt.setInt(6, item.getLokasi().getId());
            stmt.setInt(7, item.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM barang WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Barang getById(int id) {
        String sql = "SELECT * FROM barang WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                Barang barang = new Barang();
                barang.setId(result.getInt("id"));
                barang.setNama(result.getString("nama"));
                barang.setKategori(result.getString("kategori"));
                barang.setHarga(result.getDouble("harga"));
                barang.setStok(result.getInt("stok"));
                
                Supplier supplier = new Supplier();
                supplier.setId(result.getInt("supplier_id"));
                barang.setSupplier(supplier);

                Lokasi lokasi = new Lokasi();
                lokasi.setId(result.getInt("lokasi_id"));
                barang.setLokasi(lokasi);

                return barang;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Barang> getAll() {
        List<Barang> list = new ArrayList<>();
        String sql = """
                     select 
                        b.id, b.kategori, b.nama, b.harga, b.stok,b.supplier_id,b.lokasi_id,
                        l.id, l.nama as lokasi_nama,
                        s.id, s.nama as supplier_nama
                     from barang b, lokasi l, supplier s   
                     where
                     b.supplier_id=l.id and 
                     b.lokasi_id=s.id 
                     order by b.id
                     """;
                    
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                Barang barang = new Barang();

                barang.setId(result.getInt("id"));
                barang.setNama(result.getString("nama"));
                barang.setKategori(result.getString("kategori"));
                barang.setHarga(result.getDouble("harga"));
                barang.setStok(result.getInt("stok"));

                Supplier supplier = new Supplier();
                supplier.setId(result.getInt("supplier_id"));
                supplier.setNama(result.getString("supplier_nama"));
                barang.setSupplier(supplier);

                Lokasi lokasi = new Lokasi();
                lokasi.setId(result.getInt("lokasi_id"));
                lokasi.setNama(result.getString("lokasi_nama"));
                barang.setLokasi(lokasi);

                list.add(barang);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
    
    
    
}
