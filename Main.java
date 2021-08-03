import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // Hospital - Recommend 10 hospitals. asks to select one of these. Displays all
        // information about the selected hospital.
        // Displays the depts in that hospital and asks to select one of those.
       PatientMapping p1 = new PatientMapping();
        MedicalRecords medRec = new MedicalRecords("ABC",true , "DEF"); // Medical Record Defined

        Location l1 = new Location(28.6052154684654, 77.2155121525);
        p1.recommend(l1, 10, "C:\\Users\\Praveen Raj HL\\Desktop/ITproject.txt");
        Scanner myreader = new Scanner(System.in);
        System.out.println("Enter the Hospital number you chose: ");
        int indexHsp = myreader.nextInt();
        medRec.setHospital(p1.selectHsp(indexHsp - 1));  // putting hospital in medical Records and also using selectHsp method

        System.out.println("--------------------------------------------------------------------");
        System.out.println("The available departments in the chosen hospital are: ");
        String[] deps = p1.HspArray[indexHsp - 1].getDepartments().split(",");
        for (int i = 0; i < deps.length; i++) {
            System.out.println("Department " + (i + 1) + " " + deps[i]);
        }
        System.out.println("Enter the index of preferred department: ");
        int indexDep = myreader.nextInt();
        p1.selectDoctor(p1.HspArray[indexHsp - 1].getID(), deps[indexDep - 1], "C:\\Users\\Praveen Raj HL\\Desktop/Doctor.txt");
        System.out.println("Enter the index of the preferred doctor ");
        int SlOfDoc = myreader.nextInt();
        int indexDoc = p1.slctDoctorArray(p1.HspArray[indexHsp - 1].getID(), deps[indexDep - 1], "C:\\Users\\Praveen Raj HL\\Desktop/Doctor.txt")[SlOfDoc - 1];
        System.out.println("The selected doctor is ");
        System.out.println(p1.DoctorArr[indexDoc]);

        medRec.setDoctor(p1.DoctorArr[indexDoc]);

        // Labtests
        var arr = p1.labTestBuilder("src/data/LabTests.txt");
        var tests = p1.labTestPerformed(arr);
        LabTests[] fine = new LabTests[100];
        LabTests[] needsAttention = new LabTests[100];
        for (int i = 0, j = 0, k = 0; i < tests.length; i++) {
            if (tests[i].Result() == 1) {
                fine[j] = tests[i];
                j++;
            } else {
                needsAttention[k] = tests[i];
                k++;
            }
        }

        medRec.setFineLabTest(fine);
        medRec.setNeedDoctorAttentionTest(needsAttention);
    }
}
