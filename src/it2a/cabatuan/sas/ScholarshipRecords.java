

package it2a.cabatuan.sas;

import java.util.Scanner;


public class ScholarshipRecords {
    
    
    public void ApplyScholar(){
        
        Config con = new Config();
        Scanner sc = new Scanner(System.in);
        
        System.out.println(" - Select a Applicant - ");
        Applicant ap = new Applicant();
        ap.viewApplicant();
        System.out.println(" - Select a Scholarship - ");
        ScholarShips sh = new ScholarShips();
        sh.viewScholarship();
       
           
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
        System.out.print("Date Applied: ");
        String date = sc.next();
        System.out.print("GPA: ");
        double gpa = sc.nextDouble();
        System.out.print("Annual Income: ");
        int ann = sc.nextInt();
        sc.nextLine();
        System.out.print("Requirements: ");
        String req = sc.next();
        
        String sql = "INSERT INTO ScholarshipRecords (Applicant_ID, Scholarship_ID, Date_Applied, GPA, Annual_Income, Requirements_Pass) VALUES (?,?,?,?,?,?)" ;
        con.addApplicant(sql, ID, scID, date, gpa, ann, req);
                
        
        
    }
    
    public void viewRecords() {
        Config con = new Config();
        
      
       String viewQuery = "SELECT ScholarshipRecords.Applicant_ID, Applicant.First_Name, Applicant.Last_Name, " +
                   "ScholarshipRecords.Scholarship_ID, Scholarships.Scholarship_name, " +
                   "ScholarshipRecords.Date_Applied, ScholarshipRecords.GPA, " +
                   "ScholarshipRecords.Annual_Income, ScholarshipRecords.Requirements_Pass " + 
                   "FROM ScholarshipRecords " +
                   "INNER JOIN Applicant ON ScholarshipRecords.Applicant_ID = Applicant.ID " +
                   "INNER JOIN Scholarships ON ScholarshipRecords.Scholarship_ID = Scholarships.Scholarship_ID";

        String[] header = {"Applicant ID", "First Name", "Last Name", "Scholarship ID", "Scholarship Name", 
                           "Date Applied", "GPA", "Annual Income", "Requirements Pass"};
        String[] columns = {"Applicant_ID", "First_Name", "Last_Name", "Scholarship_ID", "Scholarship_name", 
                            "Date_Applied", "GPA", "Annual_Income", "Requirements_Pass"};
        
     
        con.viewApplicants(viewQuery, header, columns);
    }    
    public void viewScholarshipRecords(){
        
        Config con = new Config();
        
        String view = "SELECT * FROM ScholarshipRecords";
         System.out.println("   Scholarsihip Records List: ");
        String[] scholarshipHeader = {"ScholarshipRecords ID", "Applicant ID", "Scholarship ID", "Date Applied", "GPA", "Annual Income","Requirements Pass","Status"};
        String[] scholarshipColumn = {"ScholarshipRecords_ID","Applicant_ID", "Scholarship_ID", "Date_Applied", "GPA", "Annual_Income", "Requirements_Pass","Status"};
        
        con.viewApplicants(view, scholarshipHeader, scholarshipColumn);
    }
    
    public void Records(){
        
        ScholarshipRecords sr = new ScholarshipRecords();
         Config con = new Config();

        Scanner sc = new Scanner(System.in);
        String response;
        
        do{
                       System.out.print("\033[H\033[2J");
            System.out.flush();

        
            System.out.println("==========================================");
            System.out.println("|          SCHOLARSHIP RECORDS MENU      |");
            System.out.println("==========================================");
            System.out.println("");

          
            System.out.println("          Please select an option:        ");
            System.out.println("------------------------------------------");
            System.out.println("    1. Apply for Scholarship");
            System.out.println("    2. View Records");
            System.out.println("    3. Update Records");
            System.out.println("    4. Delete Records");
            System.out.println("    5. Exit");
            System.out.println("------------------------------------------");
            System.out.println("");


        
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
                System.out.println("    Scholarship Apply Record List: ");
                sr.viewRecords();
                sr.viewScholarshipRecords();
                break;
                
            case 3:
                
                sr.viewRecords();
                String sqlUpdate = "UPDATE ScholarshipRecords SET GPA = ?, Annual_Income = ?, Requirements_Pass = ?  WHERE Applicant_ID = ? AND Scholarship_ID = ? ";
                
                int id;
                while (true) {
                System.out.print("Enter Applicant ID to Update : ");
                if (sc.hasNextInt()) {
                    id = sc.nextInt();
                    if (con.getSingleValues("SELECT ID FROM Applicant WHERE ID = ?", id) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Applicant doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid numeric Applicant ID.");
                    sc.next(); 
                }
            }
                
                   int id2;
                while (true) {
                System.out.print("Enter Scholarship ID to Update : ");
                if (sc.hasNextInt()) {
                    id2 = sc.nextInt();
                    if (con.getSingleValues("SELECT Scholarship_ID FROM Scholarships WHERE Scholarship_ID = ?", id2) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Scholarship doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid numeric Scholarship ID.");
                    sc.next(); 
                }
            }
                
                System.out.print("Enter new GPA: ");
                double  newGPa = sc.nextDouble();
                System.out.print("Enter new Annual Income: ");
                int newann = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter new Requirements you pass: ");
                String  newreq = sc.next();
                
                con.updateApplicant(sqlUpdate,newGPa,newann,newreq,id,id2);
                break;
                
            case 4:
                
                sr.viewScholarshipRecords();
                String sqlDELETE = "DELETE FROM ScholarshipRecords WHERE ScholarshipRecords_ID = ?";
              
                   int idDEL;
                while (true) {
                System.out.print("Enter Scholarship ID to Update : ");
                if (sc.hasNextInt()) {
                    idDEL = sc.nextInt();
                    if (con.getSingleValues("SELECT ScholarshipRecords_ID FROM ScholarshipRecords WHERE ScholarshipRecords_ID = ?", idDEL) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Scholarship Records ID  doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid numeric Scholarship Records ID.");
                    sc.next(); 
                }
            }
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
