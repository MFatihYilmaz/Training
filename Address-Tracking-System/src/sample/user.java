package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class user extends adress implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    public static user currentUser ;
    private String ID;
    private String name;
    private String secondName;
    private int age;
    private String password ;
    private boolean access;

    public static user getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(user currentUser) {
        user.currentUser = currentUser;
    }

    public user(String name, String secondName, int age, String password, String adressName, String streetAdress, String neighnorhood, String city, String district, boolean accsess) {
        super(adressName,streetAdress,neighnorhood,city,district,accsess);
        this.name = name;
        this.secondName = secondName;
        this.age = age;
        this.ID=geerateID();
        this.password=password;
        this.access=accsess;

    }



    public boolean getAccess() {
        return access;
    }


    public void setAccess(boolean access) {
        this.access = access;
    }

    public static String geerateID(){

        String ID = "";

        // ID bulma
        for(int i = 0 ; i<11 ;i++){
            int random_int = (int)Math.floor(Math.random()*(9-0+1)+0);

            ID=ID.concat(String.valueOf(random_int));
        }

        // databaseyi çağırma
        ArrayList<user> dataBase = databaseController.getDatabase();

        // daha önce kullanılmışmı kontrol et
        int counter = 0 ;
        for (user currentUser :dataBase){
            if (currentUser.ID.equals(ID))
                counter++;
        }


        // kullanılmışsa fonksiyonu tekrar çağır kullanılmamışsa ID'yi döndür
        if (counter==0){
            return String.valueOf(ID);
        }else {
            geerateID();
        }

        return "";
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID){
        this.ID=ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: "+this.name+"\nLast Name: "+this.secondName+"\nAge: "+this.age+"\nID: "+this.ID +"\n"+super.toString();
    }
}
