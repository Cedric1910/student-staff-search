package dao;

/**
 * INFO310
 * StaffInterface.java
 * @author Hugo Baird
 */

import domain.Student;
import java.util.Collection;

public interface StudentInterface {
    void saveStudent(Student student);
    
    Student getStudent(String user);
    
    Collection<String> returnAvailableCategories();
}
