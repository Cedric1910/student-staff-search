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
}
