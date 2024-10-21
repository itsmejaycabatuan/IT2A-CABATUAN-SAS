
package it2a.cabatuan.sas;

import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;


public class IT2ACABATUANSAS {
 
    
    public static void main(String[] args) {
        
         String response;
        Scanner sc = new Scanner(System.in);
      int choice; 

        do{
            System.out.println("");
        System.out.println("1. APPLICANT     ");
        System.out.println("2. SCHOLARSHIP ");
        System.out.println("3. SCHOLARSHIP RECORDS");
        System.out.println("4. EXIT THE APPLICATION");
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

        switch(choice){
            case 1:
                Applicant app = new Applicant();
               app.Applicants();
                break;
            case 2:
                ScholarShips sch = new ScholarShips();
                sch.Scholarship();
                break;
            case 3:
                ScholarshipRecords  sr = new ScholarshipRecords();
                sr.Records();
                break;
            case 4:
                System.out.println("Exiting the application.....");
                System.out.println("");
                System.out.println("Thank you for using the application !");
                exit(0);
                break;
                
        }
            System.out.println("");
            System.out.print("Do you want to continue or go back to the Main Menu ? Yes or No : ");
            response = sc.next();
           
            
        }while(response.equalsIgnoreCase("yes"));
        sc.close();
        System.out.println("Thank you for using the application !");
    }
    
}
