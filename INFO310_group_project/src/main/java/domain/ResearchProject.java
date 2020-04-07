/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author cedricstephani
 */
public class ResearchProject {
    private int projectID; 
    private String studentID; 
    private String staffID; 
    private String projectName; 
    private String description; 
    private String category; 
    private String subCategory; 
    private String status; 

    public ResearchProject(int projectID, String studentID, String staffID, String projectName, String description, String category, String subCategory, String status) {
        this.projectID = projectID;
        this.studentID = studentID;
        this.staffID = staffID;
        this.projectName = projectName;
        this.description = description;
        this.category = category;
        this.subCategory = subCategory;
        this.status = status;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
