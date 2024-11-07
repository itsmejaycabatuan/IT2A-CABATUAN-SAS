

package it2a.cabatuan.sas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        
        
        LocalDate currdate = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date = currdate.format(format);
        
        System.out.print("GPA: ");
        double gpa = sc.nextDouble();

       
        System.out.print("Annual Income: ");
        int ann = sc.nextInt();
        sc.nextLine();

        System.out.print("Requirements: ");
        String req = sc.nextLine();
        
        String status  = "Pending";
        
        String sql = "INSERT INTO ScholarshipRecords (Applicant_ID, Scholarship_ID, Date_Applied, GPA, Annual_Income, Requirements_Pass, Status) VALUES (?,?,?,?,?,?,?)" ;
        con.addApplicant(sql, ID, scID, date, gpa, ann, req, status);
                
        String updateCapacitySQL = "UPDATE Scholarships SET Capacity = Capacity - 1 WHERE Scholarship_ID = ?";
        con.updateApplicant(updateCapacitySQL, scID);

         System.out.println(" Scholarship capacity has been updated.");

        
    }
    public void viewAllrecords(){
          Config con = new Config();
        
      
     String viewQuery = "SELECT ScholarshipRecords.ScholarshipRecords_ID, Applicant.First_Name, Applicant.Last_Name, Applicant.Email, "
             + "Scholarships.Scholarship_name, ScholarshipRecords.Date_Applied, Scholarships.Full_Amount, ScholarshipRecords.Status "
             + "FROM ScholarshipRecords "
             + "LEFT JOIN Applicant ON Applicant.ID = ScholarshipRecords.Applicant_ID "
             + "LEFT JOIN Scholarships ON Scholarships.Scholarship_ID = ScholarshipRecords.Scholarship_ID";
            
        String[] header = {"Applied ID ", "First Name", "Last Name", "Email", "Scholarship Name", 
                           "Date Applied", "Full Amount", "Status"};
        String[] columns = {"ScholarshipRecords_ID", "First_Name", "Last_Name", "Email", "Scholarship_name", 
                            "Date_Applied", "Full_Amount", "Status"};
        
     
        con.viewApplicants(viewQuery, header, columns);
    }
    public void approvedRecords(){
          Config con = new Config();
        
      
     String viewQuery = "SELECT ScholarshipRecords.ScholarshipRecords_ID, Applicant.First_Name, Applicant.Last_Name, Applicant.Email, "
             + "Scholarships.Scholarship_name, ScholarshipRecords.Date_Applied, Scholarships.Full_Amount, ScholarshipRecords.Status "
             + "FROM ScholarshipRecords "
             + "LEFT JOIN Applicant ON Applicant.ID = ScholarshipRecords.Applicant_ID "
             + "LEFT JOIN Scholarships ON Scholarships.Scholarship_ID = ScholarshipRecords.Scholarship_ID "
             + "WHERE ScholarshipRecords.Status = 'Approved'";




        String[] header = {"Applied ID ", "First Name", "Last Name", "Email", "Scholarship Name", 
                           "Date Applied", "Full Amount", "Status"};
        String[] columns = {"ScholarshipRecords_ID", "First_Name", "Last_Name", "Email", "Scholarship_name", 
                            "Date_Applied", "Full_Amount", "Status"};
        con.viewApplicants(viewQuery, header, columns);

    }
    public void rejectedRecords(){
         Config con = new Config();
        
      
     String viewQuery = "SELECT ScholarshipRecords.ScholarshipRecords_ID, Applicant.First_Name, Applicant.Last_Name, Applicant.Email, "
             + "Scholarships.Scholarship_name, ScholarshipRecords.Date_Applied, Scholarships.Full_Amount, ScholarshipRecords.Status "
             + "FROM ScholarshipRecords "
             + "LEFT JOIN Applicant ON Applicant.ID = ScholarshipRecords.Applicant_ID "
             + "LEFT JOIN Scholarships ON Scholarships.Scholarship_ID = ScholarshipRecords.Scholarship_ID "
             + "WHERE ScholarshipRecords.Status = 'Rejected'";




        String[] header = {"Applied ID ", "First Name", "Last Name", "Email", "Scholarship Name", 
                           "Date Applied", "Full Amount", "Status"};
        String[] columns = {"ScholarshipRecords_ID", "First_Name", "Last_Name", "Email", "Scholarship_name", 
                            "Date_Applied", "Full_Amount", "Status"};
        con.viewApplicants(viewQuery, header, columns);
    }
    
    public void pendingRecords() {
        Config con = new Config();
        
      
     String viewQuery = "SELECT ScholarshipRecords.ScholarshipRecords_ID, Applicant.First_Name, Applicant.Last_Name, Applicant.Email, "
             + "Scholarships.Scholarship_name, ScholarshipRecords.Date_Applied, Scholarships.Full_Amount, ScholarshipRecords.Status "
             + "FROM ScholarshipRecords "
             + "LEFT JOIN Applicant ON Applicant.ID = ScholarshipRecords.Applicant_ID "
             + "LEFT JOIN Scholarships ON Scholarships.Scholarship_ID = ScholarshipRecords.Scholarship_ID "
             + "WHERE ScholarshipRecords.Status = 'Pending'";




        String[] header = {"Applied ID ", "First Name", "Last Name", "Email", "Scholarship Name", 
                           "Date Applied", "Full Amount", "Status"};
        String[] columns = {"ScholarshipRecords_ID", "First_Name", "Last_Name", "Email", "Scholarship_name", 
                            "Date_Applied", "Full_Amount", "Status"};
        
     
        con.viewApplicants(viewQuery, header, columns);
    }    
    public void viewScholarshipRecords(){
        
        Config con = new Config();
        
        String view = "SELECT * FROM ScholarshipRecords";
         System.out.println("   Scholarsihip Records List: ");
        String[] scholarshipHeader = {"Applied ID", "Applicant ID", "Scholarship ID", "Date Applied", "GPA", "Annual Income","Requirements Pass","Status"};
        String[] scholarshipColumn = {"ScholarshipRecords_ID","Applicant_ID", "Scholarship_ID", "Date_Applied", "GPA", "Annual_Income", "Requirements_Pass","Status"};
        
        con.viewApplicants(view, scholarshipHeader, scholarshipColumn);
    }
    
    public void vRecords(){
        
          
        Config con = new Config();
        
        String view = "SELECT * FROM ScholarshipRecords WHERE Status = 'Pending'";
         System.out.println("   Scholarsihip Records List: ");
        String[] scholarshipHeader = {"Applied ID", "Applicant ID", "Scholarship ID", "Date Applied", "GPA", "Annual Income","Requirements Pass","Status"};
        String[] scholarshipColumn = {"ScholarshipRecords_ID","Applicant_ID", "Scholarship_ID", "Date_Applied", "GPA", "Annual_Income", "Requirements_Pass","Status"};
        
        con.viewApplicants(view, scholarshipHeader, scholarshipColumn);
        
        
    }
    public void viewScholarshipsByApplicantId() {
    Config con = new Config();
    Scanner sc = new Scanner(System.in);

    int applicantId;
    while (true) {
        System.out.print("Enter Applicant ID to view all scholarships they have applied for: ");
        if (sc.hasNextInt()) {
            applicantId = sc.nextInt();
            if (con.getSingleValues("SELECT ID FROM Applicant WHERE ID = ?", applicantId) != 0) {
                break;
            } else {
                System.out.println("Applicant with this ID does not exist.");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid numeric Applicant ID.");
            sc.next(); // clear the invalid input
        }
    }

   
    String viewQuery = "SELECT ScholarshipRecords.ScholarshipRecords_ID, Scholarships.Scholarship_name, "
                       + "ScholarshipRecords.Date_Applied, ScholarshipRecords.Status "
                       + "FROM ScholarshipRecords "
                       + "LEFT JOIN Scholarships ON Scholarships.Scholarship_ID = ScholarshipRecords.Scholarship_ID "
                       + "WHERE ScholarshipRecords.Applicant_ID = ?";

    
    String[] header = {"Applied ID", "Scholarship Name", "Date Applied", "Status"};
    String[] columns = {"ScholarshipRecords_ID", "Scholarship_name", "Date_Applied", "Status"};

   
    con.viewApplicantss(viewQuery, header, columns, applicantId);
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
                System.out.println("    Scholarship Applied Record List: ");
                sr.viewScholarshipRecords();
                 break;
                
            case 3:
                
                sr.viewScholarshipRecords();
                String sqlUpdate = "UPDATE ScholarshipRecords SET GPA = ?, Annual_Income = ?, Requirements_Pass = ?  WHERE ScholarshipRecords_ID = ? ";
                
                int id;
                while (true) {
                System.out.print("Enter Applied ID to Update : ");
                if (sc.hasNextInt()) {
                    id = sc.nextInt();
                    if (con.getSingleValues("SELECT ScholarshipRecords_ID FROM ScholarshipRecords WHERE ScholarshipRecords_ID = ?", id) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Applied Applicant doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid numeric Applied ID.");
                    sc.next(); 
                }
            }
                
                  
                
                System.out.print("Enter new GPA: ");
                double  newGPa = sc.nextDouble();
                System.out.print("Enter new Annual Income: ");
                int newann = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter new Requirements you pass: ");
                String  newreq = sc.nextLine();
                
                con.updateApplicant(sqlUpdate,newGPa,newann,newreq,id);
                break;
                
            case 4:
              sr.viewScholarshipRecords();
                String sqlDELETE = "DELETE FROM ScholarshipRecords WHERE ScholarshipRecords_ID = ?";
              
                   int idDEL;
                while (true) {
                System.out.print("Enter Applied ID to delete : ");
                if (sc.hasNextInt()) {
                    idDEL = sc.nextInt();
                    if (con.getSingleValues("SELECT ScholarshipRecords_ID FROM ScholarshipRecords WHERE ScholarshipRecords_ID = ?", idDEL) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Applied Applicant ID  doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid numeric Applied ID.");
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
