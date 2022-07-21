package sample;

import java.util.ArrayList;

public class signInsignUp{

    public static void signUp(user newUser){
        ArrayList<user> database = databaseController.getDatabase();
        database.add(newUser);
        databaseController.setDatabase(database);
    }

    public static String signIn(String ID ,String password){

        String result ="";

        int counter = 0 ;

        ArrayList<user> database = databaseController.getDatabase();

        for (user currentUser :database){
            if (currentUser.getID().equals(ID)){
                counter ++;

                if (currentUser.getPassword().equals(password)){

                    user.currentUser=currentUser;

                    return "devam";
                }

                else {
                    return "Şifre Yanlış";
                }
            }
        }

        if (counter==0)
            result = "Sistemde bu ID numarasına ait kulanıcı yok.";

        return result;
    }


}
