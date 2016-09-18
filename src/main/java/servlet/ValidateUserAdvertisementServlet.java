package servlet;

import businessLogic.DBLink;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by MalindaK on 7/28/2016.
 */
public class ValidateUserAdvertisementServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pwd = request.getParameter("password");
        String ad =  request.getParameter("adID");
        PrintWriter out = response.getWriter();

        if(!DBLink.validateUser(email,pwd)){
            out.println("Invalid Email or Password\n"+DBLink.errorMsg);
        }else if(!DBLink.validateAd(email,ad)){
            out.println("No Advertisement with ID:"+ad+" exist for "+email);
        }else{
            //Validated
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String ad =  request.getParameter("ad");
        PrintWriter out = response.getWriter();

        if(!DBLink.validateUser(email,pwd)){
            out.println("Invalid Email or Password");
        }else if(!DBLink.validateAd(email,ad)){
            out.println("No Advertisement with ID:"+ad+" exist for "+email);
        }else{
            //Validated
        }
    }
}
