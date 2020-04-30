/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.ContactRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author leon
 */
public class ContactRequestDAO implements ContactRequestInterface {

    private String contactRequestURI = DbConnection.getDefaultConnectionUri();

    // Base constructor
    public ContactRequestDAO() {
    }

    public ContactRequestDAO(String uri) {
        this.contactRequestURI = uri;
    }

    @Override
    public void saveContactRequest(ContactRequest cr) {
        String sql = "Insert into contactrequest (studentid, staffid, message, studenttoprofessor) values (?,?,?,?)";

        try (
                Connection dbCon = DbConnection.getConnection(contactRequestURI);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
            ) {
            stmt.setInt(1, cr.getStudentID());
            stmt.setInt(2, cr.getStaffID());
            stmt.setString(3, cr.getMessage());
            stmt.setBoolean(4, cr.isStudentToStaff());
            
            stmt.executeUpdate();
        }catch(SQLException ex){
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    @Override
    public ContactRequest getRequestByStaffID(Integer staffID){
        String sql = "select * from contactrequest where staffID = ?";
        
        try(
            Connection dbCon = DbConnection.getConnection(contactRequestURI);
            PreparedStatement stmt = dbCon.prepareStatement(sql);
        ){
            stmt.setInt(1, staffID);
            
            ResultSet rs = stmt.executeQuery();
            
            // If we get something back from the db
            if(rs.next()){
                Integer staff = rs.getInt("staffID");
                Integer student = rs.getInt("studentID");
                String message = rs.getString("Message");
                boolean studToStaffBool = rs.getBoolean("studenttoprofessor");
                
                return new ContactRequest(staff, student, message, studToStaffBool);
            }else{
                return null; // If the db doesn't contain a staff with the staffID given.
            }
        }catch(SQLException ex){
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    
    @Override
    public ContactRequest getRequestByStudentID(Integer studentID){
        String sql = "select * from contactrequest where studentID = ?";
        
        try(
            Connection dbCon = DbConnection.getConnection(contactRequestURI);
            PreparedStatement stmt = dbCon.prepareStatement(sql);
        ){
            stmt.setInt(1, studentID);
            
            ResultSet rs = stmt.executeQuery();
            
            // If we get something back from the db
            if(rs.next()){
                Integer staff = rs.getInt("staffID");
                Integer student = rs.getInt("studentID");
                String message = rs.getString("Message");
                boolean studToStaffBool = rs.getBoolean("studenttoprofessor");
                
                return new ContactRequest(staff, student, message, studToStaffBool);
            }else{
                return null; // If the db doesn't contain a staff with the staffID given.
            }
        }catch(SQLException ex){
            throw new DAOException(ex.getMessage(), ex);
        }
    }
}
