import java.io.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class PatientMapping {
    protected Hospital[] HspArray = new Hospital[10000];
    private int totalHospitals = 0;
    protected Doctor DoctorArr[] = new Doctor[1000];
    private int totalDoctors = 0;
    protected Hospital[] nearest = new Hospital[10];

    public int getTotalDoctors() {
        return totalDoctors;
    }

    public Hospital[] getNearest() {
        return nearest;
    }

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

                String[] parts = line.split(",");
                Doctor D1 = new Doctor(Integer.parseInt(parts[0]),
                        parts[1],
                        parts[2],
                        Double.parseDouble(parts[3]));

                DoctorArr[i] = D1;
                i++;
                totalDoctors++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    public Doctor[] getDoctorArr() {
        return DoctorArr;
    }

    public void selectDoctors(int index, String dep, String File, MedicalRecords medRec) {
        this.buildDoctor(File);
        Scanner myreader = new Scanner(System.in);
        int[] arr = new int[totalDoctors];
        for (int i = 0, k = 0; i < totalDoctors; i++) {
            if (DoctorArr[i].getHospitalID() == index && DoctorArr[i].getDept().equals(dep)) {
                System.out.println("Doctor " + (k + 1));
                System.out.println(DoctorArr[i]);
                System.out.println("-----------------------------------------");
                arr[k] = i;
                k++;
            }
        }
        System.out.println("Enter the index of the preferred doctor ");
        int SlOfDoc = myreader.nextInt();
        int indexDoc = this.slctDoctorArray(index, dep, File)[SlOfDoc - 1];
        System.out.println("The selected doctor is ");
        System.out.println(this.DoctorArr[indexDoc]);
        medRec.setDoctor(this.DoctorArr[indexDoc]);
    }

    public int[] slctDoctorArray(int index, String dep, String File) {
        int[] arr = new int[totalDoctors];
        int k = 0;
        for (int i = 0; i < totalDoctors; i++) {
            if (DoctorArr[i].getHospitalID() == index && DoctorArr[i].getDept().equals(dep)) {
                arr[k] = i;
                k++;
            }
        }
        return arr;
    }

    public Hospital[] recommend(Location l, int n, String File) throws FileNotFoundException {
        this.HospitalBuilder(File);
        System.out.printf("\n\nNearest hospitals are:\n\n", n);
        Hospital temp;
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
            nearest[k-1] = HspArray[i];
            System.out.println("Hospital " + (k) + " " + HspArray[i].getName() + "  " + HspArray[i].getDistance(l) + "\n");
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
        return nearest;
    }

    public Hospital selectHsp(int index) {

        switch (index) {
            case 0:
                System.out.println(nearest[0]);
                return nearest[0];
            case 1:
                System.out.println(nearest[1]);
                return nearest[1];
            case 2:
                System.out.println(nearest[2]);
                return nearest[2];
            case 3:
                System.out.println(nearest[3]);
                return nearest[3];
            case 4:
                System.out.println(nearest[4]);
                return nearest[4];
            case 5:
                System.out.println(nearest[5]);
                return nearest[5];
            case 6:
                System.out.println(nearest[6]);
                return nearest[6];
            case 7:
                System.out.println(nearest[7]);
                return nearest[7];
            case 8:
                System.out.println(nearest[8]);
                return nearest[8];
            case 9:
                System.out.println(nearest[9]);
                return nearest[9];
            default:
                System.out.println("No choice was selected");
                return nearest[0];
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


    public LabTests[][] labTestPerformed(LabTests[] labArray) {
        int numOfTests;
        numOfTests = (int) (Math.random() * 11);
        if (numOfTests == 0 || numOfTests == 1) {
            numOfTests = 2;
        }
        ArrayList<Integer> labTestPerformedIndex = new ArrayList<>();
        while (labTestPerformedIndex.size() < numOfTests) {
            int num = (int) (Math.random() * labArray.length);
            if (!labTestPerformedIndex.contains(num)) {
                labTestPerformedIndex.add(num);
            }
        }
        System.out.println("-------------------------------------------------------------");
        LabTests[] tests = new LabTests[numOfTests];
        System.out.println("\nTHE MEDICAL TESTS TO BE PERFORMED ON YOU\n");
        for (int i = 0; i < numOfTests; i++) {
            System.out.println((i + 1) + " " + labArray[labTestPerformedIndex.get(i)]);
            tests[i] = labArray[labTestPerformedIndex.get(i)];
            System.out.println();
        }
        System.out.println("Enter # if you want to have tests: ");
        Scanner scan1 = new Scanner(System.in);
        String str = scan1.nextLine();
        LabTests[][] testsDividedForFineAndNeedAttention = new LabTests[2][100];
        if (str != "#") {
            for (int i = 0, j = 0, k = 0; i < tests.length; i++) {
                if (tests[i].Result() == 1) {
                    testsDividedForFineAndNeedAttention[0][j] = tests[i];
                    j++;
                } else {
                    testsDividedForFineAndNeedAttention[1][k] = tests[i];
                    k++;
                }
            }
            return testsDividedForFineAndNeedAttention;
        } else {
            return null;
        }
    }

}
