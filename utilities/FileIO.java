package utilities;
import java.io.*;
import java.util.*;
import java.util.Scanner;

import users.User;


@SuppressWarnings("unchecked")
public class FileIO {

public void fileSave(HashMap<String,User> db) {
        Scanner input = new Scanner(System.in);
        File data;
        boolean createOrLoadFile = false;


        /*
           START OF FILE CREATION
         */
        String fileName = "dataFile";
        do {
                // System.out.println("Enter name of the file: ");
                // input = new Scanner(System.in);
                // fileName = input.nextLine();
                data = new File(fileName + ".dat");
                //
                // if (data.exists()) {
                //         System.out.println("Error, file name already exists. ");
                // } else if (!data.exists()) {
                        try {
                                data.createNewFile();
                                createOrLoadFile = true;
                                System.out.println("File created. ");
                        } catch (IOException e) {
                                createOrLoadFile = false;
                                System.out.println("File could not be created.");
                                System.err.println("IOException:	"+ e.getMessage());
                        }
                // }
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

public HashMap<String, User> fileLoad() {
        Scanner input = new Scanner(System.in);
        File data;
        boolean createOrLoadFile = false;

        String fileName = "dataFile";
        do {
                // System.out.println("Enter name of the file: ");
                // input = new Scanner(System.in);
                // fileName = input.nextLine();
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
        /*System.out.println("Enter name of the file to check: ");
        input = new Scanner(System.in);
        fileName = input.nextLine();
        */
        data = new File(fileName + ".dat");

        if(data.exists()) {
          return false;
        }
        return true;
}

}
