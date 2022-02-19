package com.company;

import java.awt.*;

public class Body {
    private static double g = 9.8;
    private boolean isGrounded = false;

    public double r;
    public double px, py;
    public double vx, vy;
    public double fx, fy;
    public double mass;
    public Color color;

    private Body (double px, double py, double vx, double vy, double mass, double r, Color color) {
        this.px = px;
        this.py = py;
        this.vx = vx;
        this.vy = vy;
        this.mass = mass;
        this.r = r;
        this.color = color;
    }
    public void updatePosition (double dt) {
        vx += dt * fx;
        vy += dt * fy;
        px += dt * vx;
        py += dt * vy;
    }
    public boolean isColliding (Body b) {
        double xDif = px - b.px;
        double yDif = py - b.py;
        return r + b.r >= Math.sqrt (xDif * xDif + yDif * yDif);
    }
    public void addForce (Body[] b) {

    }
    public void setVelocity(double vx, double vy) {
        this.vx = vx;
        this.vy = vy;
    }

    public double getX() {
        return px;
    }
    public double getY() {
        return 600 - py;
    }

}
