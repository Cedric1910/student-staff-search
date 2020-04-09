package dao;

/**
 * INFO210
 * StudentfDAO.java
 * @author Hugo Baird
 */

import domain.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO implements StudentInterface{
    private String studentUri = DbConnection.getDefaultConnectionUri();

    public StudentDAO() {
    }
    
    public StudentDAO(String studentUri) {
        this.studentUri = studentUri;
    }
    
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
}
