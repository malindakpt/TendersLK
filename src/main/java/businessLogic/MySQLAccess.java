package businessLogic;

/**
 * Created by MalindaK on 2/24/2016.
 */
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.apache.commons.fileupload.FileItem;

import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Arrays;



public class MySQLAccess {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase(InputStream is) throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/tenders?"
                            + "user=root&password=");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from adds");
            writeResultSet(resultSet);

            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect
                    .prepareStatement("insert into  adds values ( ?, ?)");
            // "myuser, webpage, datum, summery, COMMENTS from feedback.comments");
            // Parameters start with 1
            preparedStatement.setString(1, "Test5");
            preparedStatement.setBlob(2, is);
//            preparedStatement.setString(3, "TestWebpage");
//            preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
//            preparedStatement.setString(5, "TestSummary");
//            preparedStatement.setString(6, "TestComment");
            preparedStatement.executeUpdate();

            preparedStatement = connect
                    .prepareStatement("SELECT * from adds");
            resultSet = preparedStatement.executeQuery();
            writeResultSet(resultSet);

            // Remove again the insert comment
//            preparedStatement = connect
//                    .prepareStatement("delete from adds where name= ? ; ");
//            preparedStatement.setString(1, "Test");
//            preparedStatement.executeUpdate();
//
//            resultSet = statement
//                    .executeQuery("select * from adds");
//            writeMetaData(resultSet);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //   Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String user = resultSet.getString("name");
            byte[] img = resultSet.getBytes("image");
            String base64String = Base64.encode(img);
//            String summery = resultSet.getString("summery");
//            Date date = resultSet.getDate("datum");
//            String comment = resultSet.getString("comments");
            System.out.println("User: " + user);


            System.out.println(base64String);

            break;

            //System.out.println("Image: " + img);


//            try {
//                PrintWriter writer = new PrintWriter("D:\\acc.PNG", "UTF-8");
//                writer.println(img);
//                writer.close();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            BLOB blob = (BLOB) cstmt.getBlob(3);
//            OutputStream os = blob.getBinaryOutputStream();
//            ObjectOutputStream oop = new ObjectOutputStream(os);
//            oop.writeObject(list);
//            oop.flush();
//            oop.close();
//            os.close();
//            System.out.println("Summery: " + summery);
//            System.out.println("Date: " + date);
//            System.out.println("Comment: " + comment);
        }
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}
