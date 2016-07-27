package servlet; /**
 * Created by MalindaK on 2/21/2016.
 */
// Import required java libraries
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
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
import org.apache.commons.io.output.*;

public class UploadServlet extends HttpServlet {

    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 300000000;
    private int maxMemSize =  300000000;
    private File file ;
    private static final int IMG_WIDTH = 100;
    private static final int IMG_HEIGHT = 100;

    public void init( ){
        // Get the file location where it would be stored.
        filePath =
                getServletContext().getInitParameter("file-upload");
    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, java.io.IOException {
        Vehicle v=new Vehicle();
        isMultipart = ServletFileUpload.isMultipartContent(request);
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter( );
        if( !isMultipart ){
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>No file uploaded</p>");
            out.println("</body>");
            out.println("</html>");
            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(maxMemSize);
        factory.setRepository(new File("c:\\temp"));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax( maxFileSize );
        try{
            List fileItems = upload.parseRequest(request);
            Iterator i = fileItems.iterator();

            int adID=0;
            String email=null;
            String pwd = null;


            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");
            out.println("</head>");
            out.println("<body>");
            while ( i.hasNext () )
            {
                FileItem fi = (FileItem)i.next();
                {
                    // Get the uploaded file parameters
                    String fieldName = fi.getFieldName();
                    String originalName = fi.getName();
                    System.out.println();
                   if(fieldName.equals("regNo")){
                       v.setRegNo(getStringVal(fi));
                   }else if(fieldName.equals("brand")){
                        v.setBrand(getStringVal(fi));
                   }else if(fieldName.equals("model")){
                       v.setModel(getStringVal(fi));
                   }else if(fieldName.equals("manufac")){
                       v.setYear(Integer.parseInt(getStringVal(fi)));
                   }else if(fieldName.equals("condition")){
                       v.setCondition(getStringVal(fi));
                   }else if(fieldName.equals("millage")){
                       v.setMileage(Integer.parseInt(getStringVal(fi)));
                   }else if(fieldName.equals("bodyType")){
                       v.setBodyType(getStringVal(fi));
                   }else if(fieldName.equals("transmission")){
                       v.setTransmission(getStringVal(fi));
                   }else if(fieldName.equals("fuel")){
                       v.setFuel(getStringVal(fi));
                   }else if(fieldName.equals("engineCC")){
                       v.setEngineCC(Integer.parseInt(getStringVal(fi)));
                   }else if(fieldName.equals("desc")){
                       v.setDescription(getStringVal(fi));
                   }else if(fieldName.equals("file0")){
                       v.setPhoto0(FileResizer.resize(fi.getInputStream(), fi.getName()));
                   }else if(fieldName.equals("file1")){
                       v.setPhoto1(FileResizer.resize(fi.getInputStream(), fi.getName()));
                   }else if(fieldName.equals("file2")){
                       v.setPhoto2(FileResizer.resize(fi.getInputStream(), fi.getName()));
                   }else if(fieldName.equals("file3")){
                       v.setPhoto3(FileResizer.resize(fi.getInputStream(), fi.getName()));
                   }else if(fieldName.equals("file4")){
                       v.setPhoto4(FileResizer.resize(fi.getInputStream(), fi.getName()));
                   }else if(fieldName.equals("adID")){
                       v.setAdvertisementID(Integer.parseInt(getStringVal(fi)));
                   }else if(fieldName.equals("email")){
                       email=getStringVal(fi);
                   }else if(fieldName.equals("password")){
                       pwd=getStringVal(fi);
                   }

                }
            }
            out.println("</body>");
            out.println("</html>");

            if(DBLink.addVehicle(v,adID,email,pwd)){
                response.sendRedirect("http://localhost:8080?msg=Vehicle Added Successfully &#926;");
            }else{
                response.sendRedirect("http://localhost:8080?msg=Sorry, Error Occured &#926;");
            }
        }catch(Exception ex) {
            System.out.println(ex);
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
