package businessLogic;

import java.util.List;
import java.sql.Date;

/**
 * Created by MalindaK on 2/25/2016.
 */
public class Advertisement {
    private int ID;
    private String topic;
    private Date createDate;
    private Date expDate;
    private String  customer;
    private String pwd;
    private int maxAds;
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getMaxAds() {
        return maxAds;
    }

    public void setMaxAds(int maxAds) {
        this.maxAds = maxAds;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
