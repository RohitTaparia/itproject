import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        
        PatientMapping p1 = new PatientMapping();
        String HspFile = "itproject/data/Hospitals.txt";
        String DctrFile = "itproject/data/doctor.txt";
        MedicalRecords medRec = new MedicalRecords("ABC", true, "DEF"); // Medical Record Defined

        Location l1 = new Location(28.6052154684654, 77.2155121525);
        p1.recommend(l1, 10, HspFile);
        
        
        // Hospital - Recommend 10 hospitals. asks to select one of these. Displays all
        // information about the selected hospital.
        // Displays the depts in that hospital and asks to select one of those.
        Scanner myreader = new Scanner(System.in);
        
        //        Patient
        p1.buildPatient(PatientFile);
        int token;
        while (true) {
            System.out.println("Enter the token number");
            token = myreader.nextInt();
            if (token <= p1.getTotalPatients() && token >= 1) {
                break;
            } else {
                System.out.println("\n*Invalid input choose from 1 to " + p1.getTotalPatients() + "\n");
            }
        }
        Location l1 = new Location(p1.PatientArr[token - 1].getLatitude(), p1.PatientArr[token - 1].getLongitude());
        medRec.setPatName(p1.PatientArr[token - 1].getName());
        medRec.setPatAge(p1.PatientArr[token - 1].getAge());
        p1.recommend(l1, 10, HspFile);
        
        
        int indexHsp;
        while (true) {
            try {
                System.out.println("Enter the Hospital number you chose: ");

                indexHsp = myreader.nextInt();

                if (indexHsp <= 10 && indexHsp >= 1) {
                    break;
                } else {
                    System.out.println("\n*Invalid input choose from 1 to 10\n");
                }
            } catch (InputMismatchException i) {
                System.out.println("\n*Invalid input choose from 1 to 10\n");
                myreader.nextLine();
            }

        }

        medRec.setHospital(p1.selectHsp((indexHsp - 1)));  // putting hospital in medical Records and also using selectHsp method
        System.out.println("--------------------------------------------------------------------");
        p1.getNearest()[indexHsp - 1].printDepts(p1, DctrFile, medRec);

        //Room
        System.out.println("\nEnter # if agree to get admitted");
        Scanner scan1 = new Scanner(System.in);
        String str = scan1.nextLine();
        if (str.equals("#")) {
            medRec.setAdmitted(true);
            Room r1 = new Room(p1.getNearest()[indexHsp - 1].getID(), p1.getNearest()[indexHsp - 1].getName());
            System.out.println("-----------------------------");
            System.out.println("The room alloted is:");
            int room1 = r1.generateRoom(HspFile);
            medRec.setRoom(room1);
            System.out.println(room1);
        }
        else {
            medRec.setAdmitted(false);
        }
        



        // Labtests
        var arr = p1.labTestBuilder("itproject/data/LabTests.txt");
        var tests = p1.labTestPerformed(arr);
        LabTests[] fine = tests[0];
        LabTests[] needsAttention = tests[1];
        medRec.setFineLabTest(fine);
        medRec.setNeedDoctorAttentionTest(needsAttention);
    
        //          MedicalRecords
        System.out.println("\n\n-------------Medical Record-----------------------");
        System.out.println(medRec);
    
    
        //Bill
        Bill bill = new Bill(medRec);
        bill.generateBill();
        while(true){
            String billMode = bill.billPayMode();
            if(billMode != "Invalid Input"){
                System.out.println("So your chosen mode of payment is : " + billMode);
                break;
            }else{
                System.out.println("\n*Invalid Input, choose from 1 to 4");
            }
        }
        

    }
}
