package lab1java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class Fileoutput {
    
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    
    public static ArrayList<String[]> getCSV() {
        BufferedReader br = null;
        String line = "";
        ArrayList<String[]> array = new ArrayList<String[]>();
        try {
            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + File.separator + "init.csv"));            
            while((line = br.readLine()) != null) {                       
                array.add(line.split(COMMA_DELIMITER));
            }
        } catch(Exception e) {System.err.println("getCSV error: " + e);}
        return array;
    }
    
    public static void writeCSV(ArrayList<String[]> array) {
        
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(System.getProperty("user.dir") + File.separator + "init.csv");
            for(String[] line : array) {
                fileWriter.append(line[0]); //name
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(line[1]); //password
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(line[2]); //block
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(line[3]); //restriction                
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch(Exception e) {System.err.println("writeCSV error: " + e);}
        finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch(Exception e) {
                System.err.println("writeCSV error: " + e);
            }
        }
    }
}