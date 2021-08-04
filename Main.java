import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // Hospital - Recommend 10 hospitals. asks to select one of these. Displays all
        // information about the selected hospital.
        // Displays the depts in that hospital and asks to select one of those.
        PatientMapping p1 = new PatientMapping();
        String HspFile = "itproject/data/Hospitals.txt";
        String DctrFile ="itproject/data/doctor.txt";
        MedicalRecords medRec = new MedicalRecords("ABC",true , "DEF"); // Medical Record Defined

        Location l1 = new Location(28.6052154684654, 77.2155121525);
        p1.recommend(l1, 10, HspFile);
        Scanner myreader = new Scanner(System.in);
        System.out.println("Enter the Hospital number you chose: ");
        int indexHsp = myreader.nextInt();
        medRec.setHospital(p1.selectHsp(indexHsp - 1));  // putting hospital in medical Records and also using selectHsp method
        System.out.println("--------------------------------------------------------------------");
        p1.getHspArray()[indexHsp - 1].printDepts(p1, DctrFile);


        // Labtests
        var arr = p1.labTestBuilder("itproject/data/LabTests.txt");
        var tests = p1.labTestPerformed(arr);
        LabTests[] fine = tests[0];
        LabTests[] needsAttention = tests[1];
        medRec.setFineLabTest(fine);
        medRec.setNeedDoctorAttentionTest(needsAttention);
    }
}
