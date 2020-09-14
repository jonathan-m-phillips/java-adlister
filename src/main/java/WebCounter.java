import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/count")
public class WebCounter extends HttpServlet {
    public int count = 1;
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String reset = req.getParameter("reset");

        if (reset == null) {
            count++;
        } else {
            count = 1;
        }
        out.println("<h1> Page views: " + count + ".</h1>");

    }
}