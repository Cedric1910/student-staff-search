package web;

import dao.StudentDAO;
import org.jooby.Jooby;
import org.jooby.Result;
import org.jooby.Status;
import domain.Student;

public class StudentModule extends Jooby{
    
    public StudentModule(StudentDAO studentDAO){
	port(8080);

	post("api/register/student", (req, rsp) -> {
		Student student = req.body().to(Student.class);
		studentDAO.saveStudent(student);
		rsp.status(Status.CREATED);
	    });

	//post("api/student/:categories", (req, rsp) -> {
	//	return staffDAO.returnAvailableCategories();
	//    });
    }
    
}
