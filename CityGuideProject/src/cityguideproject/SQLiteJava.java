/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityguideproject;

/**
 *
 * @author felixfaker
 */
import java.sql.*;
/**
 *
 * @author felixfaker
 */
public class SQLiteJava {
    public static Connection dbConnector() {
      Connection c = null;
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:cityguide.db");
         System.out.println("Opened database successfully");
         return c;
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         return null;
      }
   }
    
}