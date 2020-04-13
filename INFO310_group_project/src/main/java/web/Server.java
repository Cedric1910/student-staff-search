package web;

import dao.StaffDAO;
import dao.StaffInterface;
import dao.StudentDAO;
import dao.StudentInterface;
import java.util.concurrent.CompletableFuture;
import org.jooby.Jooby;
import org.jooby.json.Gzon;

public class Server extends Jooby {
    
    StudentInterface StudentDAO = new StudentDAO();
    StaffInterface CustomerDAO = new StaffDAO();
    
    public Server() {
        use(new Gzon());
        use(new StudentModule(StudentDAO));
        use(new StaffModule(CustomerDAO));
        use(new AssetModule());
    }
   
    public static void main(String[] args) throws Exception {
        System.out.println("\nStarting Server.");
        Server server = new Server();
        CompletableFuture.runAsync(() -> {
            server.start();
        });
        server.onStarted(() -> {
            System.out.println("\nPress Enter to stop the server.");
        });
        // wait for user to hit the Enter key
        System.in.read();
        System.exit(0);
        }
}
