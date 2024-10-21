
package it2a.cabatuan.sas;

import static java.lang.System.exit;
import java.util.Scanner;


public class ScholarShips {
    
    public  void addScholarships(){
   
       Config con = new Config();
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Scholarship Name: ");
    String sname = sc.next();
    System.out.print("Capacity: ");
    int capacity = sc.nextInt();
    System.out.print("Full Amount: ");
    double amount = sc.nextDouble();
    sc.nextLine();
    System.out.print("Requirements: ");
    String req = sc.nextLine();
    System.out.print("Date Ends: ");
    String date  = sc.nextLine();
   
    
    String sql = "INSERT INTO Scholarships(Scholarship_name , Capacity , Full_Amount, Requirements, Date_Ends) VALUES (?, ? , ?, ?, ?)";
   
    con.addApplicant(sql, sname, capacity, amount, req, date);
    }
    
    public void viewScholarship(){
         
        String qry = "SELECT * FROM Scholarships";
        
        System.out.println("    Scholarship List: ");
        String[] applicantHeader = {"ID", "Scholarship Name", "Capacity", "Full Amount", "Requirements", "Date Ends"};
        String[] applicantColumn = {"Scholarship_ID","Scholarship_name", "Capacity", "Full_Amount", "Requirements", "Date_Ends"};
         Config con = new Config();
         con.viewApplicants(qry, applicantHeader, applicantColumn);
    }
    
    public void Scholarship(){
        
         
         ScholarShips sch = new ScholarShips();
         
        Scanner sc = new Scanner(System.in);    
        Config con = new Config();
        int choice;
        String response;
        
        do{
            
        System.out.println("1. Add Scholarship");
        System.out.println("2. View Scholarship");
        System.out.println("3. Delete Scholarship");
        System.out.println("4. Update Scholarship");
        System.out.println("5. Exit");
        
         System.out.println("");
         
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
                            
                sch.addScholarships();
                break;
            
            
            case 2:
                
            

               sch.viewScholarship();
                break;
            
                
            case 3:
                
               
                sch.viewScholarship();
                String sqlDelete = "DELETE FROM Scholarships WHERE Scholarship_ID = ? ";
                System.out.print("Enter ID to Delete: ");
                int delID = sc.nextInt();
               con.deleteApplicant(sqlDelete, delID);
                break;
            
            case 4:
                
               sch.viewScholarship();

                 
                String sql = "UPDATE Scholarships SET Capacity  = ?, Full_Amount = ?, Requirements = ?, Date_Ends =? WHERE Scholarship_ID = ?";
                
                System.out.print("Enter ID of the Scholarship to Update: ");
                int UpID = sc.nextInt();
                
                System.out.print("Enter new Capacity: ");
                int capa = sc.nextInt();
                System.out.print("Enter new Full Amount: ");
                double amount = sc.nextDouble();
                System.out.print("Enter new Requirements: ");
                String require = sc.next();
                System.out.println("Enter new Date Ends : ");
                String ends = sc.next();
                
                
                con.updateApplicant(sql, capa, amount, require, ends, UpID);
                
                break;
                
                
            case 5:
                System.out.println("Exiting.....");
                
                
                break;
        }
        
            System.out.println("");
            System.out.print("Do you want to continue with Scholarship ? Yes or No : ");
            response = sc.next();
      
        }while(response.equalsIgnoreCase("yes"));
        
        
        
     }
}
