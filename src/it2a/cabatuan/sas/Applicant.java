
package it2a.cabatuan.sas;

import static java.lang.System.exit;
import java.util.Scanner;


public class Applicant {
    
    public  void addApplicant(){
   
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
    System.out.print("Age: ");
    int age = sc.nextInt();
    System.out.print("Contact No.: ");
    String contact = sc.next();
    
    String sql = "INSERT INTO Applicant(First_Name, Last_Name, Address, Status, Email, Age, Contact_No ) VALUES (?, ? , ?, ?, ?, ?, ? )";
   
    con.addApplicant(sql, fname, lname, add, stat, email,age, contact);
    
    
    }
    
     public void viewApplicant(){
         
        String qry = "SELECT * FROM Applicant";
         System.out.println("   Applicant List: ");
        String[] applicantHeader = {"ID", "First Name", "Last Name", "Address", "Status", "Email","Age","Contact No."};
        String[] applicantColumn = {"ID","First_Name", "Last_Name", "Address", "Status", "Email","Age","Contact_No"};
         Config con = new Config();
         con.viewApplicants(qry, applicantHeader, applicantColumn);
    }
     
     public void Applicants(){
        
         
         Applicant app = new Applicant();
        Scanner sc = new Scanner(System.in);    
        Config con = new Config();
        int choice;
        String response;
        
        do{
            
    
        
        System.out.println("1. Add Applicant");
        System.out.println("2. View Applicant");
        System.out.println("3. Delete Applicant");
        System.out.println("4. Update Applicant");
        System.out.println("5. Exit");
        
        
        
        
        while (true) {
            System.out.print("Enter choice: ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                if (choice >= 1 && choice <= 5) {
                    break;
                } else {
                    System.out.println("Please enter a number between 1 and 5.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next();
            }
        }
        
        
        
        
        switch (choice){
            
            case 1:
                            
                app.addApplicant();
                break;
            
            
            case 2:
                
             
                app.viewApplicant();
                break;
            
                
            case 3:
             
                 app.viewApplicant();
                String sqlDelete = "DELETE FROM Applicant WHERE ID = ? ";
                System.out.print("Enter ID to Delete: ");
                int delID = sc.nextInt();
               con.deleteApplicant(sqlDelete, delID);
                break;
            
            case 4:
                
                 app.viewApplicant();
                 
                String sql = "UPDATE Applicant SET Address  = ?, Status = ?, Email = ?, Age = ?, Contact_No = ?  WHERE ID = ?";
                
                System.out.print("Enter ID of the Applicant to Update: ");
                int UpID = sc.nextInt();
                
                System.out.print("Enter new Address: ");
                String add = sc.next();
                System.out.print("Enter new Status: ");
                String stat = sc.next();
                System.out.print("Enter new Email: ");
                String email = sc.next();
                System.out.println("Enter new Age: ");
                int age = sc.nextInt();
                System.out.print("Enter new Contact Number: ");
                String contact = sc.next();
                
                con.updateApplicant(sql, add, stat, email, age, contact, UpID);
                
                break;
                
                
            case 5:
                System.out.println("Exiting.....");
                break;
    
           
        }
        
            System.out.println("");
            System.out.print("Do you want to continue with applicant ? Yes or  No : ");
            response = sc.next();
      
        }while(response.equalsIgnoreCase("yes"));
        
        
     }
    
}
