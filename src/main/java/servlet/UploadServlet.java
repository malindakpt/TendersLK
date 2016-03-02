package servlet; /**
 * Created by MalindaK on 2/21/2016.
 */
// Import required java libraries
import java.io.*;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.DBLink;
import businessLogic.MySQLAccess;
import businessLogic.Vehicle;
import com.sun.xml.internal.messaging.saaj.util.Base64;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
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
        // Check that we have a file upload request
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
        // maximum size that will be stored in memory
        factory.setSizeThreshold(maxMemSize);
        // Location to save data that is larger than maxMemSize.
        factory.setRepository(new File("c:\\temp"));

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // maximum file size to be uploaded.
        upload.setSizeMax( maxFileSize );

        try{
            // Parse the request to get file items.
            List fileItems = upload.parseRequest(request);

            // Process the uploaded file items
            Iterator i = fileItems.iterator();

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
                    String fileName = fi.getName();
                    String contentType = fi.getContentType();
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();

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
                   }

                    //deserialize(fi.getInputStream());
                    out.println("Uploaded Filename: " + fieldName + "<br>");
                }
            }
            out.println("</body>");
            out.println("</html>");
            DBLink.addVehicle(v);
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
//
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, java.io.IOException {

        throw new ServletException("GET method used with " +
                getClass( ).getName( )+": POST method required.");
    }


    private static void deserialize(InputStream fileIn){
        try
        {
       //     FileInputStream fileIn = new FileInputStream(file);
       //     ObjectInputStream in = new ObjectInputStream(fileIn);

            MySQLAccess dao = new MySQLAccess();
            dao.readDataBase(fileIn);
            System.out.println(fileIn.toString());
            fileIn.close();
           // fileIn.close();

        }catch(Exception c)
        {
            c.printStackTrace();
            return;
        }
    }

}
