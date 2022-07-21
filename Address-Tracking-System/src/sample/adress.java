package sample;
import java.io.Serializable;
import java.util.ArrayList;

public class adress implements Serializable {
    private static final long serialVersionUID = 1019347879368381765L;
    private String adressName;
    private String streetAdress;
    private String neighborhood;
    private String city;
    private String district;
    private boolean access=false;



    public adress(){

    }

    public adress(String name, String streetAdress, String neighborhood, String city, String district, boolean access) {
        this.adressName = name;
        this.streetAdress = streetAdress;
        this.neighborhood = neighborhood;
        this.city = city;
        this.district = district;
        this.access = access;
    }

    public String getName() {
        return adressName;
    }

    public void setName(String name) {
        this.adressName = name;
    }

    public String getStreetAdress() {
        return streetAdress;
    }

    public void setStreetAdress(String streetAdress) {
        this.streetAdress = streetAdress;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    public String getAdressName() {
        return adressName;
    }

    public void setAdressName(String adressName) {
        this.adressName = adressName;
    }

    @Override
    public String toString() {
        return this.adressName+" "+this.city+" "+this.neighborhood+" "+this.streetAdress+" "+this.district;
    }
}
