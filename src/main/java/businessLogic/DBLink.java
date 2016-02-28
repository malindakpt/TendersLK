package businessLogic;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.sql.*;

/**
 * Created by MalindaK on 2/25/2016.
 */
public class DBLink {

    private  static Connection connect = null;
    private  static Statement statement = null;
    private  static PreparedStatement preparedStatement = null;
    private  static ResultSet resultSet = null;

    public static Vehicle getAdvertisement(){
        Vehicle v=new Vehicle();
        v.setRegNo("415955");
        v.setBrand("TOYOTA");
        v.setModel("Camry");
        v.setYear("2012");
        v.setCondition("Brand New");
        v.setMileage(24500);
        v.setBodyType("Closed");
        v.setTransmission("Automatic");
        v.setFuel("Petrol");
        v.setEngineCC("2500.00 CC");
        v.setDescription("sdfsdf");


        return v;

    }

    public static void persistVehicle(Vehicle v){

    }

    public static void addVehicle(Vehicle v){
        try {

            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/tenders?"
                            + "user=root&password=");

            preparedStatement = connect
                    .prepareStatement("insert into  vehicles values ( ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            preparedStatement.setInt(1, v.getID());
            preparedStatement.setString(2, v.getRegNo());
            preparedStatement.setString(3, v.getBrand());
            preparedStatement.setString(4, v.getModel());
            preparedStatement.setString(5, v.getYear());
            preparedStatement.setString(6, v.getCondition());
            preparedStatement.setInt(7,v.getMileage());
            preparedStatement.setString(8, v.getBodyType());
            preparedStatement.setString(9, v.getTransmission());
            preparedStatement.setString(10, v.getFuel());
            preparedStatement.setString(11, v.getEngineCC());
            preparedStatement.setString(12, v.getDescription());

            preparedStatement.setBlob(13, v.getPhoto0());
            preparedStatement.setBlob(14,v.getPhoto1());
            preparedStatement.setBlob(15,v.getPhoto2());
            preparedStatement.setBlob(16,v.getPhoto3());
            preparedStatement.setBlob(17,v.getPhoto4());
            preparedStatement.setInt(18, v.getAdvertisementID());
            preparedStatement.executeUpdate();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Vehicle getVehicle() throws SQLException {

        resultSet = statement
                .executeQuery("select * from adds");
        while (resultSet.next()) {

            Vehicle v = new Vehicle();

            v.setID(resultSet.getInt("ID"));
            v.setRegNo(resultSet.getString("RegNo"));
            v.setBrand(resultSet.getString("Brand"));
            v.setModel(resultSet.getString("Model"));
            v.setYear(resultSet.getString("Year"));
            v.setCondition(resultSet.getString("Condition"));
            v.setMileage(resultSet.getInt("Millage"));
            v.setBodyType(resultSet.getString("BodyType"));
            v.setTransmission(resultSet.getString("Transmission"));
            v.setFuel(resultSet.getString("Fuel"));
            v.setEngineCC(resultSet.getString("Engine"));
            v.setDescription(resultSet.getString("Description"));

            v.setHtmlPhoto0(Base64.encode(resultSet.getBytes("Photo0")));
            v.setHtmlPhoto1(Base64.encode(resultSet.getBytes("Photo1")));
            v.setHtmlPhoto2(Base64.encode(resultSet.getBytes("Photo2")));
            v.setHtmlPhoto3(Base64.encode(resultSet.getBytes("Photo3")));
            v.setHtmlPhoto4(Base64.encode(resultSet.getBytes("Photo4")));

            v.setAdvertisementID(resultSet.getInt("AdvertisementID"));

            return v;
        }

        return null;
    }


}
