
package it2a.cabatuan.sas;

import static java.lang.System.exit;
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
    
    String sql = "INSERT INTO Applicant(First_Name, Last_Name, Address, Status, Email ) VALUES (?, ? , ?, ?, ? )";
   
    con.addApplicant(sql, fname, lname, add, stat, email);
    
}
    public void viewAppli(){
        String qry = "SELECT * FROM Applicant";
        String[] applicantHeader = {"ID", "First Name", "Last Name", "Address", "Status", "Email"};
        String[] applicantColumn = {"ID","First_Name", "Last_Name", "Address", "Status", "Email"};
         Config con = new Config();
         con.viewApplicants(qry, applicantHeader, applicantColumn);
    }
    
    public static void main(String[] args) {
        
        IT2ACABATUANSAS sas = new IT2ACABATUANSAS();
       Config con = new Config();

        Scanner sc = new Scanner(System.in);    
        
        int choice;
        int choose;
        
        do{
            
        System.out.println(" - SCHOLARSHIP SYSTEM - ");
        System.out.println("1. Add Applicant");
        System.out.println("2. View Applicant");
        System.out.println("3. Delete Applicant");
        System.out.println("4. Update Applicant");
        
        System.out.println("5. Exit");
        
        
        System.out.print("Enter choice: ");
        choice = sc.nextInt();
        
        
        switch (choice){
            
            case 1:
                            
                sas.addAppli();
                break;
            
            
            case 2:
                
                System.out.println(" - VIEW LOCATION - ");
               sas.viewAppli();
                break;
            
                
            case 3:
                
                System.out.println(" - DELETE LOCATION - ");
                 sas.viewAppli();
                String sqlDelete = "DELETE FROM Applicant WHERE ID = ? ";
                System.out.print("Enter ID to Delete: ");
                int delID = sc.nextInt();
               con.deleteApplicant(sqlDelete, delID);
                break;
            
            case 4:
                
                 sas.viewAppli();
                String sql = "UPDATE Applicant SET Address  = ?, Status = ?, Email = ? WHERE ID = ?";
                
                System.out.print("Enter ID of the Applicant to Update: ");
                int UpID = sc.nextInt();
                
                System.out.print("Enter new Address: ");
                String add = sc.next();
                System.out.print("Enter new Status: ");
                String stat = sc.next();
                System.out.print("Enter new Email: ");
                String email = sc.next();
                
                con.updateApplicant(sql, add, stat, email, UpID);
                
                break;
                
                
            case 5:
                
                exit(0);
                
                break;
        }
            System.out.println("");
            System.out.print("Do you want to continue? (1 / 0): ");
            choose = sc.nextInt();
      
        }while(choose != 0);
        System.out.println(" - Thankyou - ");
        
        
        
    }
    
}
