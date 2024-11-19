
package it2a.cabatuan.sas;

import static java.lang.System.exit;
import java.util.Scanner;


public class Applicant {
    
    public  void addApplicant(){
   
     Config con = new Config();
Scanner sc = new Scanner(System.in);

System.out.print("Enter First Name: ");
String fname = sc.nextLine();  

System.out.print("Enter Last Name: ");
String lname = sc.nextLine();  

System.out.print("Address: ");
String add = sc.nextLine();  

System.out.print("Status: ");
String stat = sc.nextLine(); 

System.out.print("Email: ");
String email = sc.nextLine(); 

int age;
  while (true) {
            System.out.print("Age: ");
            if (sc.hasNextInt()) {
                age = sc.nextInt(); 
                if (age < 0) {  
                    System.out.println("Age cannot be negative. Please enter a valid age.");
                    continue;
                }
                break;  
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.next(); 
            }
        }
sc.nextLine();

System.out.print("Contact No.: ");
String contact = sc.nextLine();  

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
            
     System.out.print("\033[H\033[2J");
            System.out.flush();

          
            System.out.println("=========================================");
            System.out.println("|           APPLICANT MENU              |");
            System.out.println("=========================================");
            System.out.println("");

       
            System.out.println("          Please select an option:       ");
            System.out.println("-----------------------------------------");
            System.out.println("    1. Add Applicant");
            System.out.println("    2. View Applicant");
            System.out.println("    3. Delete Applicant");
            System.out.println("    4. Update Applicant");
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
                            
                app.addApplicant();
                break;
            
            
            case 2:
                
             
                app.viewApplicant();
                break;
            
                
            case 3:
             
                 app.viewApplicant();
                 
                String sqlDelete = "DELETE FROM Applicant WHERE ID = ? ";
                      
         int delID;
                while (true) {
                System.out.print("Enter Applicant ID to  Delete: ");
                if (sc.hasNextInt()) {
                    delID = sc.nextInt();
                    if (con.getSingleValues("SELECT ID FROM Applicant WHERE ID = ?", delID) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Applicant doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid numeric Applicant ID.");
                    sc.next(); 
                }
            }

               con.deleteApplicant(sqlDelete, delID);
                break;
            
            case 4:
                
                 app.viewApplicant();
                 
                String sql = "UPDATE Applicant SET Address  = ?, Status = ?, Email = ?, Age = ?, Contact_No = ?  WHERE ID = ?";
                
                
         int UpID;
                while (true) {
                System.out.print("Enter Applicant ID to Update: ");
                if (sc.hasNextInt()) {
                    UpID = sc.nextInt();
                    if (con.getSingleValues("SELECT ID FROM Applicant WHERE ID = ?", UpID) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Applicant doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid numeric Applicant ID.");
                    sc.next(); 
                }
            }
                
                System.out.print("Enter new Address: ");
                String add = sc.next();
                
                System.out.print("Enter new Status: ");
                String stat = sc.next();
                
                System.out.print("Enter new Email: ");
                String email = sc.next();
                

                        int age;
                    while (true) {
                    System.out.print("Enter new Age: ");
                    if (sc.hasNextInt()) {
                        age = sc.nextInt(); 
                        if (age < 0) {  
                            System.out.println("Age cannot be negative. Please enter a valid age.");
                            continue;
                        }
                        break;  
                    } else {
                        System.out.println("Invalid input. Please enter a valid integer.");
                        sc.next(); 
                    }
                }
                    
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
