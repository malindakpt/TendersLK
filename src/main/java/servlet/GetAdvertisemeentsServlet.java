package servlet;

import businessLogic.DBLink;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by MalindaK on 9/25/2016.
 */
public class GetAdvertisemeentsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        PrintWriter out = response.getWriter();
        try {
            String result = DBLink.getAdverrtisementList(email);
            out.print(result);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
