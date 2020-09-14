//3. Create a servlet that listens for POST requests to ```/order-summary``` and souts out the
// name of the product ordered by the user and the quantity. HINT: you will probably need to
// use the request object to get the parameters!

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="Bonus3", urlPatterns = "/order-summary")
public class Bonus3 extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        System.out.println(req.getParameter("name"));
        System.out.println(req.getParameter("quantity"));
    }
}
