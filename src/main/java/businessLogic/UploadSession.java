package businessLogic;

import java.io.InputStream;

/**
 * Created by MalindaK on 2/25/2016.
 */
public class UploadSession {

    private Advertisement advertisement;

    private InputStream photo0;
    private InputStream photo1;
    private InputStream photo2;
    private InputStream photo3;
    private InputStream photo4;

    private Customer customer;

    public void startNewSession(){

    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
