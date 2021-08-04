import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class distenceArray {
    public static Location[] location = new Location[58];

    @SuppressWarnings("SpellCheckingInspection")
    public static void main() {
        File file = new File("/home/lohith/IdeaProjects/gui/src/hospital.txt");
        BufferedReader br;
        int j = 0;
        try {
            br = new BufferedReader(new FileReader((file)));
            String st;
            while ((st = br.readLine()) != null) {
                String[] arr = st.split(",");
                Scanner scanner = new Scanner(arr[1]);
                double lat, lon;
                while (!scanner.hasNextDouble()) {
                    scanner.next();
                }
                lat = scanner.nextDouble();
                // System.out.print(lat);
                Scanner scanner2 = new Scanner(arr[2]);
                while (!scanner2.hasNextDouble()) {
                    scanner2.next();
                }
                lon = scanner2.nextDouble();
                //System.out.print(","+lon+",");
                location[j] = new Location(lat, lon);
                j++;
                scanner.close();
                scanner2.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // public static double[] getarr(Location ulocation) {
    //     main();
    //     double[] distence = new double[58];
    //     for (int i = 0; i < 58; i++) {
    //         distence[i] = Location.getdistence(location[i], ulocation);
    //     }
    //     return distence;
    // }

}





