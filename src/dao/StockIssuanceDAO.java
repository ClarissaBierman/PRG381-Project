package dao;

import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StockIssuanceDAO {

    public int getAvailableStock(int materialId) {

        int stock = 0;

        try {
            Connection conn = DBConnection.getConnection();

            String sql =
                "SELECT quantity FROM materials WHERE material_id = ?";

            PreparedStatement ps =
                conn.prepareStatement(sql);

            ps.setInt(1, materialId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                stock = rs.getInt("quantity");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stock;
    }
    
    public boolean issueMaterial(int cleanerId,
                             int materialId,
                             int quantityIssued) {

    try {

        Connection conn = DBConnection.getConnection();

        int currentStock = getAvailableStock(materialId);

        if (quantityIssued > currentStock) {

            System.out.println("Insufficient stock.");

            return false;
        }

        String insertSQL =
            "INSERT INTO stock_issuance " +
            "(cleaner_id, material_id, quantity_issued) " +
            "VALUES (?, ?, ?)";

        PreparedStatement insertStmt =
            conn.prepareStatement(insertSQL);

        insertStmt.setInt(1, cleanerId);
        insertStmt.setInt(2, materialId);
        insertStmt.setInt(3, quantityIssued);

        insertStmt.executeUpdate();

        String updateSQL =
            "UPDATE materials " +
            "SET quantity = quantity - ? " +
            "WHERE material_id = ?";

        PreparedStatement updateStmt =
            conn.prepareStatement(updateSQL);

        updateStmt.setInt(1, quantityIssued);
        updateStmt.setInt(2, materialId);

        updateStmt.executeUpdate();

        return true;

    } catch (SQLException e) {

        e.printStackTrace();

        return false;
    }
 }
}