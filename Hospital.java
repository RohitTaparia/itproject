package Graded.ITproject;

public class Hospital {
    private static final String[][] scans = {{"fg", "dg", "dfdf"}, {"fg", "dg", "dfdf"}, {"fg", "dg", "dfdf"}, {"fg", "dg", "dfdf"}, {"fg", "dg", "dfdf"}};
    private static final String[] depts = {"hbvmsdv","jhcvd","jdshcv","sjhcbjh","shdvsdv"};
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

    public Hospital(int ID, String name, double latitude, double longitude, double rating, String number, String address, String departments, double costPerRoom, String review) {
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
    }

    public static String[][] getScans() {
        return scans;
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

    @Override
    public String toString() {
        return "Hospital{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", rating=" + rating +
                ", number='" + number + '\'' +
                ", address='" + address + '\'' +
                ", departments='" + departments + '\'' +
                ", costPerRoom=" + costPerRoom +
                '}';
    }
}
