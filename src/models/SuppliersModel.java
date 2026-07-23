/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package models;

/**
 *
 * @author User
 */

public class SuppliersModel {

    public SuppliersModel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @return the supplierName
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * @param supplierName the supplierName to set
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * @return the supplierId
     */
    public int getSupplierId() {
        return supplierId;
    }

    /**
     * @param supplierId the supplierId to set
     */
    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * @return the supplier_ContactNumber
     */
    public int getSupplier_ContactNumber() {
        return supplier_ContactNumber;
    }

    /**
     * @param supplier_ContactNumber the supplier_ContactNumber to set
     */
    public void setSupplier_ContactNumber(int supplier_ContactNumber) {
        this.supplier_ContactNumber = supplier_ContactNumber;
    }

    /**
     * @return the supplier_CompanyName
     */
    public String getSupplier_CompanyName() {
        return supplier_CompanyName;
    }

    /**
     * @param supplier_CompanyName the supplier_CompanyName to set
     */
    public void setSupplier_CompanyName(String supplier_CompanyName) {
        this.supplier_CompanyName = supplier_CompanyName;
    }

    /**
     * @return the supplier_streetAddress
     */
    public String getSupplier_streetAddress() {
        return supplier_streetAddress;
    }

    /**
     * @param supplier_streetAddress the supplier_streetAddress to set
     */
    public void setSupplier_streetAddress(String supplier_streetAddress) {
        this.supplier_streetAddress = supplier_streetAddress;
    }

    /**
     * @return the supplierCountry
     */
    public String getSupplierCountry() {
        return supplierCountry;
    }

    /**
     * @param supplierCountry the supplierCountry to set
     */
    public void setSupplierCountry(String supplierCountry) {
        this.supplierCountry = supplierCountry;
    }

    /**
     * @return the supplierCity
     */
    public String getSupplierCity() {
        return supplierCity;
    }

    /**
     * @param supplierCity the supplierCity to set
     */
    public void setSupplierCity(String supplierCity) {
        this.supplierCity = supplierCity;
    }

    /**
     * @return the supplier_PostalCode
     */
    public int getSupplier_PostalCode() {
        return supplier_PostalCode;
    }

    /**
     * @param supplier_PostalCode the supplier_PostalCode to set
     */
    public void setSupplier_PostalCode(int supplier_PostalCode) {
        this.supplier_PostalCode = supplier_PostalCode;
    }

    /**
     * @return the isActive
     */
    public boolean isIsActive() {
        return isActive;
    }

    public SuppliersModel(String supplierName, int supplierId, int supplier_ContactNumber, String supplier_CompanyName, String supplier_streetAddress, String supplierCountry, String supplierCity, int supplier_PostalCode, boolean isActive) {
        this.supplierName = supplierName;
        this.supplierId = supplierId;
        this.supplier_ContactNumber = supplier_ContactNumber;
        this.supplier_CompanyName = supplier_CompanyName;
        this.supplier_streetAddress = supplier_streetAddress;
        this.supplierCountry = supplierCountry;
        this.supplierCity = supplierCity;
        this.supplier_PostalCode = supplier_PostalCode;
        this.isActive = isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    private String supplierName;
    private int supplierId;
    private int supplier_ContactNumber;
    private String supplier_CompanyName;
    private String supplier_streetAddress;
    private String supplierCountry;
    private String supplierCity;
    private int supplier_PostalCode;
    private boolean isActive;
}
