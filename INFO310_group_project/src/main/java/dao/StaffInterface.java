package dao;

/**
 * INFO310
 * StaffInterface.java
 * @author Hugo Baird
 */

import domain.Staff;
import java.util.Collection;

public interface StaffInterface {
    void saveStaff(Staff staff);
    
    Staff getStaffbyUsername(String user);
    
    Collection<Staff> returnStaffbySurname(String surname);
    
    Collection<Staff> returnStaff();
    
    Collection<Staff> returnCategoryStaff(String specifiedCategory);
    
    Collection<String> returnAvailableCategories();
}
