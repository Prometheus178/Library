import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Main extends HttpServlet {
    public void doGet(HttpServletResponse response, HttpServletRequest request) throws IOException {
        TestDB testDB = new TestDB();
        testDB.check();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.print("<html><body>");

        out.print("testDB.check();");
        out.print("<body></html>");
    }
}
