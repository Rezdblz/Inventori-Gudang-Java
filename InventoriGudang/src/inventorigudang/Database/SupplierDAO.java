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
public class SupplierDAO implements DBMinimum<Supplier>{
    private final Connection conn=DBConnection.getConnection();

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
