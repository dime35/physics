package nbody;

public class Physics {
    private double G;
    public Physics(double G) {
        this.G = G;
    }
    public double calcAngle(double x1, double y1, double x2, double y2) {
        //return Math.atan((y2 - y1) / (x2 - x1));
        return Math.atan2((y2 - y1) , (x2 - x1));
    }

    public double calcDistSquare(double x1, double y1, double x2, double y2) {
        return Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2);
    }
    public double calcDist(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
    public double calcGravity(double x1, double y1, double m1, double x2, double y2, double m2) {
        return G * (m1 * m2) / calcDistSquare(x1, y1, x2, y2);
    }
    public double calcGravityX(double x1, double y1, double m1, double x2, double y2, double m2) {
        return (G * (m1 * m2) / calcDistSquare(x1, y1, x2, y2) )* Math.cos(calcAngle(x1, y1, x2, y2));
    }
    public double calcGravityY(double x1, double y1, double m1, double x2, double y2, double m2) {
        return (G * (m1 * m2) / calcDistSquare(x1, y1, x2, y2)) * Math.sin(calcAngle(x1, y1, x2, y2));
    }

}
