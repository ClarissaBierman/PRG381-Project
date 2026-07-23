/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author User
 */
public class CleanerModel {

    public CleanerModel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @return the cleanerName
     */
    public String getCleanerName() {
        return cleanerName;
    }

    /**
     * @param cleanerName the cleanerName to set
     */
    public void setCleanerName(String cleanerName) {
        this.cleanerName = cleanerName;
    }

    /**
     * @return the cleanerId
     */
    public int getCleanerId() {
        return cleanerId;
    }

    /**
     * @param cleanerId the cleanerId to set
     */
    public void setCleanerId(int cleanerId) {
        this.cleanerId = cleanerId;
    }

    /**
     * @return the cleaner_ContactNumber
     */
    public int getCleaner_ContactNumber() {
        return cleaner_ContactNumber;
    }

    /**
     * @param cleaner_ContactNumber the cleaner_ContactNumber to set
     */
    public void setCleaner_ContactNumber(int cleaner_ContactNumber) {
        this.cleaner_ContactNumber = cleaner_ContactNumber;
    }

    /**
     * @return the cleaner_CompanyName
     */
    public String getCleaner_CompanyName() {
        return cleaner_CompanyName;
    }

    /**
     * @param cleaner_CompanyName the cleaner_CompanyName to set
     */
    public void setCleaner_CompanyName(String cleaner_CompanyName) {
        this.cleaner_CompanyName = cleaner_CompanyName;
    }

    /**
     * @return the cleaner_streetAddress
     */
    public String getCleaner_streetAddress() {
        return cleaner_streetAddress;
    }

    /**
     * @param cleaner_streetAddress the cleaner_streetAddress to set
     */
    public void setCleaner_streetAddress(String cleaner_streetAddress) {
        this.cleaner_streetAddress = cleaner_streetAddress;
    }

    /**
     * @return the cleanerCountry
     */
    public String getCleanerCountry() {
        return cleanerCountry;
    }

    /**
     * @param cleanerCountry the cleanerCountry to set
     */
    public void setCleanerCountry(String cleanerCountry) {
        this.cleanerCountry = cleanerCountry;
    }

    /**
     * @return the cleanerCity
     */
    public String getCleanerCity() {
        return cleanerCity;
    }

    /**
     * @param cleanerCity the cleanerCity to set
     */
    public void setCleanerCity(String cleanerCity) {
        this.cleanerCity = cleanerCity;
    }

    /**
     * @return the cleaner_PostalCode
     */
    public int getCleaner_PostalCode() {
        return cleaner_PostalCode;
    }

    /**
     * @param cleaner_PostalCode the cleaner_PostalCode to set
     */
    public void setCleaner_PostalCode(int cleaner_PostalCode) {
        this.cleaner_PostalCode = cleaner_PostalCode;
    }

    /**
     * @return the Cleaner_isActive
     */
    public boolean isCleaner_isActive() {
        return Cleaner_isActive;
    }

    /**
     * @param Cleaner_isActive the Cleaner_isActive to set
     */
    public void setCleaner_isActive(boolean Cleaner_isActive) {
        this.Cleaner_isActive = Cleaner_isActive;
    }
    private String cleanerName;
    private int cleanerId;
    private int cleaner_ContactNumber;
    private String cleaner_CompanyName;
    private String cleaner_streetAddress;
    private String cleanerCountry;
    private String cleanerCity;
    private int cleaner_PostalCode;
    private boolean Cleaner_isActive;

    public CleanerModel(String cleanerName, int cleanerId, int cleaner_ContactNumber, String cleaner_CompanyName, String cleaner_streetAddress, String cleanerCountry, String cleanerCity, int cleaner_PostalCode, boolean Cleaner_isActive) {
        this.cleanerName = cleanerName;
        this.cleanerId = cleanerId;
        this.cleaner_ContactNumber = cleaner_ContactNumber;
        this.cleaner_CompanyName = cleaner_CompanyName;
        this.cleaner_streetAddress = cleaner_streetAddress;
        this.cleanerCountry = cleanerCountry;
        this.cleanerCity = cleanerCity;
        this.cleaner_PostalCode = cleaner_PostalCode;
        this.Cleaner_isActive = Cleaner_isActive;
    }
    
}
