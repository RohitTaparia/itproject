public class Location {
        private final double x;
        private final double y;
        public Location(double latitude,double longitude){
            x=latitude;
            y=longitude;
        }
        public String toString() {
            return x + "," + y ;
        }
        public static double getdistence(Location from, Location to)
        {
            double a=from.x-to.x;
            double b=from.y-to.y;
            return Math.sqrt((a * a) + (b * b));
        }
}
