package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import models.Material;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paul
 */
public class MaterialDAO {

    public List<Material> getAllMaterials() throws SQLException {
        List<Material> materials = new ArrayList<>();
        String sql = "SELECT MaterialID, Name, Quantity, Reorder FROM material";
 
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
 
            while (rs.next()) {
                materials.add(new Material(
                        rs.getString("MaterialID"),
                        rs.getString("Name"),
                        rs.getString("Quantity"),
                        rs.getString("Reorder")
                ));
            }
        }
        return materials;
    }
 
    public boolean addMaterial(Material material) throws SQLException {
        String sql = "INSERT INTO material (MaterialID, Name, Quantity, Reorder) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
 
            stmt.setString(1, material.getMaterialId());
            stmt.setString(2, material.getName());
            stmt.setString(3, material.getQuantity());
            stmt.setString(4, material.getReorder());
 
            return stmt.executeUpdate() == 1;
        }
    }
 
    public boolean updateMaterial(Material material) throws SQLException {
        String sql = "UPDATE material SET Name = ?, Quantity = ?, Reorder = ? WHERE MaterialID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
 
            stmt.setString(1, material.getName());
            stmt.setString(2, material.getQuantity());
            stmt.setString(3, material.getReorder());
            stmt.setString(4, material.getMaterialId());
 
            return stmt.executeUpdate() == 1;
        }
    }
 
    public boolean deleteMaterial(String materialId) throws SQLException {
        String sql = "DELETE FROM material WHERE MaterialID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
 
            stmt.setString(1, materialId);
            return stmt.executeUpdate() == 1;
        }
    }
}

