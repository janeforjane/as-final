package in;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoveDataServlet", urlPatterns = "/removeDataServlet")
public class RemoveDataServlet extends HttpServlet {

    @EJB
    in.UpdateBeanImpl updateBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s1 = req.getParameter("city");

        if (s1 != null) {

            updateBean.remove(s1);

            req.setAttribute("string", s1);

            this.getServletContext().getRequestDispatcher("/returnResultOfRemove.jsp").forward(req, resp); //TODO jsp

        }else {
            System.out.println("строка пустая");
        }

    }
    public static boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
