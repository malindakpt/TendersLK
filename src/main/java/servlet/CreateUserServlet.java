package servlet;

import businessLogic.*;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

/**
 * Created by MalindaK on 7/13/2016.
 */
public class CreateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Customer customer=new Customer();
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String pwd1 =  request.getParameter("pwd1");
            String pwd2 = request.getParameter("pwd2");
            Date createDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());

            customer.setEmail(email);
            customer.setPhone(phone);
            customer.setPassword(pwd1);
            customer.setCreateDate((java.sql.Date) createDate);

            PrintWriter out = response.getWriter();

            if(!customer.validateCustomer(pwd2)){
                out.println("Password mismatch");
            }
            else if(isEmpty(customer)!=""){
                out.println(isEmpty(customer));
            }
            else if(!DBLink.addCustomer(customer)){
                out.println(DBLink.errorMsg);
            }else{
                //Customer added successfully





                Thread t = new Thread() {
                    public void run() {
                        try {
                            String subject = null,text = null;
                            String to="malindakpt@gmail.com";
                            subject="Voction account create";
                            text="Hi, your acc will be activated by 1 hr";

                            String from = "voction@yahoo.com";
                            String pass ="Vkpt@16709";
                            String host = "smtp.mail.yahoo.com";

                            Properties properties = System.getProperties();
                            properties.put("mail.smtp.user", from);
                            properties.put("mail.smtp.password", pass);

                            properties.put("mail.smtp.auth", "true");
                            properties.put("mail.smtp.starttls.enable", "true");
                            properties.put("mail.smtp.host", host);
                            properties.put("mail.smtp.port", "587");
                            Session session = Session.getInstance(properties);
                            System.out.println("DOne");
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                    }
                };
                t.start();

                System.out.println("DOOOOO");



            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("as");
    }

    private String isEmpty(Customer customer){
       if(customer.getEmail()==""){
           return "Email address cannot be empty";
       }else if(customer.getPhone()==""){
           return "Phone number cannot be empty";
       }else if(customer.getEmail()==""){
           return "Password cannot be empty";
       }else if(customer.getPassword().length()<4){
           return "Password length must be grater than 4";
       }else{
           return "";
       }
    }
}
