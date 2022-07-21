package sample;

import java.io.*;
import java.util.ArrayList;

public class databaseController {

    public static ArrayList<user> getDatabase(){

        ArrayList<user> innerDatabase = new ArrayList<>();

        try{

            FileInputStream fis = new FileInputStream("database.dat");

            ObjectInputStream ois = new ObjectInputStream(fis);


            while (fis.available()>0){
                innerDatabase.add((user) ois.readObject());
            }

            ois.close();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return innerDatabase;
    }





    public static void setDatabase(ArrayList<user> newDatabase){
        try {

            FileOutputStream fos = new FileOutputStream("database.dat");

            ObjectOutputStream oos = new ObjectOutputStream(fos);


            for (user currentUser :newDatabase)
                oos.writeObject(currentUser);

            oos.close();


        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }





    public static void changeUser(user user){
        ArrayList<user> database = getDatabase();

        for (user currentUser :database){
            if (currentUser.getID().equals(user.getID())){

                currentUser.setName(user.getName());
                currentUser.setSecondName(user.getSecondName());
                currentUser.setPassword(user.getPassword());
                currentUser.setAge(user.getAge());
                currentUser.setAdressName(user.getAdressName());
                currentUser.setCity(user.getCity());
                currentUser.setStreetAdress(user.getStreetAdress());
                currentUser.setNeighborhood(user.getNeighborhood());
                currentUser.setDistrict(user.getDistrict());
            }
        }

        setDatabase(database);
    }



    public static void cbhangePassword(String ID,String newPassword){

        ArrayList<user> database = getDatabase();
        for (user currentUser :database){
            if (currentUser.getID().equals(ID)){
                currentUser.setPassword(newPassword);
            }
        }

        setDatabase(database);
    }

    public static void deleteUser(String ID){

        ArrayList<user> dataBase = getDatabase();

        for (int i = 0 ;i<dataBase.size();i++){
            if (dataBase.get(i).getID().equals(ID))
                dataBase.remove(i);
        }
        setDatabase(dataBase);
    }

    public static boolean isexist(String ID){
        boolean state = false;
        ArrayList<user> dataBase = getDatabase();
        for (user curentUser : dataBase)
            if (curentUser.getID().equals(ID))
                state=true;

            return state;
    }
}
