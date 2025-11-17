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
public class LokasiDAO implements DBAction<Lokasi>{
    private Connection conn;
    
    public LokasiDAO() {
        this.conn=DBConnection.getConnection();
    }
    
    @Override
    public void insert(Lokasi item) {
        String sql = "INSERT INTO lokasi (nama, deskripsi) VALUES (?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, item.getNama());
            ps.setString(2, item.getDeskripsi());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Lokasi item) {
        String sql = "UPDATE lokasi SET nama = ?, deskripsi = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, item.getNama());
            ps.setString(2, item.getDeskripsi());
            ps.setInt(3, item.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM lokasi WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Lokasi getById(int id) {
        String sql = "SELECT * FROM lokasi WHERE id = ?";
        Lokasi lokasi = null;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                lokasi = new Lokasi(
                        result.getString("deskripsi"),
                        result.getInt("id"),
                        result.getString("nama")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lokasi;
    }

    @Override
    public List<Lokasi> getAll() {
        String sql = "SELECT * FROM lokasi";
        List<Lokasi> list = new ArrayList<>();

        try (Statement st = conn.createStatement()) {
            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                Lokasi lokasi = new Lokasi(
                        result.getString("deskripsi"),
                        result.getInt("id"),
                        result.getString("nama")
                );
                list.add(lokasi);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
    
    
    
    
    
}
