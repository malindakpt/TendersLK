package servlet;

import businessLogic.DBLink;
import businessLogic.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by MalindaK on 9/8/2016.
 */
public class StartAddVehicleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String ad =  request.getParameter("adID");
        int adID=Integer.parseInt(request.getParameter("adID"));
        PrintWriter out = response.getWriter();

        if(!DBLink.validateUser(email, pwd)){
            out.println("Invalid Email or Password");
        }else if(!DBLink.validateAd(email,ad)){
            out.println("No Advertisement with ID:"+ad+" exist for "+email);
        }else{
            //Validated
            Vehicle v=new Vehicle();

            if(DBLink.addVehicle(v,adID,email,pwd)){
               // out.println("Vehicle Adding started");
            }else{
                out.println("Unknown Error");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
