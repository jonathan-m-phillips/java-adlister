import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="Admin", urlPatterns = "/admin/portal")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        boolean isAdmin = (boolean) session.getAttribute("isAdmin");
        if (isAdmin) {
            req.getRequestDispatcher("/WEB-INF/admin.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/profile.jsp").forward(req, resp);
        }
    }
}
