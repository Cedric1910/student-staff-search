package web;

/**
 * INFO310
 * StudentModule.java
 * 
 * Specifies URIs to call a particular DAO method in the StudentDAO.
 * 
 */
import dao.StudentInterface;
import dao.StudentDAO;
import org.jooby.Jooby;
import org.jooby.Status;
import domain.Student;
import org.jooby.Result;

public class StudentModule extends Jooby {
    
    // Creates new interface using the StudentDAO file.
    StudentInterface StudentDAO = new StudentDAO();

    public StudentModule(StudentInterface studentDAO) {
        
        // Specifies the port used to communicate between applications.
	port(8080);
        
        // Returns all students currently stored in the database.
        get("/api/student/", () -> StudentDAO.returnStudent());
        
        // Returns a specific student based on their unique username.
        get("/api/student/:username", (req) -> {
            String username = req.param("username").value();
            if(StudentDAO.getStudent(username) == null){
                return new Result().status(Status.NOT_FOUND);
            }
            return StudentDAO.getStudent(username);
        });
        
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
