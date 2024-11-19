
package it2a.cabatuan.sas;

import static java.lang.System.exit;
import java.util.Scanner;


public class ScholarShips {
    
    public  void addScholarships(){
   
       Config con = new Config();
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Scholarship Name: ");
    String sname = sc.next();
   
    int capacity;
     while (true) {
            System.out.print("Capacity: ");
            if (sc.hasNextInt()) {
                capacity = sc.nextInt(); 
                break;  
            } else {
                System.out.println("Invalid input. Please enter a valid Capacity.");
                sc.next(); 
            }
        }
     double amount;
     while (true) {
           System.out.print("Full Amount: ");
            if (sc.hasNextInt()) {
                amount = sc.nextDouble(); 
                break;  
            } else {
                System.out.println("Invalid input. Please enter a valid Amount.");
                sc.next(); 
            }
        }

    sc.nextLine();
    
    System.out.print("Requirements: ");
    String req = sc.nextLine();
    
    System.out.print("Date Ends: ");
    String date  = sc.nextLine();
   
     double gpa;
     while (true) {
          System.out.print("GPA:");
            if (sc.hasNextDouble()) {
                gpa = sc.nextDouble(); 
                break;  
            } else {
                System.out.println("Invalid input. Please enter a valid GPA.");
                sc.next(); 
            }
        }

    int ann;
     while (true) {
         System.out.print("Annual Income: ");
            if (sc.hasNextInt()) {
                ann = sc.nextInt(); 
                break;  
            } else {
                System.out.println("Invalid input. Please enter a valid Annual Income.");
                sc.next(); 
            }
        }
    
    String sql = "INSERT INTO Scholarships(Scholarship_name , Capacity , Full_Amount, Requirements, Date_Ends, GPA, Annual_Income) VALUES (?, ? , ?, ?, ?,?,?)";
   
    con.addApplicant(sql, sname, capacity, amount, req, date, gpa, ann);
    
    
    }
    
    public void viewScholarship(){
         
        String qry = "SELECT * FROM Scholarships";
        
        System.out.println("    Scholarship List: ");
        String[] applicantHeader = {"ID", "Scholarship Name", "Capacity", "Full Amount", "Requirements", "Date Ends","GPA","Annual Income"};
        String[] applicantColumn = {"Scholarship_ID","Scholarship_name", "Capacity", "Full_Amount", "Requirements", "Date_Ends","GPA","Annual_Income"};
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
            
       System.out.print("\033[H\033[2J");
            System.out.flush();

            
            System.out.println("=========================================");
            System.out.println("|           SCHOLARSHIP MENU            |");
            System.out.println("=========================================");
            System.out.println("");

            
            System.out.println("          Please select an option:       ");
            System.out.println("-----------------------------------------");
            System.out.println("    1. Add Scholarship");
            System.out.println("    2. View Scholarship");
            System.out.println("    3. Delete Scholarship");
            System.out.println("    4. Update Scholarship");
            System.out.println("    5. Exit");
            System.out.println("-----------------------------------------");
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
               int delID;
                while (true) {
                System.out.print("Enter Scholarship ID to Delete: ");
                if (sc.hasNextInt()) {
                    delID = sc.nextInt();
                    if (con.getSingleValues("SELECT Scholarship_ID FROM Scholarships WHERE Scholarship_ID = ?", delID) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Scholarship doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid Scholarship ID.");
                    sc.next(); 
                }
            }
               con.deleteApplicant(sqlDelete, delID);
                break;
            
            case 4:
                
               sch.viewScholarship();

                 
                String sql = "UPDATE Scholarships SET Capacity  = ?, Full_Amount = ?, Requirements = ?, Date_Ends =?  GPA = ?, Annual_Income = ? WHERE Scholarship_ID = ?";
                
                 
        int UpID;
                while (true) {
                System.out.print("Enter Scholarship ID to Update : ");
                if (sc.hasNextInt()) {
                    UpID = sc.nextInt();
                    if (con.getSingleValues("SELECT Scholarship_ID FROM Scholarships WHERE Scholarship_ID = ?", UpID) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Scholarship doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid Scholarship ID.");
                    sc.next(); 
                }
            }
                
                
                    int capa;
                   while (true) {
               System.out.print("Enter new Capacity: ");
               if (sc.hasNextInt()) {
                   capa = sc.nextInt(); 
                   break;  
               } else {
                   System.out.println("Invalid input. Please enter a valid Capacity.");
                   sc.next(); 
               }
           }
                
                    double amount;
        while (true) {
              System.out.print("Enter new Full Amount: ");
               if (sc.hasNextInt()) {
                   amount = sc.nextDouble(); 
                   break;  
               } else {
                   System.out.println("Invalid input. Please enter a valid Amount.");
                   sc.next(); 
               }
           }
                System.out.print("Enter new Requirements: ");
                String require = sc.next();
                
                System.out.print("Enter new Date Ends : ");
                String ends = sc.next();

              double newgpa;
            while (true) {
                 System.out.print("Enter new GPA:");
                   if (sc.hasNextDouble()) {
                       newgpa = sc.nextDouble(); 
                       break;  
                   } else {
                       System.out.println("Invalid input. Please enter a valid GPA.");
                       sc.next(); 
                   }
               }

               
                int newann;
     while (true) {
         System.out.print("Enter new Annual Income: ");
            if (sc.hasNextInt()) {
                newann = sc.nextInt(); 
                break;  
            } else {
                System.out.println("Invalid input. Please enter a valid Annual Income.");
                sc.next(); 
            }
        }
    
                
                con.updateApplicant(sql, capa, amount, require, ends, newgpa, newann,UpID);
                
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
