package utilities;
import java.io.*;
import java.util.*;
import java.util.Scanner;

import users.User;


@SuppressWarnings("unchecked")
/**Class containing all of the methods for creating and reading files*/
public class FileIO {

/**Method that saves the current database to a file*/
public void fileSave(HashMap<String,User> db) {
        Scanner input = new Scanner(System.in);
        File data;
        boolean createOrLoadFile = false;


        /*
           START OF FILE CREATION
         */
        String fileName = "dataFile";
        do {

                data = new File(fileName + ".dat");
                try {
                        data.createNewFile();
                        createOrLoadFile = true;
                        System.out.println("File created. ");
                } catch (IOException e) {
                        createOrLoadFile = false;
                        System.out.println("File could not be created.");
                        System.err.println("IOException:	"+ e.getMessage());
                }
        } while (createOrLoadFile != true);

        try {
                FileOutputStream outClear = new FileOutputStream(data);
                outClear.write(("").getBytes());
                outClear.close();

                FileOutputStream out = new FileOutputStream(data);
                ObjectOutputStream writer = new ObjectOutputStream(out);

                System.out.println(db);
                writer.writeObject(db);

                writer.close();

        } catch (FileNotFoundException e) {
                System.out.println("File could not be found.");
                System.err.println("FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
                System.out.println("Problem with input/output.");
                System.err.println("IOException: " + e.getMessage());
        }


}

/**Method that loads a database from a file*/
public HashMap<String, User> fileLoad() {
        Scanner input = new Scanner(System.in);
        File data;
        boolean createOrLoadFile = false;

        String fileName = "dataFile";
        do {
                data = new File(fileName + ".dat");
                if (data.exists()) {
                        try {
                                FileInputStream in = new FileInputStream(data);
                                ObjectInputStream readDatabase = new ObjectInputStream(in);

                                HashMap<String, User> loadedData = (HashMap<String,User>)readDatabase.readObject();
                                readDatabase.close();
                                System.out.println("Data loaded.");
                                return(loadedData);
                        } catch (FileNotFoundException e) {
                                createOrLoadFile = false;
                                System.out.println("Problem with input/output.");
                                System.err.println("FileNotFoundException: " + e.getMessage());
                        } catch (IOException e) {
                                createOrLoadFile = false;
                                System.out.println("File could not be found.");
                                System.err.println("IOException: " + e.getMessage());
                        } catch (ClassNotFoundException e) {
                                createOrLoadFile = false;
                                System.out.println("Class could not be used to cast object.");
                                System.err.println("ClassNotFoundException: " + e.getMessage());
                        }
                } //NEED TO THROW AN ERROR IF FILE DOES NOT EXIST

        } while (createOrLoadFile != true);
        return null;
}


public boolean exitCheck() {
        Scanner input = new Scanner(System.in);
        File data;
        String fileName = "dataFile";
        data = new File(fileName + ".dat");

        if(data.exists()) {
                return false;
        }
        return true;
}

}
