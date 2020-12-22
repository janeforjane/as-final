package in;

import javax.ejb.EJB;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EnterDataServlet", urlPatterns = "/enterDataServlet")
public class EnterDataServlet extends HttpServlet {

    @EJB
    in.UpdateBeanImpl updateBean;

    @PersistenceUnit(unitName = "input-message")
    private EntityManagerFactory entityManagerFactory; // need for db

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String s1 = req.getParameter("city");
        String s2 = req.getParameter("population");


        if (isInt(s2) && s1 != null) {

            int i2 = Integer.parseInt(s2);

            updateBean.saveNew(s1, i2);

            req.setAttribute("string", s1);

            this.getServletContext().getRequestDispatcher("/returnResultOfEnterData.jsp").forward(req, resp); //TODO jsp

        }else {
            System.out.println("не число - кыш кыш");
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
