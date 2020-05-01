package dao;

import domain.ContactRequest;
// Probably don't need to import Collection
import java.util.Collection;
/**
 *
 * @author leon
 */
public interface ContactRequestInterface {
    void saveContactRequest(ContactRequest cr);
    
    Collection<ContactRequest> getRequestByStaffID(String staffID);
    
    ContactRequest getRequestByStudentID(Integer studentID);
}
