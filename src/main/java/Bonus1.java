//1. Create a servlet that returns your first and last name in a heading element to the user if navigating to ```/name```.

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="Bonus1", urlPatterns = "/name")
public class Bonus1 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String firstName = req.getParameter("first");
        String lastName = req.getParameter("last");

        if (firstName == null && lastName == null) {
            firstName = "John";
            lastName = "Doe";
        }

        out.println("<h1>" + firstName + " " + lastName + "</h1>");

    }
}