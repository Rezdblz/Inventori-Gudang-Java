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
public class LokasiDAO implements DBMinimum<Lokasi>{
    private Connection conn=DBConnection.getConnection();

    @Override
    public Lokasi getById(int id) {
        String sql = "SELECT * FROM lokasi WHERE id = ?";
        Lokasi lokasi = null;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();

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
