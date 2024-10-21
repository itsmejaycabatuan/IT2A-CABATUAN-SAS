

package it2a.cabatuan.sas;

import java.util.Scanner;


public class ScholarshipRecords {
    
    
    public void ApplyScholar(){
        
        Config con = new Config();
        Scanner sc = new Scanner(System.in);
        Applicant ap = new Applicant();
        ap.viewApplicant();
        ScholarShips sh = new ScholarShips();
        sh.viewScholarship();
       
         
        System.out.print("Enter Applicant ID: ");
        int ID = sc.nextInt();
        System.out.print("Enter Scholarship ID to apply: ");
        int scID = sc.nextInt();
        System.out.print("Date Applied: ");
        String date = sc.next();
        System.out.print("GPA: ");
        double gpa = sc.nextDouble();
        System.out.print("Annual Income: ");
        int ann = sc.nextInt();
        System.out.print("Status: ");
        String stats = sc.next();
        
        String sql = "INSERT INTO ScholarshipRecords (Applicant_ID, Scholarship_ID, Date_Applied, GPA, Annual_Income, Status) VALUES (?,?,?,?,?,?)" ;
        con.addApplicant(sql, ID, scID, date, gpa, ann, stats);
                
        
        
    }
    
    public void viewRecords() {
        Config con = new Config();
        
      
        String viewQuery = "SELECT ScholarshipRecords.Applicant_ID, Applicant.First_Name, Applicant.Last_Name, " +
                           "ScholarshipRecords.Scholarship_ID, Scholarships.Scholarship_name, " +
                           "ScholarshipRecords.Date_Applied, ScholarshipRecords.GPA, " +
                           "ScholarshipRecords.Annual_Income, ScholarshipRecords.Status " +
                           "FROM ScholarshipRecords " +
                           "INNER JOIN Applicant ON ScholarshipRecords.Applicant_ID = Applicant.ID " +
                           "INNER JOIN Scholarships ON ScholarshipRecords.Scholarship_ID = Scholarships.Scholarship_ID";

        String[] header = {"Applicant ID", "First Name", "Last Name", "Scholarship ID", "Scholarship Name", 
                           "Date Applied", "GPA", "Annual Income", "Status"};
        String[] columns = {"Applicant_ID", "First_Name", "Last_Name", "Scholarship_ID", "Scholarship_name", 
                            "Date_Applied", "GPA", "Annual_Income", "Status"};
        
     
        con.viewApplicants(viewQuery, header, columns);
    }    
    public void viewScholarshipRecords(){
        
        Config con = new Config();
        
        String view = "SELECT * FROM ScholarshipRecords";
        String[] scholarshipHeader = {"ScholarshipRecords ID", "Applicant ID", "Scholarship ID", "Date Applied", "GPA", "Annual Income","Stats"};
        String[] scholarshipColumn = {"ScholarshipRecords_ID","Applicant_ID", "Scholarship_ID", "Date_Applied", "GPA", "Annual_Income", "Status"};
        
        con.viewApplicants(view, scholarshipHeader, scholarshipColumn);
    }
    
    public void Records(){
        
        ScholarshipRecords sr = new ScholarshipRecords();
         Config con = new Config();

        Scanner sc = new Scanner(System.in);
        String response;
        
        do{
        System.out.println(" - Scholarship Records  - ");
        System.out.println("1. Apply Scholar ");
        System.out.println("2. View Records ");
        System.out.println("3. Update  Records ");
        System.out.println("4. Delete Records ");
        System.out.println("5. Exit ");
        
        int choice;
        
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
                
                sr.ApplyScholar();
                break;
                
            case 2:
                
                sr.viewRecords();
                break;
                
            case 3:
                
                sr.viewRecords();
                String sqlUpdate = "UPDATE ScholarshipRecords SET Status = ? WHERE Applicant_ID = ? AND Scholarship_ID = ? ";
                System.out.print("Enter the Applicant ID to Update: ");
                int id = sc.nextInt();
                System.out.print("Enter Scholarship ID to Update: ");
                int id2 = sc.nextInt();
                
                
                System.out.print("Enter new Status: ");
                String stats = sc.next();
                
                con.updateApplicant(sqlUpdate,stats,id,id2 );
                break;
                
            case 4:
                
                sr.viewScholarshipRecords();
                String sqlDELETE = "DELETE FROM ScholarshipRecords WHERE ScholarshipRecords_ID = ?";
                
                System.out.print("Enter Scholarship Records ID to Delete: ");
                int idDEL = sc.nextInt();
                
                con.deleteApplicant(sqlDELETE, idDEL);
                
               
                break;
                
            case 5: 
                System.out.println("Back to main menu.....");
               break;
                
        }
       
            System.out.println("");
            System.out.print("Do you want to continue with Scholarship Records? Yes or No: ");
            response = sc.next();
        
        }while(response.equalsIgnoreCase("yes"));
        
       
        
    }
    
    
    
    
    
    
}
