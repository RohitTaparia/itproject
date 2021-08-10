import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        // Hospital - Recommend 10 hospitals. asks to select one of these. Displays all
        // information about the selected hospital.
        // Displays the depts in that hospital and asks to select one of those.
        PatientMapping p1 = new PatientMapping();
        String HspFile = "C:\\Users\\Praveen Raj HL\\Desktop/ITproject.txt";
        String DctrFile = "C:\\Users\\Praveen Raj HL\\Desktop/doctor.txt";
        MedicalRecords medRec = new MedicalRecords("ABC", true, "DEF"); // Medical Record Defined

        Location l1 = new Location(28.6052154684654, 77.2155121525);
        p1.recommend(l1, 10, HspFile);
//        for (int i = 0; i < p1.getNearest().length; i++) {
//            System.out.println(i + "--------------------------------");
//            System.out.println(p1.getNearest()[i]);
//
//        }
        Scanner myreader = new Scanner(System.in);
        System.out.println("Enter the Hospital number you chose: ");
        int indexHsp = myreader.nextInt();
        medRec.setHospital(p1.selectHsp((indexHsp - 1)));  // putting hospital in medical Records and also using selectHsp method
        System.out.println("--------------------------------------------------------------------");
        p1.getNearest()[indexHsp - 1].printDepts(p1, DctrFile, medRec);

        //Room
        Room r1 = new Room(p1.getNearest()[indexHsp - 1].getID(), p1.getNearest()[indexHsp - 1].getName());
        System.out.println("-----------------------------");
        System.out.println("The room alloted is:");
        System.out.println(r1.generateRoom(HspFile));


        // Labtests
        var arr = p1.labTestBuilder("C:\\Users\\Praveen Raj HL\\Desktop/LabTests.txt");
        var tests = p1.labTestPerformed(arr);
        LabTests[] fine = tests[0];
        LabTests[] needsAttention = tests[1];
        medRec.setFineLabTest(fine);
        medRec.setNeedDoctorAttentionTest(needsAttention);

        //Bill
        Bill bill = new Bill(medRec);
        bill.generateBill();
        System.out.println("So your choose mode of payment is : " + bill.billPayMode());
    }
}
