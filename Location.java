package Graded.ITproject;

public class Location {
    private final double x1;
    private final double y1;

    public Location(double x, double y) {
        x1 = x;
        y1 = y;
    }

    public double getLatitude() {
        return x1;
    }

    public double getLongitude() {
        return y1;
    }

    public double distanceTo(Location l) {
        double radx1 = Math.toRadians(this.x1);
        double radx2 = Math.toRadians(l.x1);
        double rady1 = Math.toRadians(this.y1);
        double rady2 = Math.toRadians(l.y1);
        double d = 60 * Math.toDegrees(Math.acos((Math.sin(radx1) * Math.sin(radx2)) + (Math.cos(radx1) * Math.cos(radx2) * Math.cos(Math.abs(rady1 - rady2)))));
        return d;
    }

    public static void main(String[] args) {
        Location l1 = new Location(13.0033, 76.1004);
        Location l2 = new Location(12.9716, 77.5946);
        System.out.println("The great circle distance (in nautical miles)  between l1 and l2 is " + l1.distanceTo(l2));
    }
}
