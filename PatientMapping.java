import java.io.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PatientMapping {
    private Hospital[] HspArray = new Hospital[10000];
    private int totalHospitals = 0;
    private Doctor DoctorArr[] = new Doctor[1000];

    public Hospital[] getHspArray() {
        return HspArray;
    }

    public int getTotalHospitals() {
        return totalHospitals;
    }

    public void HospitalBuilder(String filename) throws FileNotFoundException {
        Hospital[] HspArrayLocal = new Hospital[10000];
        File myObj = new File(filename);
        Scanner myReader = new Scanner(myObj);
        int i = 0;
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
//            System.out.println(line);
            String[] HspStr = line.split("\\|");
            Hospital H1 = new Hospital(Integer.parseInt(HspStr[0]),
                    HspStr[1],
                    Double.parseDouble(HspStr[2]),
                    Double.parseDouble(HspStr[3]),
                    Double.parseDouble(HspStr[4]),
                    HspStr[5],
                    HspStr[6],
                    HspStr[7],
                    Double.parseDouble(HspStr[8]),
                    HspStr[9],
                    HspStr[10]);

            HspArrayLocal[i] = H1;
            i++;
            totalHospitals++;
        }
        this.HspArray = HspArrayLocal;
    }

    public void buildDoctor(String filename) {
        File myObj = new File(filename);
        Scanner myReader;
        int i = 0;
        try {
            myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                System.out.println(line);

                String[] parts = line.split(",");
                Doctor D1 = new Doctor(Integer.parseInt(parts[0]),
                        parts[1],
                        parts[2],
                        Double.parseDouble(parts[3]));

                DoctorArr[i] = D1;
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Doctor[] getDoctorArr() {
        return DoctorArr;
    }

    public int selectDoctor(int index, String dep, String File) {
        this.buildDoctor(File);
        for (int i = 1; i < DoctorArr.length; i++) {
            if (DoctorArr[i].getHospitalID() == index && DoctorArr[i].getDept().equals(dep)) {
                DoctorArr[i].toString();
                return i;
            }
        }
        return 0;
    }

    public Hospital[] recommend(Location l, int n, String File) throws FileNotFoundException {
        this.HospitalBuilder(File);
        System.out.printf("\n\nNearest hospitals are:\n\n", n);
        Hospital temp;
        Hospital[] nearest = new Hospital[totalHospitals];
        for (int i = 0; i < totalHospitals; i++) {
            for (int j = i + 1; j < totalHospitals; j++) {
                if (HspArray[i].getDistance(l) > HspArray[j].getDistance(l)) {
                    temp = HspArray[i];
                    HspArray[i] = HspArray[j];
                    HspArray[j] = temp;
                }
            }
        }
        for (int i = 0, k = 0; (k < n) && (i < HspArray.length); i++) {
            String[] rms = HspArray[i].getRooms().split("-");
            if (rms.length == Integer.parseInt(rms[0]) + 1) {
                continue;
            }
            k++;
            nearest[i] = HspArray[i];
            System.out.println("Hospital " + (k) + " " + HspArray[i].getName() + "  " + HspArray[i].getDistance(l) + "\n");
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
        return nearest;
    }

    public void selectHsp(int index) {

        switch (index) {
            case 1:
                System.out.println(HspArray[0]);
                break;
            case 2:
                System.out.println(HspArray[1]);
                break;
            case 3:
                System.out.println(HspArray[2]);
                break;
            case 4:
                System.out.println(HspArray[3]);
                break;
            case 5:
                System.out.println(HspArray[4]);
                break;
            case 6:
                System.out.println(HspArray[5]);
                break;
            case 7:
                System.out.println(HspArray[6]);
                break;
            case 8:
                System.out.println(HspArray[7]);
                break;
            case 9:
                System.out.println(HspArray[8]);
                break;
            case 10:
                System.out.println(HspArray[9]);
                break;
            default:
                System.out.println("No choice was selected");

        }
    }

    public LabTests[] labTestBuilder(String fileName) {
        LabTests[] labArray = new LabTests[1000];
        File myObj = new File(fileName);
        try {
            Scanner myReader = new Scanner(myObj);
            myReader.nextLine();
            int i = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                String[] str = data.split("\\|");

                String T = str[0]; // Three parts of LabTest data type as in line above.
                int G = Integer.parseInt(str[1]);
                String D = str[2];
                labArray[i] = new LabTests(T, G, D);
                i++;
            }
            int sizeOfArray = --i;
            LabTests[] labArray2 = new LabTests[i];
            for (int j = 0; j < sizeOfArray; j++) {
                labArray2[j] = labArray[j];
            }

            return labArray2;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }


    public LabTests[] labTestPerformed(LabTests[] labArray) {
        int numOfTests;
        numOfTests = (int) (Math.random() * 11);
        ArrayList<Integer> labTestPerformedIndex = new ArrayList<>(numOfTests);
        while (labTestPerformedIndex.size() != numOfTests) {

            int num = (int) (Math.random() * labArray.length);
            if (!labTestPerformedIndex.contains(num)) {
                labTestPerformedIndex.add(num);
            }
        }
        LabTests[] tests = new LabTests[numOfTests];
        System.out.println("\nTHE MEDICAL TESTS TO BE PERFORMED ON YOU\n");
        for (int i = 0; i < numOfTests; i++) {
            System.out.println((i+1) +" "+labArray[labTestPerformedIndex.get(i)]);
            tests[i] = labArray[labTestPerformedIndex.get(i)];
            System.out.println();
        }
        System.out.println("Enter # if you want to have tests: ");
        Scanner scan1 = new Scanner(System.in);
        String str = scan1.nextLine();
        if(str != "#"){
            return tests;
        }else{
            return null;
        }
    }
    

    public static void main(String[] args) throws FileNotFoundException {

        // Hospital - Recommend 10 hospitals. asks to select one of these. Displays all
        // information about the selected hospital.
        // Displays the depts in that hospital and asks to select one of those.
       PatientMapping p1 = new PatientMapping();
        Location l1 = new Location(28.6052154684654, 77.2155121525);
        p1.recommend(l1, 10,"C:\\Users\\Praveen Raj HL\\Desktop/Hospitals.txt");
        Scanner myreader = new Scanner(System.in);
        System.out.println("Enter the Hospital number you chose: ");
        int indexHsp = myreader.nextInt();
        p1.selectHsp(indexHsp);
//        for (int i= 0;i<p1.totalHospitals;i++){
//            System.out.println("--------------------------------------------------------------------");
//            System.out.println(p1.HspArray[i]);
//        }

        System.out.println("--------------------------------------------------------------------");
        System.out.println("The available departments in the chosen hospital are: ");
        String[] deps = p1.HspArray[indexHsp].getDepartments().split(",");
        for (int i = 0; i < deps.length; i++) {
            System.out.println("Department " + (i + 1) + " " + deps[i]);
        }
        System.out.println("Enter the index of preferred department: ");
        int indexDep = myreader.nextInt();
        p1.selectDoctor(indexHsp, deps[indexDep], "C:\\Users\\Praveen Raj HL\\Desktop/Doctors.txt");


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

    }

}
