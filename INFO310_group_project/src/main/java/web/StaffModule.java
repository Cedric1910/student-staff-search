package web;

import dao.StaffDAO;
import dao.StaffInterface;
import org.jooby.Jooby;
import org.jooby.Status;
import domain.Staff;

public class StaffModule extends Jooby {
    
    StaffInterface StaffDAO = new StaffDAO();

    public StaffModule(StaffInterface StaffDAO) {
	port(8080);
        
        // Returns a list of all available staff categories
        get("/api/categories/", () -> StaffDAO.returnAvailableCategories());
        
	// Calls staff DAO to add new staff account to the database
	post("/api/register/staff", (req, rsp) -> {
		Staff staff = req.body().to(Staff.class);
		StaffDAO.saveStaff(staff);
		rsp.status(Status.CREATED);
	    });
    }
}
