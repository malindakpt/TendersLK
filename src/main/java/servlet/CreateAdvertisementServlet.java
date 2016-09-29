package servlet; /**
 * Created by MalindaK on 2/21/2016.
 */
// Import required java libraries

import businessLogic.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.DeferredFileOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CreateAdvertisementServlet extends HttpServlet {


    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {


            Advertisement ad=new Advertisement();
            String topic = request.getParameter("topic");
            String expDate = request.getParameter("expDate");
            int inoVehi = Integer.parseInt(request.getParameter("noVehi"));
            String email = request.getParameter("email");
            String pwd = request.getParameter("pwd");
            String location = request.getParameter("location");

            try {
                location = location.substring(0, 7) + " class=map " + location.substring(7, location.length());
            }catch(Exception e){

            }
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateInString = expDate;
            Date date=null;
            date = formatter.parse(dateInString);

            ad.setID(0);
            ad.setTopic(topic);
            ad.setCreateDate(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            ad.setExpDate(new java.sql.Date(date.getTime()));
            ad.setCustomer(email);
            ad.setPwd(pwd);
            ad.setMaxAds(inoVehi);
            ad.setLocation(location);

            if(DBLink.addAdvertisement(ad)){
                EmailSender.sendEmail(Constants.EMAIL_AD_CREATED,email);
            }else{
                out.print(DBLink.errorMsg);
            }

        }catch (Exception e){
            e.printStackTrace();
            out.print("Unexpected error :"+DBLink.errorMsg);
        }
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        throw new ServletException("GET method used with " +
                getClass( ).getName( )+": POST method required.");
    }


}
