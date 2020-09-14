//2. Create a servlet that returns a simple form if the user navigates to ```/order-form```.
// In servering up HTML, you may need to include ```response.setHeader("content-type", "text/html");```.
// The form should include an input for the name of a product and an input for how many of the product
// they want to order. The method of the form should be ```POST``` and the action should be ```/order-summary```.

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="Bonus2", urlPatterns = "/order-form")
public class Bonus2 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setHeader("content-type","text/html");
        PrintWriter out = res.getWriter();

        out.println("<form>\n" +
                "  <label for=\"fname\">name of product:</label><br>\n" +
                "  <input type=\"text\" id=\"fname\" name=\"fname\"><br>\n" +
                "  <label for=\"lname\">amount:</label><br>\n" +
                "  <input type=\"text\" id=\"lname\" name=\"lname\">\n" +
                "  <br><input type=\"submit\" value=\"Submit\">" +
                "</form>");
    }
}