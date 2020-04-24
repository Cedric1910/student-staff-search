package web;

/**
 * INFO310
 * StaffModule.java
 * 
 * Specifies URIs to call a particular DAO method in the StafDAO.
 * 
 */

import dao.StaffDAO;
import dao.StaffInterface;
import org.jooby.Jooby;
import org.jooby.Status;
import domain.Staff;
import org.jooby.Result;

public class StaffModule extends Jooby {
    
    // Creates new interface using the StaffDAO file.
    StaffInterface StaffDAO = new StaffDAO();

    public StaffModule(StaffInterface StaffDAO) {
        
	// Specifies the port used to communicate between applications.
	port(8080);
        
        // Returns all staff members currently stored in the database.
        get("/api/staff/", () -> StaffDAO.returnStaff());
        
        // Returns a specific staff based on their unique username.
        get("/api/staff/:username", (req) -> {
            String username = req.param("username").value();
            if(StaffDAO.getStaff(username) == null){
                return new Result().status(Status.NOT_FOUND);
            }
            return StaffDAO.getStaff(username);
        });
        
        // Returns a list of all available staff categories.
        get("/api/staff/categories/", () -> StaffDAO.returnAvailableCategories());
        
	// Calls staff DAO to add a new staff account to the database.
	post("/api/staff/register", (req, rsp) -> {
		Staff staff = req.body().to(Staff.class);
		StaffDAO.saveStaff(staff);
		rsp.status(Status.CREATED);
	});
    }
}
