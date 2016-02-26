package businessLogic;

import java.util.Date;
import java.util.List;

/**
 * Created by MalindaK on 2/25/2016.
 */
public class Advertisement {
    private int ID;
    private Date createDate;
    private Date expDate;
    private String  customer;
    private int maxAds;

    public void addVehicle(Vehicle v){
        DBLink.persistVehicle(v);
    }


}
