package dao;

/**
 * INFO310
 * StudentDAO.java
 * 
 * Involves methods which call the H2 database to perform particular actions
 * such as saving a student, retrieving a student and returning all available categories.
 * 
 * @author Hugo Baird
 */

import domain.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class StudentDAO implements StudentInterface {
    private String studentUri = DbConnection.getDefaultConnectionUri();

    public StudentDAO() {
    }
    
    public StudentDAO(String studentUri) {
        this.studentUri = studentUri;
    }
    
    @Override
    public void saveStudent(Student student) {
        String sql="insert into Student (id, firstName, surname, username, password, email, availability) values (?,?,?,?,?,?,?)";

        try (
            // get connection to database
            Connection dbCon = DbConnection.getConnection(studentUri);

            // create the statement
            PreparedStatement stmt = dbCon.prepareStatement(sql);
          ) {
            // copy the data from the product domain object into the SQL parameters
            stmt.setString(1, student.getId());
            stmt.setString(2, student.getFirstName());
            stmt.setString(3, student.getSurname());
            stmt.setString(4, student.getUsername());
            stmt.setString(5, student.getPassword());
            stmt.setString(6, student.getEmail());
            stmt.setBoolean(7, student.isSearching());
            

            stmt.executeUpdate();  // execute the statement

            } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
          }
    }
    
    @Override
    public Collection<String> returnAvailableCategories() {
        String sql = "select distinct category from Student";

        try (
            // get a connection to the database
            Connection dbCon = DbConnection.getConnection(studentUri);

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
    public Student getStudent(String user) {
        String sql = "select * from Student where username = ?";

        try (
            // get connection to database
            Connection connection = DbConnection.getConnection(studentUri);

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

            return new Student(id, firstName, surname, username, password, email, " ", " ", false);

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
