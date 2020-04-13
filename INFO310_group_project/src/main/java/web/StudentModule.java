package web;

import dao.StudentInterface;
import dao.StudentDAO;
import org.jooby.Jooby;
import org.jooby.Status;
import domain.Student;

public class StudentModule extends Jooby{
    
    StudentInterface StudentDAO = new StudentDAO();

    public StudentModule(StudentInterface studentDAO){
	port(8080);
        
        // Returns a list of all available student categories.
        get("/api/student/categories/", () -> StudentDAO.returnAvailableCategories());

        // Calls student DAO to add a new student account to the database.
	post("api/student/register", (req, rsp) -> {
		Student student = req.body().to(Student.class);
		studentDAO.saveStudent(student);
		rsp.status(Status.CREATED);
	    });
    }   
}
