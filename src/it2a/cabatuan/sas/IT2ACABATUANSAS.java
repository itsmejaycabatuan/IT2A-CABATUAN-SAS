
package it2a.cabatuan.sas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;


public class IT2ACABATUANSAS {

    
    
    public  void addAppli(){
   
       Config con = new Config();
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter First Name: ");
    String fname = sc.next();
    System.out.print("Enter Last Name: ");
    String lname = sc.next();
    System.out.print("Address: ");
    String add = sc.next();
    System.out.print("Status : ");
    String stat = sc.next();
    System.out.print("Email: ");
    String email = sc.next();
    
    String sql = "INSERT INTO Applicant(FirstName, LastName, Address, Status, Email ) VALUES (?, ? , ?, ?, ? )";
   
    con.addApplicant(sql, fname, lname, add, stat, email);
    
}
    
    public static void main(String[] args) {
        
        IT2ACABATUANSAS sas = new IT2ACABATUANSAS();
       Config con = new Config();

        Scanner sc = new Scanner(System.in);    
        
        int choice;
        
        System.out.println(" - SCHOLARSHIP SYSTEM - ");
        System.out.println("1. Add Applicant");
        System.out.println("2. View Applicant");
        System.out.println("3. Delete Applicant");
        System.out.print("Enter choice: ");
        choice = sc.nextInt();
        
        
        switch (choice){
            
            case 1:
                            
                sas.addAppli();
                break;
            
            
            case 2:
                
                con.viewApplicants();
                break;
            
                
            case 3:
                System.out.print("Enter ID to Delete: ");
                int delID = sc.nextInt();
                con.deleteApplicant(delID);
                break;
            
            
            
        }
        
        
        
        
        
        
    }
    
}
