//4. Create a servlet that listens for requests to ```/ping``` and a servlet that listens for requests
// to ```/pong```. The former servlet should simply return a link that sends a request to the latter,
// and vice versa! If successfully built, the user should be able to cycle back and forth between two
// pages by clicking on a ```PING!``` or ```PONG!``` link.

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="Bonus4", urlPatterns = "/order-summary")
public class Bonus4 extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        System.out.println(req.getParameter("name"));
        System.out.println(req.getParameter("quantity"));
    }
}
