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
public class TransaksiDAO implements DBAction<Transaksi>{
    private Connection conn;
    private BarangDAO barangDAO;

    public TransaksiDAO(BarangDAO barangDAO) {
        this.conn=DBConnection.getConnection();
        this.barangDAO = barangDAO;
    }

    @Override
    public void insert(Transaksi item) {
        String sql = "INSERT INTO transaksi (barang_id, jenis, jumlah, tanggal, total_harga, nama) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, item.getBarang().getId());
            stmt.setString(2, item.getJenis());
            stmt.setInt(3, item.getJumlah());

            java.sql.Date sqlDate = new java.sql.Date(item.getTanggal().getTime());
            stmt.setDate(4, sqlDate);

            stmt.setDouble(5, item.getTotalHarga());
            stmt.setString(6, item.getNama());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Transaksi item) {
         String sql = "UPDATE transaksi SET barang_id=?, jenis=?, jumlah=?, tanggal=?, total_harga=?, nama=? "
                   + "WHERE id=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, item.getBarang().getId());
            stmt.setString(2, item.getJenis());
            stmt.setInt(3, item.getJumlah());

            java.sql.Date sqlDate = new java.sql.Date(item.getTanggal().getTime());
            stmt.setDate(4, sqlDate);

            stmt.setDouble(5, item.getTotalHarga());
            stmt.setString(6, item.getNama());
            stmt.setInt(7, item.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM transaksi WHERE id=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Transaksi getById(int id) {
        String sql = "SELECT * FROM transaksi WHERE id=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                Transaksi item = new Transaksi();

                item.setId(result.getInt("id"));
                item.setNama(result.getString("nama"));

                int barangId = result.getInt("barang_id");
                Barang barang = barangDAO.getById(barangId);
                item.setBarang(barang);

                item.setJenis(result.getString("jenis"));
                item.setJumlah(result.getInt("jumlah"));
                item.setTanggal(result.getDate("tanggal"));
                item.setTotalHarga(result.getDouble("total_harga"));

                return item;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Transaksi> getAll() {
        String sql = "SELECT * FROM transaksi";
        List<Transaksi> list = new ArrayList<>();

        try (Statement stmt = conn.createStatement()) {

            ResultSet result = stmt.executeQuery(sql);

            while (result.next()) {
                Transaksi item = new Transaksi();

                item.setId(result.getInt("id"));
                item.setNama(result.getString("nama"));

                int barangId = result.getInt("barang_id");
                Barang barang = barangDAO.getById(barangId);
                item.setBarang(barang);

                item.setJenis(result.getString("jenis"));
                item.setJumlah(result.getInt("jumlah"));
                item.setTanggal(result.getDate("tanggal"));
                item.setTotalHarga(result.getDouble("total_harga"));

                list.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
}
  