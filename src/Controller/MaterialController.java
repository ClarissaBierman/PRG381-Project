/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;
import models.Material;
import dao.MaterialDAO;
/**
 *
 * @author Paul
 */
public class MaterialController {
 
    private static final Pattern DIGITS_ONLY = Pattern.compile("^\\d+$");
    private static final Pattern LETTERS_ONLY = Pattern.compile("^[A-Za-z\\s]+$");
 
    private final MaterialDAO materialDAO = new MaterialDAO();

    public String loadMaterials(javax.swing.table.DefaultTableModel tableModel) {
        try {
            List<Material> materials = materialDAO.getAllMaterials();
            tableModel.setRowCount(0);
            for (Material m : materials) {
                tableModel.addRow(new Object[]{
                        m.getMaterialId(), m.getName(), m.getQuantity(), m.getReorder()
                });
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return "A database error occurred while loading materials.";
        }
    }
 
    public String addMaterial(String materialId, String name, String quantity, String reorder) {
        String validationError = validate(materialId, name, quantity, reorder);
        if (validationError != null) return validationError;
 
        try {
            boolean success = materialDAO.addMaterial(
                    new Material(materialId.trim(), name.trim(), quantity.trim(), reorder.trim()));
            return success ? null : "Failed to add material.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "A database error occurred while adding the material.";
        }
    }
 
    public String updateMaterial(String materialId, String name, String quantity, String reorder) {
        String validationError = validate(materialId, name, quantity, reorder);
        if (validationError != null) return validationError;
 
        try {
            boolean success = materialDAO.updateMaterial(
                    new Material(materialId.trim(), name.trim(), quantity.trim(), reorder.trim()));
            return success ? null : "Failed to update material. Check that the Material ID exists.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "A database error occurred while updating the material.";
        }
    }
 
    public String deleteMaterial(String materialId) {
        if (isBlank(materialId)) {
            return "Please select a material to delete.";
        }
        if (!DIGITS_ONLY.matcher(materialId.trim()).matches()) {
            return "Material ID must contain numbers only.";
        }
 
        try {
            boolean success = materialDAO.deleteMaterial(materialId.trim());
            return success ? null : "Failed to delete material. Check that the Material ID exists.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "A database error occurred while deleting the material.";
        }
    }
 
    private String validate(String materialId, String name, String quantity, String reorder) {
        if (isBlank(materialId) || isBlank(name) || isBlank(quantity) || isBlank(reorder)) {
            return "Please fill in all fields.";
        }
        if (!DIGITS_ONLY.matcher(materialId.trim()).matches()) {
            return "Material ID must contain numbers only.";
        }
        if (!LETTERS_ONLY.matcher(name.trim()).matches()) {
            return "Name cannot contain numbers.";
        }
        if (!DIGITS_ONLY.matcher(quantity.trim()).matches()) {
            return "Quantity must contain numbers only.";
        }
        if (!DIGITS_ONLY.matcher(reorder.trim()).matches()) {
            return "Reorder must contain numbers only.";
        }
        return null;
    }
 
    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}

