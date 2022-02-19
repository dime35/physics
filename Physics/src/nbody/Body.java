package nbody;

import java.awt.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Body {
    //constant to control how much velocity decays when an object hits a wall
    private final double DAMPING = 0.5;
    DecimalFormat df = new DecimalFormat("#.####");

    private int width;
    private int height;
    private double r = 1;
    private double x, y = 0;
    private double vx, vy = 0;
    private double fx, fy = 0;
    private double mass = 1;
    private Color color = Color.BLACK;

    public void setDimensions(int wid,int hei) {
        width = wid;
        height = hei;

    }


    public Body (double x, double y, double vx, double vy, double mass, double r, Color color) {
        df.setRoundingMode(RoundingMode.CEILING);
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.mass = mass;
        this.r = r;
        this.color = color;
    }

    public void updatePosition (double dt) {
        vx += dt * fx/mass;
        vy += dt * fy/mass;
        x += dt * vx;
        y += dt * vy;

        if (x < 0) {
            x = 0;
            vx *= -DAMPING;
        }
        if (y < 0) {
            y = 0;
            vy *= -DAMPING;
        }
        if (x > width) {
            x = width;
            vx *= -DAMPING;
        }
        if (y > height) {
            y = height;
            vy *= -DAMPING;
        }

    }

    public boolean isColliding (Body b) {
        double xDif = x - b.getX();
        double yDif = y - b.getY();
        return r + b.r >= Math.sqrt (xDif * xDif + yDif * yDif);
    }
    public void addForceX (double force) {
        fx += force;
    }
    public void addForceY (double force) {
        fy += force;
    }
    public void setForceX(double force) {
        fx = force;
    }
    public void setForceY(double force) {
        fy = force;
    }
    public void setVelocity(double vx, double vy) {
        this.vx = vx;
        this.vy = vy;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public Color getColor() {
        return color;
    }
    public double getR() {
        return r;
    }
    public double getMass() {
        return mass;
    }
    public double getFx() {return fx;}
    public double getFy() {return fy;}
    @Override
    public String toString() {
        return "x: " + x + " y: " + y + " vx: " + vx + " vy: " + vy + " mass: " + mass + " fx " + fx + " fy " + fy;
    }



}