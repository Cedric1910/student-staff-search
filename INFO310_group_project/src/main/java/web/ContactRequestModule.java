package web;

/**
 * INFO310
 * ContactRequestModule.java
 * 
 * Specifies URIs to call a particular DAO method in the ContactRequestDAO.
 * 
 */

import dao.ContactRequestInterface;
import dao.ContactRequestDAO;
import org.jooby.Jooby;
import domain.ContactRequest;
import org.jooby.Status;

public class ContactRequestModule extends Jooby {
    
    // Creates new interface using the StudentDAO file
    ContactRequestInterface crDAO = new ContactRequestDAO();

    public ContactRequestModule(ContactRequestInterface crDAO) {
        port(8080);
        
        // Returns a ContactRequest object based on a staff member's id
        get("/api/staff/contactrequest/:staffID", (req) -> {
            String staffID = req.param("staffID").value();
            return crDAO.getRequestByStaffID(staffID);
        });      
        
        // Returns a ContactRequest object based on a student's id
        get("/api/student/contactrequest/:studentID", (req) -> {
            System.out.println("HELLOOOOOO");
            String studentID = req.param("studentID").value();
            return crDAO.getRequestByStudentID(studentID);
        });    
        
        // Saves a newly made contact request in the contact request database
        post("/api/contactrequest/newreq", (req, rsp) -> {
            ContactRequest cr = req.body().to(ContactRequest.class);
            crDAO.saveContactRequest(cr);
            rsp.status(Status.CREATED);
        });
    }
}
