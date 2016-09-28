package servlet; /**
 * Created by MalindaK on 2/21/2016.
 */
// Import required java libraries
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.DBLink;
import businessLogic.FileResizer;
import businessLogic.Vehicle;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.*;

public class UploadServlet extends HttpServlet {

    private static final int IMG_WIDTH = 100;
    private static final int IMG_HEIGHT = 100;

    public void init( ){
        // Get the file location where it would be stored.
    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, java.io.IOException {
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
        v.setBrand(request.getParameter("brand"));
        v.setModel(request.getParameter("model"));
        v.setYear(Integer.parseInt(request.getParameter("year")));
        v.setMileage(Integer.parseInt(request.getParameter("millage")));
        v.setTransmission(request.getParameter("transmission"));
        v.setFuel(request.getParameter("fuel"));
        v.setEngineCC(Integer.parseInt(request.getParameter("cc")));
        v.setDescription(request.getParameter("desc"));
        v.setAdvertisementID(Integer.parseInt(request.getParameter("adID")));

        try {
            v.setPhoto0(IOUtils.toInputStream(request.getParameter("img0"), "UTF-8"));
            v.setPhoto1(IOUtils.toInputStream(request.getParameter("img1"), "UTF-8"));
            v.setPhoto2(IOUtils.toInputStream(request.getParameter("img2"), "UTF-8"));
            v.setPhoto3(IOUtils.toInputStream(request.getParameter("img3"), "UTF-8"));
            v.setPhoto4(IOUtils.toInputStream(request.getParameter("img4"), "UTF-8"));
        }catch (Exception e){
            System.out.println("Exception "+e);
        }
        String email=request.getParameter("email");
        String pwd = request.getParameter("pwd");
        int adID=Integer.parseInt(request.getParameter("adID"));
        java.io.PrintWriter out = response.getWriter( );


            if(DBLink.addVehicle(v,adID,email,pwd)){
              //  out.println("?msg=Vehicle Added Successfully &#926; ");
            } else {
                out.println("?msg=Oops...,Unknown Error Occured &#926;  ");
            }

    }



    public String getStringVal( FileItem fi) throws IOException {
        DeferredFileOutputStream obj = (DeferredFileOutputStream) fi.getOutputStream();
        byte[] bos = obj.getData();
        String s =  new String(bos, "UTF-8");
        System.out.println("ee=" + s);
        return s;
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, java.io.IOException {

        throw new ServletException("GET method used with " +
                getClass( ).getName( )+": POST method required.");
    }

    public static void resizeImage(){
        try{

            BufferedImage originalImage = ImageIO.read(new File("c:\\image\\mkyong.jpg"));
            int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

            BufferedImage resizeImageJpg = resizeImage(originalImage, type);
            ImageIO.write(resizeImageJpg, "jpg", new File("c:\\image\\mkyong_jpg.jpg"));

            BufferedImage resizeImagePng = resizeImage(originalImage, type);
            ImageIO.write(resizeImagePng, "png", new File("c:\\image\\mkyong_png.jpg"));

            BufferedImage resizeImageHintJpg = resizeImageWithHint(originalImage, type);
            ImageIO.write(resizeImageHintJpg, "jpg", new File("c:\\image\\mkyong_hint_jpg.jpg"));

            BufferedImage resizeImageHintPng = resizeImageWithHint(originalImage, type);
            ImageIO.write(resizeImageHintPng, "png", new File("c:\\image\\mkyong_hint_png.jpg"));

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    private static BufferedImage resizeImage(BufferedImage originalImage, int type){
        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();

        return resizedImage;
    }

    private static BufferedImage resizeImageWithHint(BufferedImage originalImage, int type){

        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();
        g.setComposite(AlphaComposite.Src);

        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        return resizedImage;
    }

}
