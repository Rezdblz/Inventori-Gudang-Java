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
public class SupplierDAO implements DBAction<Supplier>{
    private Connection conn;

    public SupplierDAO() {
        this.conn=DBConnection.getConnection();
    }

    @Override
    public void insert(Supplier item) {
        String sql = "INSERT INTO supplier (nama, alamat) VALUES (?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, item.getNama());
            stmt.setString(2, item.getAlamat());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Supplier item) {
        String sql = "UPDATE supplier SET nama = ?, alamat = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, item.getNama());
            stmt.setString(2, item.getAlamat());
            stmt.setInt(3, item.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM supplier WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Supplier getById(int id) {
        String sql = "SELECT * FROM supplier WHERE id = ?";
        Supplier supplier = null;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                supplier = new Supplier(
                    result.getString("alamat"),
                    result.getInt("id"),
                    result.getString("nama")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return supplier;
    }

    @Override
    public List<Supplier> getAll() {
         String sql = "SELECT * FROM supplier";
        List<Supplier> list = new ArrayList<>();

        try (Statement stmt = conn.createStatement()) {
            ResultSet result = stmt.executeQuery(sql);

            while (result.next()) {
                Supplier supplier = new Supplier(
                    result.getString("alamat"),
                    result.getInt("id"),
                    result.getString("nama")
                );
                list.add(supplier);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
}
