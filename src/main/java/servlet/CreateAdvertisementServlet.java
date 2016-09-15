package servlet; /**
 * Created by MalindaK on 2/21/2016.
 */
// Import required java libraries

import businessLogic.Advertisement;
import businessLogic.DBLink;
import businessLogic.Vehicle;
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

        try {
            Advertisement ad=new Advertisement();
            String topic = request.getParameter("topic");
            String expDate = request.getParameter("expDate");
            int inoVehi = Integer.parseInt(request.getParameter("noVehi"));
            String email = request.getParameter("email");
            String pwd = request.getParameter("pwd");

            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            String dateInString = expDate;
            Date date=null;
            try {

                date = formatter.parse(dateInString);
                System.out.println(date);
                System.out.println(formatter.format(date));

            } catch (ParseException e) {
                e.printStackTrace();
            }

            ad.setID(0);
            ad.setTopic(topic);
            ad.setCreateDate(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            ad.setExpDate(new java.sql.Date(date.getTime()));
            ad.setCustomer(email);
            ad.setPwd(pwd);
            ad.setMaxAds(inoVehi);

            DBLink.addAdvertisement(ad);
            //PrintWriter out = response.getWriter();
            //out.println(sImage);

            response.sendRedirect("http://localhost:8080?msg=Advertisement Created Successfully &#926;");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public String getStringVal( FileItem fi) throws IOException {
        DeferredFileOutputStream obj = (DeferredFileOutputStream) fi.getOutputStream();
        byte[] bos = obj.getData();
        String s =  new String(bos, "UTF-8");
        System.out.println("ee="+s);
        return s;
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        throw new ServletException("GET method used with " +
                getClass( ).getName( )+": POST method required.");
    }


}
