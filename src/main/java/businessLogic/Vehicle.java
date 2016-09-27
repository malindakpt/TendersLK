package businessLogic;

import java.io.InputStream;
import java.sql.Date;


/**
 * Created by MalindaK on 2/21/2016.
 */
public class Vehicle {

    private int ID;
    private String regNo;
    private String Brand;
    private String model;
    private int year;
    private String condition;
    private int mileage;
    private String bodyType;
    private String transmission;
    private String fuel;

    private String location;


    private int engineCC;
    private String description;

    private String time;

    private InputStream photo0;
    private InputStream photo1;
    private InputStream photo2;
    private InputStream photo3;
    private InputStream photo4;

    private InputStream smallPhoto0;
    private InputStream smallPhoto1;
    private InputStream smallPhoto2;
    private InputStream smallPhoto3;
    private InputStream smallPhoto4;

    private String htmlPhoto0;
    private String htmlPhoto1;
    private String htmlPhoto2;
    private String htmlPhoto3;
    private String htmlPhoto4;

    public InputStream getSmallPhoto1() {
        return smallPhoto1;
    }

    public void setSmallPhoto1(InputStream smallPhoto1) {
        this.smallPhoto1 = smallPhoto1;
    }

    public InputStream getSmallPhoto2() {
        return smallPhoto2;
    }

    public void setSmallPhoto2(InputStream smallPhoto2) {
        this.smallPhoto2 = smallPhoto2;
    }

    public InputStream getSmallPhoto4() {
        return smallPhoto4;
    }

    public void setSmallPhoto4(InputStream smallPhoto4) {
        this.smallPhoto4 = smallPhoto4;
    }

    public InputStream getSmallPhoto3() {
        return smallPhoto3;
    }

    public void setSmallPhoto3(InputStream smallPhoto3) {
        this.smallPhoto3 = smallPhoto3;
    }

    public InputStream getSmallPhoto0() {
        return smallPhoto0;
    }

    public void setSmallPhoto0(InputStream smallPhoto0) {
        this.smallPhoto0 = smallPhoto0;
    }

    private int advertisementID;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAdvertisementID() {
        return advertisementID;
    }

    public void setAdvertisementID(int advertisementID) {
        this.advertisementID = advertisementID;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public int getEngineCC() {
        return engineCC;
    }

    public void setEngineCC(int engineCC) {
        this.engineCC = engineCC;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InputStream getPhoto0() {
        return photo0;
    }

    public void setPhoto0(InputStream photo0) {
        this.photo0 = photo0;
    }

    public InputStream getPhoto1() {
        return photo1;
    }

    public void setPhoto1(InputStream photo1) {
        this.photo1 = photo1;
    }

    public InputStream getPhoto2() {
        return photo2;
    }

    public void setPhoto2(InputStream photo2) {
        this.photo2 = photo2;
    }

    public InputStream getPhoto3() {
        return photo3;
    }

    public void setPhoto3(InputStream photo3) {
        this.photo3 = photo3;
    }

    public InputStream getPhoto4() {
        return photo4;
    }

    public void setPhoto4(InputStream photo4) {
        this.photo4 = photo4;
    }

    public String getHtmlPhoto0() {
        return htmlPhoto0;
    }

    public void setHtmlPhoto0(String htmlPhoto0) {
        this.htmlPhoto0 = htmlPhoto0;
    }

    public String getHtmlPhoto1() {
        return htmlPhoto1;
    }

    public void setHtmlPhoto1(String htmlPhoto1) {
        this.htmlPhoto1 = htmlPhoto1;
    }

    public String getHtmlPhoto2() {
        return htmlPhoto2;
    }

    public void setHtmlPhoto2(String htmlPhoto2) {
        this.htmlPhoto2 = htmlPhoto2;
    }

    public String getHtmlPhoto3() {
        return htmlPhoto3;
    }

    public void setHtmlPhoto3(String htmlPhoto3) {
        this.htmlPhoto3 = htmlPhoto3;
    }

    public String getHtmlPhoto4() {
        return htmlPhoto4;
    }

    public void setHtmlPhoto4(String htmlPhoto4) {
        this.htmlPhoto4 = htmlPhoto4;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
