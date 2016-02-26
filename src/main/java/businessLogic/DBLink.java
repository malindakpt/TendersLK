package businessLogic;

/**
 * Created by MalindaK on 2/25/2016.
 */
public class DBLink {
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
}
