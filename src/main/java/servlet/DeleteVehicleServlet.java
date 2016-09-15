package servlet;

import businessLogic.DBLink;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by MalindaK on 7/14/2016.
 */
public class DeleteVehicleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String vID = request.getParameter("vID");

        PrintWriter out = response.getWriter();

        if(DBLink.validateUser(email,password)){
            if(DBLink.deleteVehicle(vID)){
                out.print("1");
            }else{
                out.println("Vehicle already deleted !");
            }
        }else{
            out.println("Invalid Email or Password !");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
