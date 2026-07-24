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
        String sql = "SELECT material_id, material_name, quantity, reorder_level FROM materials";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Material material = new Material();
                material.setMaterialId(rs.getInt("material_id"));
                material.setMaterialName(rs.getString("material_name"));
                material.setQuantity(rs.getInt("quantity"));
                material.setReorderLevel(rs.getInt("reorder_level"));
                materials.add(material);
            }
        }
        return materials;
    }

    public boolean addMaterial(Material material) throws SQLException {
        String sql = "INSERT INTO materials (material_id, material_name, quantity, reorder_level) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, material.getMaterialId());
            stmt.setString(2, material.getMaterialName());
            stmt.setInt(3, material.getQuantity());
            stmt.setInt(4, material.getReorderLevel());

            return stmt.executeUpdate() == 1;
        }
    }

    public boolean updateMaterial(Material material) throws SQLException {
        String sql = "UPDATE materials SET material_name = ?, quantity = ?, reorder_level = ? WHERE material_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, material.getMaterialName());
            stmt.setInt(2, material.getQuantity());
            stmt.setInt(3, material.getReorderLevel());
            stmt.setInt(4, material.getMaterialId());

            return stmt.executeUpdate() == 1;
        }
    }

    public boolean deleteMaterial(String materialId) throws SQLException {
        String sql = "DELETE FROM materials WHERE material_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, Integer.parseInt(materialId));
            return stmt.executeUpdate() == 1;
        }
    }
}