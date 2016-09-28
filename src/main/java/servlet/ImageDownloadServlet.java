package servlet; /**
 * Created by MalindaK on 2/21/2016.
 */
// Import required java libraries

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
import java.util.Iterator;
import java.util.List;

public class ImageDownloadServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String img = request.getParameter("img");
            String smallImage=request.getParameter("small");
            int vID = Integer.parseInt(request.getParameter("vID"));
            String sImage;

            if(smallImage!=null){
                sImage = DBLink.getSmallImage(vID, img);
            }else{
                sImage = DBLink.getImage(vID, img);
            }
            PrintWriter out = response.getWriter();
            out.println(sImage);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
