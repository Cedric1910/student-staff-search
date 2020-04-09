package web;

import dao.StaffDao;
import org.jooby.Jooby;
import org.jooby.Result;
import org.jooby.Status;
import domain.Staff;

public class StaffModule extends Jooby{
    // StaffDAO staffDAO = new StaffDAO(); This was in the 202 file for CustomerModule
    // From Hugo's github, not entirely sure it needs to be here

    public StaffModule(StaffDAO staffDAO){
	port(8080);
	/* Not sure if this path /api/register/staff will work, I'm assuming you set the path here? */
	get("/api/register/staff", (req, rsp) -> {
		Staff staff = req.body().to(Staff.class));
	    staffDAO.save(staff);
	    rsp.status(Status.CREATED);
	    });
    }
}
