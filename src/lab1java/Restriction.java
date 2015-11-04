/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1java;


import java.util.regex.*;
/**
 *
 * @author pc
 */
public class Restriction {
    //Наявність рядкових і прописних букв
    public static boolean checkRestiction(String password) {
        Pattern p = Pattern.compile("([\\w\\d])\\w+");
        Matcher m = p.matcher(password);
        return m.matches();
    }
}
