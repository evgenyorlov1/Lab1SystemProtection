package lab1java;

//name,password,block,restriction

import java.util.ArrayList;

public class User {        
    
    ArrayList<String[]> array;  //array has information about users
    private final String BLOCK_USER = "block";
    private final String RESTRICTION = "restrict";
    FileOutput file;

    public User(String name, String password) {                        
        file = new FileOutput();
        array = file.getCSV();        
        for(String[] user : array) {            
            if(user[0].equals(name.toString()) && user[1].equals(password.toString()) && user[2].equals("")) {                
                //TODO
                break;
            } else {
                failure();
            }
        }
    }
    
    public void changePassword(String name, String oldPassword, String newPassword) {                        
        for(int i=0; i<array.size(); i++) {
            if(array.get(i)[0].equals(name) && array.get(i)[1].equals(oldPassword) && array.get(i)[3].equals(RESTRICTION)) {
                if(newPassword.matches("")) {
                    array.get(i)[1] = newPassword;
                }
            } 
            else if(array.get(i)[0].equals(name) && array.get(i)[1].equals(oldPassword) && array.get(i)[3].equals("")) {                
                array.get(i)[1] = newPassword;
            }
        }
    }
    
    public void failure() {
        System.out.println("User's password is incorrect");
    }
    
    public void addUser(String name) {
        //adds user
        String[] user = new String[4];
        user[0] = name;
        user[1] = "";
        user[2] = "";
        user[3] = "";
        array.add(user);
   }
    
    public void blockUser(String name, String password) {
        for(int i=0; i<array.size(); i++) {
            if(array.get(i)[0].equals(name) && array.get(i)[1].equals(password)) {
                array.get(i)[2] = BLOCK_USER;
            }
        }
    }
    
    public void setRestriction(String name, String password) {
        for(int i=0; i<array.size(); i++) {
            if(array.get(i)[0].equals(name) && array.get(i)[1].equals(password)) {
                array.get(i)[3] = RESTRICTION;
            }
        }
    }
    
    public void exit() {
        file.writeCSV(array);
        System.exit(0);
    }
}
