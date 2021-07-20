package Graded.ITproject;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PatientMapping {
    private Hospital[] HspArray;
    private int totalHospitals = 0;

    public void HospitalBuilder(String filename) throws FileNotFoundException {
        Hospital[] HspArrayLocal = new Hospital[10000];
        File myObj = new File(filename);
        Scanner myReader = new Scanner(myObj);
        int i = 0;
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            System.out.println(line);
            String[] movieStr = line.split("\\|");
            Hospital movie = new Hospital(Integer.parseInt(movieStr[0]),
                    movieStr[1],
                    Double.parseDouble(movieStr[2]),
                    Double.parseDouble(movieStr[3]),
                    Double.parseDouble(movieStr[4]),
                    movieStr[5],
                    movieStr[6],
                    movieStr[7],
                    Double.parseDouble(movieStr[8]),
                    movieStr[9]);

            HspArrayLocal[i] = movie;
            i++;
            totalHospitals++;
        }
        this.HspArray = HspArrayLocal;
    }

    public Hospital[] recommend(Location l, int n) {
        System.out.printf("\n\ntop %d nearest hospitals are:\n\n", n);
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
        for (int i = 0; i < n; i++) {
            nearest[i] = HspArray[i];
            System.out.println(HspArray[i].toString() + "  " + HspArray[i].getDistance(l) + "\n");
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
        return nearest;
    }



    public static void main(String[] args) throws FileNotFoundException {
        PatientMapping p1 = new PatientMapping();
        Location l1 = new Location(28.60539125203829, 77.05335471101368);
        p1.HospitalBuilder("C:\\Users\\Praveen Raj HL\\Desktop/dummyIT.txt");
        p1.recommend(l1, 10);
    }
}
