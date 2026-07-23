/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import models.SuppliersModel;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;


/**
 *
 * @author User
 */
public class SuppliersDAO {
    public void addSupplier(SuppliersModel suppliers){
        String sql = 
                "INSERT INTO SuppliersModel(supplierName, supplierId, supplier_ContactNumber,supplier_ComapnyName, supplier_streetAdress, supplierCity,supplierCountry,supplier_PostalCode,isActive)"
                + "VALUES(?, ?, ?, ?, ?,?,?,?,?)";
        try( Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
             ps.setInt(1, suppliers.getSupplierId());
             ps.setString(2, suppliers.getSupplierName());
             ps.setString(3, suppliers.getSupplier_CompanyName());
             ps.setString(4, suppliers.getSupplierCountry());
             ps.setString(5, suppliers.getSupplierCity());
             ps.setString(6, suppliers.getSupplier_streetAddress());
             ps.setInt(7, suppliers.getSupplier_PostalCode());
             ps.setInt(8, suppliers.getSupplier_ContactNumber());
             ps.setBoolean(9,suppliers.isIsActive());
           
             ps.executeUpdate();
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public ArrayList<SuppliersModel> getAllSuppliers() {

    ArrayList<SuppliersModel> suppliersList = new ArrayList<>();

    String sql = "SELECT * FROM SuppliersModel";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         java.sql.ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            SuppliersModel supplier = new SuppliersModel();

            supplier.setSupplierId(rs.getInt("supplierId"));
            supplier.setSupplierName(rs.getString("supplierName"));
            supplier.setSupplier_ContactNumber(rs.getInt("supplier_ContactNumber"));
            supplier.setSupplier_CompanyName(rs.getString("supplier_ComapnyName"));
            supplier.setSupplier_streetAddress(rs.getString("supplier_streetAdress"));
            supplier.setSupplierCity(rs.getString("supplierCity"));
            supplier.setSupplierCountry(rs.getString("supplierCountry"));
            supplier.setSupplier_PostalCode(rs.getInt("supplier_PostalCode"));
            supplier.setIsActive(rs.getBoolean("isActive"));

            suppliersList.add(supplier);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return suppliersList;
}
    public SuppliersModel getSupplierById(int supplierId) {

    String sql = "SELECT * FROM SuppliersModel WHERE supplierId = ?";

    SuppliersModel supplier = null;

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, supplierId);

        ResultSet rs = (ResultSet) ps.executeQuery();

        if (rs.next()) {

            supplier = new SuppliersModel();

            supplier.setSupplierId(rs.getInt("supplierId"));
            supplier.setSupplierName(rs.getString("supplierName"));
            supplier.setSupplier_ContactNumber(rs.getInt("supplier_ContactNumber"));
            supplier.setSupplier_CompanyName(rs.getString("supplier_ComapnyName"));
            supplier.setSupplier_streetAddress(rs.getString("supplier_streetAdress"));
            supplier.setSupplierCity(rs.getString("supplierCity"));
            supplier.setSupplierCountry(rs.getString("supplierCountry"));
            supplier.setSupplier_PostalCode(rs.getInt("supplier_PostalCode"));
            supplier.setIsActive(rs.getBoolean("isActive"));
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return supplier;
}
    public void updateSupplier(SuppliersModel supplier) {

    String sql =
        "UPDATE SuppliersModel SET " +
        "supplierName=?, " +
        "supplier_ContactNumber=?, " +
        "supplier_ComapnyName=?, " +
        "supplier_streetAdress=?, " +
        "supplierCity=?, " +
        "supplierCountry=?, " +
        "supplier_PostalCode=?, " +
        "isActive=? " +
        "WHERE supplierId=?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, supplier.getSupplierName());
        ps.setInt(2, supplier.getSupplier_ContactNumber());
        ps.setString(3, supplier.getSupplier_CompanyName());
        ps.setString(4, supplier.getSupplier_streetAddress());
        ps.setString(5, supplier.getSupplierCity());
        ps.setString(6, supplier.getSupplierCountry());
        ps.setInt(7, supplier.getSupplier_PostalCode());
        ps.setBoolean(8, supplier.isIsActive());
        ps.setInt(9, supplier.getSupplierId());

        ps.executeUpdate();

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
    public void deleteSupplier(int supplierId) {

    String sql = "DELETE FROM SuppliersModel WHERE supplierId=?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, supplierId);

        ps.executeUpdate();

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
    
}
