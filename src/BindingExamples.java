import koorong.*;
import java.sql.*;
import com.intersys.objects.*;

public class BindingExamples {
  public static void main(String[] args){
    try {
      Database db = getDatabase();
      System.out.println("\nConnected to DB... ");
      
      CreateBlankBook(db);
      CreateBook(db);
    }
    catch (Exception ex) {
      System.out.println("Caught exception: " + ex.getClass().getName() + ": " + ex.getMessage());
    }
  }
  
  public static Database getDatabase() throws CacheException{
    String url="jdbc:Cache://localhost:56121/USER";
    String username="_SYSTEM";
    String pwd="SYS";
    Database db = CacheDatabase.getDatabase(url, username, pwd);
    return db;
  }
  
  public static void CreateBlankBook(Database db) {
    try {
      Book book = new Book(db);
      System.out.println("Created new Book... ");

      int success = book.save();
      System.out.println("Saved Book... ");
    }
    catch (Exception ex) {
      System.out.println("Caught exception: " + ex.getClass().getName() + ": " + ex.getMessage());
    }   
  }
  
  //  CreateBook (com.intersys.objects.Database db, java.util.List tags) throws com.intersys.objects.CacheException {
  public static void CreateBook(Database db) {
    try {
      CreateBook(db);
      System.out.println("Called CreateBook function... ");
    }
    catch (Exception ex) {
      System.out.println("Caught exception: " + ex.getClass().getName() + ": " + ex.getMessage());
    }   
  }
}