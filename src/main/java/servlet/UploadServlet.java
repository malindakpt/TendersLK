package servlet; /**
 * Created by MalindaK on 2/21/2016.
 */
// Import required java libraries
import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.DBLink;
import businessLogic.Vehicle;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;

public class UploadServlet extends HttpServlet {

    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 15000 * 1024;
    private int maxMemSize = 150000 * 1024;
    private File file ;

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
//                    String fileName = fi.getName();
//                    String contentType = fi.getContentType();
//                    boolean isInMemory = fi.isInMemory();
//                    long sizeInBytes = fi.getSize();



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
                       v.setPhoto0(fi.getInputStream());
                   }else if(fieldName.equals("file1")){
                       v.setPhoto1(fi.getInputStream());
                   }else if(fieldName.equals("file2")){
                       v.setPhoto2(fi.getInputStream());
                   }else if(fieldName.equals("file3")){
                       v.setPhoto3(fi.getInputStream());
                   }else if(fieldName.equals("file4")){
                       v.setPhoto4(fi.getInputStream());
                   }else if(fieldName.equals("adID")){
                       adID=Integer.parseInt(getStringVal(fi));
                   }else if(fieldName.equals("email")){
                       email=getStringVal(fi);
                   }else if(fieldName.equals("password")){
                       pwd=getStringVal(fi);
                   }

                    out.println("Uploaded Filename: " + fieldName + "<br>");
                }
            }
            out.println("</body>");
            out.println("</html>");
            DBLink.addVehicle(v,adID,email,pwd);
        }catch(Exception ex) {
            System.out.println(ex);
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
            throws ServletException, java.io.IOException {

        throw new ServletException("GET method used with " +
                getClass( ).getName( )+": POST method required.");
    }


}
