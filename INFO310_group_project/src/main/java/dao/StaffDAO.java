package dao;

/**
 * INFO210
 * StaffDAO.java
 * @author Hugo Baird
 */

import domain.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StaffDAO implements StaffInterface{
    
    private String staffUri = DbConnection.getDefaultConnectionUri();

    public StaffDAO() {
    }
    
    public StaffDAO(String staffUri) {
        this.staffUri = staffUri;
    }
    
    public void saveStaff(Staff staff) {
        String sql="insert into Staff (id, firstName, surname, username, password, email, availability) values (?,?,?,?,?,?,?)";

        try (
            // get connection to database
            Connection dbCon = DbConnection.getConnection(staffUri);

            // create the statement
            PreparedStatement stmt = dbCon.prepareStatement(sql);
          ) {
            // copy the data from the product domain object into the SQL parameters
            stmt.setString(1, staff.getId());
            stmt.setString(2, staff.getFirstName());
            stmt.setString(3, staff.getSurname());
            stmt.setString(4, staff.getUsername());
            stmt.setString(5, staff.getPassword());
            stmt.setString(6, staff.getEmail());
            stmt.setBoolean(7, staff.isAvailability());
            

            stmt.executeUpdate();  // execute the statement

            } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
          }
    }
    
}
