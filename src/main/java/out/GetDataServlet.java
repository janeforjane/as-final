package out;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GetDataServlet", urlPatterns = "/getDataServlet")
public class GetDataServlet extends HttpServlet {

    @EJB
    out.SelectBeanImpl selectBean;

    //TODO html for servlet

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String s1 = req.getParameter("city").trim();


        try {

            if (s1 == null) {
                ArrayList<String> stringArrayList = selectBean.getList();
                req.setAttribute("stringArrayList", stringArrayList);

                this.getServletContext().getRequestDispatcher("/returnAllStrings.jsp").forward(req, resp); //TODO jsp

            } else {
                ArrayList<String> stringArrayFilterList = selectBean.getFilterList(s1);
                req.setAttribute("stringArrayFilterList", stringArrayFilterList);

                this.getServletContext().getRequestDispatcher("/returnFilterStrings.jsp").forward(req, resp); //TODO jsp

            }

        }catch (Exception e) {

            e.printStackTrace();
        }
    }
}
