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
                    HspStr[9]);

            HspArrayLocal[i] = H1;
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
        p1.HospitalBuilder("C:\\Users\\Durga Supriya HL\\Desktop/ITproject.txt");
        p1.recommend(l1, 10);
    }
}
