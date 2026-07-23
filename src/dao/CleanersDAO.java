/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import models.CleanerModel;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author User
 */
public class CleanersDAO {
    public void addCleaner(CleanerModel cleaner){
        String sql = 
                "INSERT INTO CleanerModel(cleanerName, cleanerId, cleaner_ContactNumber,cleaner_ComapnyName, cleaner_streetAdress, cleanerCity,cleanerCountry,cleaner_PostalCode,isActive)"
                + "VALUES(?, ?, ?, ?, ?,?,?,?,?)";
        try( Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
             ps.setInt(1, cleaner.getCleanerId());
             ps.setString(2, cleaner.getCleanerName());
             ps.setString(3, cleaner.getCleaner_CompanyName());
             ps.setString(4, cleaner.getCleanerCountry());
             ps.setString(5, cleaner.getCleanerCity());
             ps.setString(6, cleaner.getCleaner_streetAddress());
             ps.setInt(7, cleaner.getCleaner_PostalCode());
             ps.setInt(8, cleaner.getCleaner_ContactNumber());
             ps.setBoolean(9,cleaner.isCleaner_isActive());
           
             ps.executeUpdate();
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public ArrayList<CleanerModel> getAllCleaners() {

    ArrayList<CleanerModel> cleaners = new ArrayList<>();

    String sql = "SELECT * FROM CleanerModel";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         java.sql.ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            CleanerModel cleaner = new CleanerModel();
            cleaner.setCleanerId(rs.getInt("cleanerId"));
            cleaner.setCleanerName(rs.getString("cleanerName"));
            cleaner.setCleaner_ContactNumber(rs.getInt("cleaner_ContactNumber"));
            cleaner.setCleaner_CompanyName(rs.getString("cleaner_CompanyName"));
            cleaner.setCleaner_streetAddress(rs.getString("cleaner_streetAddress"));
            cleaner.setCleanerCity(rs.getString("cleanerCity"));
            cleaner.setCleanerCountry(rs.getString("cleanerCountry"));
            cleaner.setCleaner_PostalCode(rs.getInt("cleaner_PostalCode"));
            cleaner.setCleaner_isActive(rs.getBoolean("cleaner_isActive"));

            cleaners.add(cleaner);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return cleaners;
    }
    public CleanerModel getCleanerById(int id) {

    String sql = "SELECT * FROM CleanerModel WHERE cleanerId = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, id);

        ResultSet rs = (ResultSet) ps.executeQuery();

        if (rs.next()) {

            CleanerModel cleaner = new CleanerModel();

            cleaner.setCleanerId(rs.getInt("cleanerId"));
            cleaner.setCleanerName(rs.getString("cleanerName"));
            cleaner.setCleaner_ContactNumber(rs.getInt("cleaner_ContactNumber"));
            cleaner.setCleaner_CompanyName(rs.getString("cleaner_CompanyName"));
            cleaner.setCleaner_streetAddress(rs.getString("cleaner_streetAddress"));
            cleaner.setCleanerCity(rs.getString("cleanerCity"));
            cleaner.setCleanerCountry(rs.getString("cleanerCountry"));
            cleaner.setCleaner_PostalCode(rs.getInt("cleaner_PostalCode"));
            cleaner.setCleaner_isActive(rs.getBoolean("cleaner_isActive"));

            return cleaner;
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return null;
}
  public void updateCleaner(CleanerModel cleaner) {

    String sql = "UPDATE CleanerModel SET "
            + "cleanerName = ?, "
            + "cleaner_ContactNumber = ?, "
            + "cleaner_CompanyName = ?, "
            + "cleaner_streetAddress = ?, "
            + "cleanerCity = ?, "
            + "cleanerCountry = ?, "
            + "cleaner_PostalCode = ?, "
            + "isActive = ? "
            + "WHERE cleanerId = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, cleaner.getCleanerName());
        ps.setInt(2, cleaner.getCleaner_ContactNumber());
        ps.setString(3, cleaner.getCleaner_CompanyName());
        ps.setString(4, cleaner.getCleaner_streetAddress());
        ps.setString(5, cleaner.getCleanerCity());
        ps.setString(6, cleaner.getCleanerCountry());
        ps.setInt(7, cleaner.getCleaner_PostalCode());
        ps.setBoolean(8, cleaner.isCleaner_isActive());
        ps.setInt(9, cleaner.getCleanerId());

        ps.executeUpdate();

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}  
    public void deleteCleaner(int cleanerId) {

    String sql = "DELETE FROM CleanerModel WHERE cleanerId = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, cleanerId);

        ps.executeUpdate();

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
}

    

