import koo.*;
import java.sql.*;
import java.util.*;
import com.intersys.objects.*;
import com.intersys.classes.*;

public class BindingExamples {
  public static void main(String[] args){
    try {
      Database db = getDatabase();
      System.out.println("\nConnected to DB... ");
      
      CreateBlankBook(db);
      OpenBook(db);
      // CreateBookProjection(db);
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
      
      ArrayList<String> tags = new ArrayList<String>();
      // List<String> tags = new ArrayList<String>();
      tags.add("anime");
      tags.add("cooking");
      tags.add("kids");
      
      // Projection method
      book.setTags(tags);
      System.out.println("Assign tags... ");
      
      int success = book.save();
      System.out.println("Saved Book... ");
    }
    catch (Exception ex) {
      System.out.println("Caught exception: " + ex.getClass().getName() + ": " + ex.getMessage());
    }   
  }
  
  public static void OpenBook(Database db) {
    try {
      Book book = (Book)(Book._open(db, new Id(1)));
      System.out.println("Open Book... ");
      System.out.println("List tags... ");
      List tags = (List)(book.getTags());
      
      Iterator iter = tags.iterator();
      
      while(iter.hasNext()) {
        String value = (String)iter.next();
        System.out.println("\t-" + value);
      }
    }
    catch (Exception ex) {
      System.out.println("Caught exception: " + ex.getClass().getName() + ": " + ex.getMessage());
    }   
  }
  
  // public static void CreateBookProjection(Database db) {
  //   List<String> tags = new ArrayList<String>();
  //   tags.add("kids");
  //   tags.add("cooking");
  //   System.out.println("tags..." + tags.size());
  //   
  //   try {
  //     //  CreateBook (com.intersys.objects.Database db, java.util.List tags)
  //     Book book = new Book(db);
  // 
  //     // Caught exception: com.intersys.objects.CacheServerException: <INVALID OREF>zCreateBook+2^koo.Book.1
  //     // zCreateBook+2^koo.Book.1 =>  set tagCount = tags.Count()
  //     book.CreateBook(db, tags);
  //     System.out.println("Called CreateBook projected function... ");
  //   }
  //   catch (Exception ex) {
  //     System.out.println("Caught exception: " + ex.getClass().getName() + ": " + ex.getMessage());
  //   }   
  // }
}