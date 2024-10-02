
package it2a.cabatuan.sas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Config {
    
    public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); // Load the SQLite JDBC driver
            con = DriverManager.getConnection("jdbc:sqlite:ScholarshipApply.db"); // Establish connection
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }
    
    public void addApplicant(String sql, String... values){
        
        
        try{
        Connection con  = this.connectDB();
        PreparedStatement pst = con.prepareStatement(sql);
        
        for(int i = 0; i < values.length; i++){
            pst.setString(i + 1, values[i]);
        }
            pst.executeUpdate();
            System.out.println(" - Record Added Successfully - ");
        }catch(SQLException e){
            System.out.println("Error adding Record: "+ e.getMessage());
        }
        
    }
    
    
     public void viewApplicants(){
         
         
          String sql =  "SELECT * FROM Applicant";
        
          try{
       Connection con = connectDB();
       PreparedStatement pst = con.prepareStatement(sql);
       ResultSet rs = pst.executeQuery();
       
           System.out.println(" - Applicant Set - ");
           
           while(rs.next()){
           int id = rs.getInt("ID");
           String fname = rs.getString("FirstName");
           String lname = rs.getString("LastName");
           String address = rs.getString("Address");
           String status = rs.getString("Status");
           String email = rs.getString("Email");
           
           System.out.println("ID: " + id + ", FirstName: " + fname + ", LastName: " + lname + ", Address: " + address + ", Status: " + status + ", Email: " + email);
       }
       
 
       }catch(SQLException e){
           System.out.println("View Error: "+e.getMessage());
       }
                
            }
     
     public void deleteApplicant(int id ){
         
         String sql = "DELETE FROM Applicant WHERE ID = ? ";
         
         try{
       
       Connection con = connectDB();
       PreparedStatement pst = con.prepareStatement(sql);
       
       pst.setInt(1, id);
       
       int rowsDelete  = pst.executeUpdate();
       
      if(rowsDelete > 0 ){
          System.out.println(" - Delete Successfully - ");
      }else{
          System.out.println(" - Delete Failed: Applicant ID not Found - ");
      }
       
       }catch(SQLException e ){
           System.out.println("Delete Error: "+e.getMessage());
       }
   }
         
     }


