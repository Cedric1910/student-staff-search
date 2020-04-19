package dao;

/**
 * INFO210
 * StaffDAO.java
 * 
 * Involves methods which call the H2 database to perform particular actions
 * such as saving a staff, retrieving a staff and returning all available categories.
 * 
 * @author Hugo Baird
 */

import domain.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class StaffDAO implements StaffInterface {
    
    private String staffUri = DbConnection.getDefaultConnectionUri();

    public StaffDAO() {
    }
    
    public StaffDAO(String staffUri) {
        this.staffUri = staffUri;
    }
    
    @Override
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

    @Override
    public Collection<String> returnAvailableCategories() {
        String sql = "select distinct category from Staff";

        try (
            // get a connection to the database
            Connection dbCon = DbConnection.getConnection(staffUri);

            // create the statement
            PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
            // execute the query
            ResultSet rs = stmt.executeQuery();

            // Using a List to preserve the order in which the data was returned from the query.
            Collection<String> categories = new ArrayList<>();

            // iterate through the query results
            while (rs.next()) {

                // get the data out of the query
                String Category = rs.getString("category");
        
                // and put it in the collection
                categories.add(Category);
            }
            return categories;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }     
    }
    
    @Override
    public Staff getStaff(String user) {
        String sql = "select * from Staff where username = ?";

        try (
            // get connection to database
            Connection connection = DbConnection.getConnection(staffUri);

            // create the statement
            PreparedStatement stmt = connection.prepareStatement(sql);
        ) {
        // set the parameter
        stmt.setString(1, user);

        // execute the query
        ResultSet rs = stmt.executeQuery();

        // query only returns a single result, so use 'if' instead of 'while'
            if (rs.next()) {
                String id = rs.getString("id");   
                String username = rs.getString("username");
                String firstName = rs.getString("firstName");
                String surname = rs.getString("surname");
                String password = rs.getString("password");
                String email = rs.getString("email");

            return new Staff(id, firstName, surname, username, password, email, " ", " ", false);

        } else {
            return null;
        }

        } catch (SQLException ex) {  // we are forced to catch SQLException
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    
    @Override
    public Boolean validateCredentials(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
