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
    
    Collection<Student> returnStudentbySurname(String sur);
    
    Collection<Student> returnStudent();
    
    Collection<Student> returnCategoryStudent(String specifiedCategory);
    
    Collection<String> returnAvailableCategories();
    
    void deleteStudent(Student student); 
}
