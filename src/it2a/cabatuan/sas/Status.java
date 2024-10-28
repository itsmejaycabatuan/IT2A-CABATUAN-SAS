
package it2a.cabatuan.sas;

import java.util.Scanner;


public class Status {
    
    
    
    
    
    
    public void StatusApply(){
        Config  con = new Config();
        Scanner sc = new Scanner(System.in);
         
        
        String res;
        do{
                       System.out.print("\033[H\033[2J");
            System.out.flush();

           
            System.out.println("===================================");
            System.out.println("|          STATUS MENU           |");
            System.out.println("===================================");
            System.out.println("");

            
            System.out.println("Please select an option:");
            System.out.println("-----------------------------");
            System.out.println("1. Edit Status");
            System.out.println("2. View Status");
            System.out.println("3. Logout");
            System.out.println("-----------------------------");
            System.out.println("");

        int choice;
        
         while (true) {
            System.out.print("Enter choice: ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                if (choice >= 1 && choice <= 3) {
                    break;
                } else {
                    System.out.println("Please enter a number between 1 and 3.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next();
            }
        }
        
         
         switch(choice){
             
             case 1:
                 
               Applicant app = new Applicant();
               app.viewApplicant();
               ScholarShips ss = new ScholarShips();
               ss.viewScholarship();
               ScholarshipRecords sr = new ScholarshipRecords();   
               sr.viewScholarshipRecords();
             
             String sqlUpdate = "UPDATE ScholarshipRecords SET Status = ? WHERE Applicant_ID = ? AND Scholarship_ID = ?";
             
                int ID;
                while (true) {
                System.out.print("Enter Applicant ID: ");
                if (sc.hasNextInt()) {
                    ID = sc.nextInt();
                    if (con.getSingleValues("SELECT ID FROM Applicant WHERE ID = ?", ID) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Applicant doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid numeric Applicant ID.");
                    sc.next(); 
                }
            }
                 
                  int scID;
                while (true) {
                System.out.print("Enter Scholarship ID: ");
                if (sc.hasNextInt()) {
                    scID = sc.nextInt();
                    if (con.getSingleValues("SELECT Scholarship_ID FROM Scholarships WHERE Scholarship_ID = ?", scID) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Scholarship doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid numeric Scholarship ID.");
                    sc.next(); 
                }
            }
                 
                 System.out.print("Enter Status: ");
                 String stats = sc.next();
                 
                 con.updateApplicant(sqlUpdate, stats,ID,scID);                 
             
             break;
             
             case 2:
                 sr = new ScholarshipRecords();
                 sr.viewScholarshipRecords();
                 break;
                        
             case 3:
                 System.out.println("Back to Main Menu.....");
                 
                 break;
             
             
         }
            System.out.print("Do you want to continue in HR updating? Yes or No: ");
            res = sc.next();
        }while(res.equalsIgnoreCase("yes"));
        
        
        
        
        
        
    }
}
