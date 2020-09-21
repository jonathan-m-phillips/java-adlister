import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("name", "Jacob");
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("registeredUser");
        boolean validAttempt = username.equals(user.getUsername()) && password.equals(user.getPassword());
        boolean isAdmin = username.equals("admin") && password.equals("password");
        session.setAttribute("isAdmin", isAdmin);

        if (validAttempt) {
            session.setAttribute("name", user.getFirstName() + " " + user.getLastName());
            response.sendRedirect("/profile");
        } else if (isAdmin) {
            response.sendRedirect("/admin/portal");
        }
        else {
            response.sendRedirect("/login");
        }
    }
}
