package businessLogic;


import java.sql.Date;

/**
 * Created by MalindaK on 2/25/2016.
 */
public class Customer {
    private int ID;
    private String password;
    private String email;
    private String phone;
    private Date createDate;
    private Boolean enabled;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.sql.Date createDate) {
        this.createDate = createDate;
    }

    public Boolean validateCustomer(String pw2){
        if(!getPassword().equals(pw2)){
            return false;
        }
        return true;
    }
}
