import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {

        DBConfig dbConfig = new DBConfig();
//        if(dbConfig.insertContact("Fakhar", "03123459111")>0)
//        {
//            System.out.println("Contact added");
//        }
//        else
//        {
//            System.out.println("Error");
//        }


//        if(dbConfig.update(2, "waqar", "13221309821")>0)
//        {
//            System.out.println("Contact updated");
//        }
//        else
//        {
//            System.out.println("Error");
//        }
//
//        if(dbConfig.delete(1)>0)
//        {
//            System.out.println("Contact delete");
//        }
//        else
//        {
//            System.out.println("Error");
//        }

        ArrayList<String> records = dbConfig.getAllContacts();
        for (String r: records)
        {
            System.out.println(r);
        }
    }
}