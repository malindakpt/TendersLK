package businessLogic;

import java.io.InputStream;

/**
 * Created by MalindaK on 2/21/2016.
 */
public class Vehicle {
    private String regNo;
    private String Brand;
    private String model;
    private String year;
    private String condition;
    private int mileage;
    private String bodyType;
    private String transmission;
    private String fuel;
    private String engineCC;
    private String description;

    private InputStream photo0;
    private InputStream photo1;
    private InputStream photo2;
    private InputStream photo3;
    private InputStream photo4;

    private int advertisementID;


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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
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

    public String getEngineCC() {
        return engineCC;
    }

    public void setEngineCC(String engineCC) {
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
}
