package businessLogic;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by MalindaK on 2/25/2016.
 */
public class DBLink {

    public  static StringBuilder errorMsg = new StringBuilder();
    private static DBLink dbLink=null;
    private  static Connection connect = null;
    private  static Statement statement = null;
    private  static PreparedStatement preparedStatement = null;
    private  static ResultSet resultSet = null;

    public static Connection getConnection(){
        errorMsg = new StringBuilder();
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/tenders?" + "user=root&password=");
           // return DriverManager.getConnection("jdbc:mysql://127.7.45.130:3306/voction?" + "user=adminV5y9umD&password=J8etWW3ma6fB");
        } catch (SQLException e)
        {
            errorMsg.append(e.getMessage());
            return null;
        }
    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = getConnection();
        }catch (Exception e){
            errorMsg.append(e.getMessage());
            e.printStackTrace();
        }
    }

    public static boolean validateUser(String email,String pwd){

        try {
            connect = getConnection();
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from customers where email='" + email+"' and password='"+pwd+"'");

            if (resultSet.next()) {
                return true;
            }
        }catch (Exception e){
            errorMsg.append(e.getMessage());
            return false;
        }
        return false;
    }

    public static boolean validateAd(String email,String ad){

        try {
            connect = getConnection();
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from ads where userID='" + email+"' and ID='"+ad+"'");

            if (resultSet.next()) {
                return true;
            }
        }catch (Exception e){
            errorMsg.append(e.getMessage());
            return false;
        }
        return false;
    }

    public static boolean deleteVehicle(String ID){

        try {
            connect = getConnection();
            statement = connect.createStatement();
            statement.executeUpdate("DELETE FROM vehicles WHERE ID="+ID);

        }catch (Exception e){
            errorMsg.append(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean addVehicle(Vehicle v, int adID, String email, String pwd){

        if(!validateUser(email,pwd)){
           return false;
        }
        try {
            statement=connect.createStatement();
            connect = getConnection();
            preparedStatement = connect
                    .prepareStatement("insert into  vehicles values ( ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            preparedStatement.setInt(1, v.getID());
            preparedStatement.setString(2, v.getRegNo());
            preparedStatement.setString(3, v.getBrand());
            preparedStatement.setString(4, v.getModel());
            preparedStatement.setInt(5, v.getYear());
            preparedStatement.setString(6, v.getCondition());
            preparedStatement.setInt(7, v.getMileage());
            preparedStatement.setString(8, v.getBodyType());
            preparedStatement.setString(9, v.getTransmission());
            preparedStatement.setString(10, v.getFuel());
            preparedStatement.setInt(11, v.getEngineCC());
            preparedStatement.setString(12, v.getDescription());

            preparedStatement.setBlob(13, v.getPhoto0());
            preparedStatement.setBlob(14,v.getPhoto1());
            preparedStatement.setBlob(15,v.getPhoto2());
            preparedStatement.setBlob(16,v.getPhoto3());
            preparedStatement.setBlob(17, v.getPhoto4());
            preparedStatement.setInt(18, v.getAdvertisementID());
            preparedStatement.executeUpdate();
            //connect.close();



            return true;
        }catch (Exception e){
            errorMsg.append(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static boolean addCustomer(Customer customer){

        try {
            statement=connect.createStatement();
            connect = getConnection();
            preparedStatement = connect
                    .prepareStatement("insert into customers values ( ?,?,?,?,?)");

            preparedStatement.setString(1, customer.getEmail());
            preparedStatement.setString(2, customer.getPassword());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setDate(4, customer.getCreateDate());
            preparedStatement.setBoolean(5, true);

            preparedStatement.executeUpdate();
            return true;
            // connect.close();
        }catch (Exception e){
            errorMsg.append(e.getMessage());
          //  e.printStackTrace();
            return false;
        }

    }


    public static void addAdvertisement(Advertisement adv){

        if(!validateUser(adv.getCustomer(),adv.getPwd())){
            return;
        }

        try {
            statement=connect.createStatement();
            connect = getConnection();
            preparedStatement = connect
                    .prepareStatement("insert into ads values ( ?,?,?,?,?,?)");

            preparedStatement.setInt(1, adv.getID());
            preparedStatement.setString(2, adv.getTopic());
            preparedStatement.setDate(3, adv.getCreateDate());
            preparedStatement.setDate(4, adv.getExpDate());
            preparedStatement.setInt(5, adv.getMaxAds());
            preparedStatement.setString(6, adv.getCustomer());

            preparedStatement.executeUpdate();
           // connect.close();
        }catch (Exception e){
            errorMsg.append(e.getMessage());
            e.printStackTrace();
        }

    }

    public static Vehicle getVehicle(int vID) throws SQLException {
        Vehicle v = new Vehicle();
        connect = getConnection();
        statement=connect.createStatement();
        resultSet = statement.executeQuery("select * from vehicles where ID=" + vID);

        while (resultSet.next()) {

            v.setID(resultSet.getInt("ID"));

            v.setHtmlPhoto0(Base64.encode(resultSet.getBytes("Photo0")));
            v.setHtmlPhoto1(Base64.encode(resultSet.getBytes("Photo1")));
            v.setRegNo(resultSet.getString("RegNo"));
            v.setBrand(resultSet.getString("Brand"));
            v.setModel(resultSet.getString("Model"));
            v.setYear(resultSet.getInt("Year"));
            v.setCondition(resultSet.getString("Condition"));
            v.setMileage(resultSet.getInt("Millage"));
            v.setBodyType(resultSet.getString("BodyType"));
            v.setTransmission(resultSet.getString("Transmission"));
            v.setFuel(resultSet.getString("Fuel"));
            v.setEngineCC(resultSet.getInt("Engine"));
            v.setDescription(resultSet.getString("Description"));
            v.setHtmlPhoto2(Base64.encode(resultSet.getBytes("Photo2")));
            v.setHtmlPhoto3(Base64.encode(resultSet.getBytes("Photo3")));
            v.setHtmlPhoto4(Base64.encode(resultSet.getBytes("Photo4")));

            v.setAdvertisementID(resultSet.getInt("AdvertisementID"));

        }

        return v;
    }


    public static String getImage(int vehicleID,String img) throws SQLException {
        String attribute="Photo"+img;
        String imageS=null;
        connect = getConnection();
        statement=connect.createStatement();
        resultSet = statement.executeQuery("select "+attribute+" from vehicles where ID="+vehicleID);
        while (resultSet.next()) {
           // imageS = Base64.encode(resultSet.getBytes(attribute));
            imageS = resultSet.getString(attribute);
        }
        return imageS;
    }

    public static List<Vehicle> getAdVehicles(String addID) throws SQLException {

        List<Vehicle> list=new ArrayList<Vehicle>();

        if("".equals(addID) || addID==null){
            return list;
        }
        connect = getConnection();
        statement=connect.createStatement();
        resultSet = statement.executeQuery("select * from vehicles where AdvertisementID=" + addID);

        while (resultSet.next()) {
            Vehicle v = new Vehicle();
            v.setID(resultSet.getInt("ID"));
            v.setRegNo(resultSet.getString("RegNo"));
            v.setBrand(resultSet.getString("Brand"));
            v.setModel(resultSet.getString("Model"));
            v.setYear(resultSet.getInt("Year"));
            v.setCondition(resultSet.getString("Condition"));
            v.setMileage(resultSet.getInt("Millage"));
            v.setBodyType(resultSet.getString("BodyType"));
            v.setTransmission(resultSet.getString("Transmission"));
            v.setFuel(resultSet.getString("Fuel"));
            v.setEngineCC(resultSet.getInt("Engine"));
            v.setDescription(resultSet.getString("Description"));

            v.setHtmlPhoto0(Base64.encode(resultSet.getBytes("Photo0")));
            v.setHtmlPhoto1(Base64.encode(resultSet.getBytes("Photo1")));
            v.setHtmlPhoto2(Base64.encode(resultSet.getBytes("Photo2")));
            v.setHtmlPhoto3(Base64.encode(resultSet.getBytes("Photo3")));
            v.setHtmlPhoto4(Base64.encode(resultSet.getBytes("Photo4")));

            v.setAdvertisementID(resultSet.getInt("AdvertisementID"));

            list.add(v);
        }
//        connect.close();
        return list;
    }
}
