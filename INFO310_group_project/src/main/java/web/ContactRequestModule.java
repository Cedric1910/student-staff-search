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
import org.jooby.Status;
import domain.ContactRequest;
import org.jooby.Result;

public class ContactRequestModule extends Jooby {
    
    // Creates new interface using the StudentDAO file
    ContactRequestInterface crDAO = new ContactRequestDAO();

    public ContactRequestModule(ContactRequestInterface crDAO) {
        port(8080);
        
        // Saves a newly made contact request in the cr db
        post("/api/contactrequest/newreq", (req, rsp) -> {
            ContactRequest cr = req.body().to(ContactRequest.class);
            crDAO.saveContactRequest(cr);
        });
        
        // Returns a ContactRequest object based on a staff member's id
        get("/api/contactrequest/:staffID", (req) -> {
            // This is a god awful way to do this bit, need to get a way to get int
            // from req
            Integer staffID = Integer.parseInt(req.param("staffID").value());
            return crDAO.getRequestByStaffID(staffID);
        });
        
        // Returns a ContactRequest object based on a student's id
        get("/api/contactrequest/:studentID", (req) -> {
            // This is a god awful way to do this bit, need to get a way to get int
            // from req
            Integer studentID = Integer.parseInt(req.param("studentID").value());
            return crDAO.getRequestByStaffID(studentID);
        });
    }
}
