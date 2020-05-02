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
    public Collection<ContactRequest> getRequestByStaffID(String staffID){
        String sql = "select * from ContactRequest where staffID = ? and studenttoprofessor = true";
        
        try(
            Connection dbCon = DbConnection.getConnection(contactRequestURI);
            PreparedStatement stmt = dbCon.prepareStatement(sql);
        ){
            Integer id = Integer.parseInt(staffID);
            stmt.setInt(1, id);
            
            List<ContactRequest> requests = new ArrayList<>();
            
            ResultSet rs = stmt.executeQuery();
            
            // If we get something back from the db
            while(rs.next()){
                Integer staff = rs.getInt("staffID");
                Integer student = rs.getInt("studentID");
                String studentFirstname = rs.getString("studentFirstname");
                String studentLastname = rs.getString("studentLastname");
                String staffFirstname = rs.getString("staffFirstname");
                String staffLastname = rs.getString("staffLastname");
                String message = rs.getString("Message");
                boolean studToStaffBool = rs.getBoolean("studenttoprofessor");
                
                ContactRequest cr = new ContactRequest(staff, student, studentFirstname, studentLastname, staffFirstname, staffLastname, message, studToStaffBool);
                requests.add(cr);
            }
            return requests;
        }catch(SQLException ex){
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    @Override
    public Collection<ContactRequest> getRequestByStudentID(String studentID){
        String sql = "select * from ContactRequest where studentID = ? and studenttoprofessor = false";
        
        
        try(
            Connection dbCon = DbConnection.getConnection(contactRequestURI);
            PreparedStatement stmt = dbCon.prepareStatement(sql);
        ){
            System.out.println("Called");
            Integer id = Integer.parseInt(studentID);
            stmt.setInt(1, id);
            
            List<ContactRequest> requests = new ArrayList<>();
            
            ResultSet rs = stmt.executeQuery();
            
            // If we get something back from the db
            while(rs.next()){
                Integer staff = rs.getInt("staffID");
                Integer student = rs.getInt("studentID");
                String studentFirstname = rs.getString("studentFirstname");
                String studentLastname = rs.getString("studentLastname");
                String staffFirstname = rs.getString("staffFirstname");
                String staffLastname = rs.getString("staffLastname");
                String message = rs.getString("Message");
                boolean studToStaffBool = rs.getBoolean("studenttoprofessor");
               
                System.out.println(staff + " " + student + " " + message);
                       
                ContactRequest cr = new ContactRequest(staff, student, studentFirstname, studentLastname, staffFirstname, staffLastname, message, studToStaffBool);
                requests.add(cr);
            }
            return requests;
        }catch(SQLException ex){
            throw new DAOException(ex.getMessage(), ex);
        }
    }
}
