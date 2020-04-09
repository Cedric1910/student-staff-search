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
    
    Collection<String> returnAvailableCategories();
}
