
        package it2a.cabatuan.sas;


        import java.util.Scanner;


        public class IT2ACABATUANSAS {


            public static void main(String[] args) {


                Scanner sc = new Scanner(System.in);
              int choice; 
              boolean exit  = true;
                do{

                    System.out.print("\033[H\033[2J");
                    System.out.flush();


                System.out.println("=========================================");
                System.out.println("|        SCHOLARSHIP APPLICATION        |");
                System.out.println("|               SYSTEM                  |");
                System.out.println("=========================================");
                System.out.println("");


                System.out.println("          Please select an option:       ");
                System.out.println("-----------------------------------------");
                System.out.println("    1. APPLICANT");
                System.out.println("    2. SCHOLARSHIP");
                System.out.println("    3. SCHOLARSHIP RECORDS");
                System.out.println("    4. HR ONLY");
                System.out.println("    5. EXIT THE APPLICATION");
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
                        System.out.print("Are you an HR? Yes or No: ");
                        String res = sc.next();

                        if (res.equalsIgnoreCase("yes")) {

                        System.out.print("Enter HR password: ");
                        String hrPassword = sc.next();

                        final String HR_PASSWORD = "hr1234";


                        if (hrPassword.equals(HR_PASSWORD)) {
                            Status st = new Status();
                            st.StatusApply(); 
                        } else {
                            System.out.println("Invalid HR password. Access denied.");
                        }
                    } else {
                        System.out.println("You do not have permission to access HR-only features.");
                    }
                    break;

                   case 5:
                        System.out.println("");
                    System.out.print("Are you sure you want to exit? Yes or No:  ");
                     String response = sc.next();
                       if(response.equalsIgnoreCase("yes")){
                           exit = false;
                       }
                       break;

                }

                }while(exit);
                sc.close();
                System.out.println("");
                System.out.println("Thank you for using the application!, See you soon");
            }

        }
