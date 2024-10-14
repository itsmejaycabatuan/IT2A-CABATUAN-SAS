
package it2a.cabatuan.sas;

import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;


public class IT2ACABATUANSAS {

    
    
    
    
    public static void main(String[] args) {
        
         String response;
        Scanner sc = new Scanner(System.in);
        
        do{
        System.out.println("1. APPLICANT ");
        System.out.println("2. SCHOLARSHIPS ");
        
        
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch(choice){
            case 1:
                Applicant app = new Applicant();
               app.Applicants();
                break;
            case 2:
                ScholarShips sch = new ScholarShips();
                sch.Scholarship();
                break;
                
            case 5:
                
               
                break;
                
        }
            System.out.println("");
            System.out.print("Do you want to continue? Yes / No : ");
            response = sc.nextLine();
           
            
        }while(response.equalsIgnoreCase("yes"));
        sc.close();
        System.out.println("Thank you for using the application!");
    }
    
}
