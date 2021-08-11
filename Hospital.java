import java.util.Scanner;
import java.util.InputMismatchException;

public class Hospital {
    private final int ID;
    private final String name;
    private final double latitude;
    private final double longitude;
    private final double rating;
    private final String number;
    private final String address;
    private final String departments;
    private final double costPerRoom;
    private final String review;
    private final String rooms;

    public String getReview() {
        return review;
    }

    public Hospital(int ID, String name, double latitude, double longitude, double rating, String number, String address, String departments, double costPerRoom, String review, String rooms) {
        this.ID = ID;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rating = rating;
        this.number = number;
        this.address = address;
        this.departments = departments;
        this.costPerRoom = costPerRoom;
        this.review = review;
        this.rooms = rooms;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getRating() {
        return rating;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    public String getDepartments() {
        return departments;
    }
    
    public void printDepts(PatientMapping p1,String DctrFile, MedicalRecords medRec){
        Scanner myreader = new Scanner(System.in);
        System.out.println("The available departments in the chosen hospital are: ");
        String[] deps = this.getDepartments().split(",");
        for (int i = 0; i < deps.length; i++) {
            System.out.println("Department " + (i + 1) + " " + deps[i]);
        }
        int indexDep;
        while(true){
            try{
                System.out.println("Enter the index of preferred department: ");
                indexDep = myreader.nextInt();
                if (indexDep >= 1 && indexDep <= deps.length) {
                    break;
                } else {
                    System.out.println("\n*Invalid Input, Enter value from 1 to " + deps.length + "\n");
                }
            } catch (InputMismatchException i) {
                System.out.println("\n*Invalid input choose from 1 to 10\n");
                myreader.nextLine();
            }

        }
        p1.selectDoctors(this.getID(), deps[indexDep - 1], DctrFile, medRec); 
        
    }

    public double getCostPerRoom() {
        return costPerRoom;
    }

    public Location getLocation() {
        Location l1 = new Location(this.getLatitude(), this.getLongitude());
        return l1;
    }

    public double getDistance(Location l) {
        Location l2 = new Location(this.getLatitude(), this.getLongitude());
        return l2.distanceTo(l);
    }

    public String getRooms() {
        return rooms;
    }

    @Override
    public String toString() {
        String[] revw = review.split("\",");
        String[] rms = rooms.split("-");
        return "Hospital:" + "\n" +
                "ID: " + ID + "\n" +
                "Name: '" + name + '\'' + "\n" +
                "rating= " + rating + "\n" +
                "number= '" + number + '\'' + "\n" +
                "address= '" + address + '\'' + "\n" +
                "departments= '" + departments + '\'' + "\n" +
                "costPerRoom= " + costPerRoom + "\n" +
                "reviews=\n" + revw[0] + "\"" + "\n" + revw[1] + "\"" + "\n" + revw[2] + "\n" +
                "number of rooms= " + rms[0] + "\n";
    }

}

