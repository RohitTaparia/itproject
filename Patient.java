package Graded.RealITProject;

public class Patient {
    private final int tokenNo;
    private final String Name;
    private final double latitude;
    private final double longitude;
    private final int age;

    public Patient(int tokenNo, String Name, double latitude, double longitude, int age) {
        this.tokenNo = tokenNo;
        this.Name = Name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "tokenNo=" + tokenNo +
                ", Name='" + Name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", age=" + age +
                '}';
    }

    public int getTokenNo() {
        return tokenNo;
    }

    public String getName() {
        return Name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getAge() {
        return age;
    }
}
