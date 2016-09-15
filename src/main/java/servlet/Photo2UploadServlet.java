package servlet;

import businessLogic.DBLink;
import businessLogic.Vehicle;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by MalindaK on 9/15/2016.
 */
public class Photo2UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Vehicle v=new Vehicle();

        try{
            String sTime = request.getParameter("time").substring(0,request.getParameter("time").length()-3).replace(',', ' ');
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            Date date = simpleDateFormat.parse(sTime);
            Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            v.setTime(formatter.format(date));
        }
        catch (ParseException ex){
            System.out.println("Exception "+ex);
        }

        v.setRegNo(request.getParameter("regNo"));
//        v.setBrand(request.getParameter("brand"));
//        v.setModel(request.getParameter("model"));
//        v.setYear(Integer.parseInt(request.getParameter("year")));
//        v.setMileage(Integer.parseInt(request.getParameter("millage")));
//        v.setTransmission(request.getParameter("transmission"));
//        v.setFuel(request.getParameter("fuel"));
//        v.setEngineCC(Integer.parseInt(request.getParameter("cc")));
//        v.setDescription(request.getParameter("desc"));
        v.setAdvertisementID(Integer.parseInt(request.getParameter("adID")));

        try {
//            v.setPhoto0(IOUtils.toInputStream(request.getParameter("img0"), "UTF-8"));
//            v.setPhoto1(IOUtils.toInputStream(request.getParameter("img1"), "UTF-8"));
            v.setPhoto2(IOUtils.toInputStream(request.getParameter("img2"), "UTF-8"));
            v.setPhoto3(IOUtils.toInputStream(request.getParameter("img3"), "UTF-8"));
//            v.setPhoto4(IOUtils.toInputStream(request.getParameter("img4"), "UTF-8"));
        }catch (Exception e){
            System.out.println("Exception "+e);
        }

        String email=request.getParameter("email");
        String pwd = request.getParameter("pwd");
        int adID = Integer.parseInt(request.getParameter("adID"));
        java.io.PrintWriter out = response.getWriter();

        if(DBLink.updateVehicle(v, adID, email, pwd)){
            //  out.println("?msg=Vehicle Added Successfully &#926; ");
        } else {
            out.println("?msg=Oops...,Unknown Error 222 Occured &#926;  ");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
