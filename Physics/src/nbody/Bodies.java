package nbody;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Bodies {
    public final int width = 1400;
    public final int height = 800;
    private Physics physics = new Physics(0.1);
    private ArrayList<Body> bodies = new ArrayList<Body>();
    public Bodies() {

    }
    public void add(Body b) {
        b.setDimensions(width, height);
        bodies.add(b);
    }
    public void remove(int i) {bodies.remove(i);}
    public void clear() {
        bodies.clear();
    }
    public int size() {
        return bodies.size();
    }

    public void addForceX(double force, int index) {
        bodies.get(index).addForceX(force);
    }
    public void addForceY(double force, int index) {
        bodies.get(index).addForceY(force);
    }




    public void timeStep(double dt) {
        Body a;
        Body b;
        double force;
        for (int i = 0; i < bodies.size(); i++) {
            for (int j = 0; j < bodies.size(); j++) {
                if (i == j) continue;
                    a = bodies.get(i);
                    b = bodies.get(j);
                    force = physics.calcGravity(bodies.get(i).getX(), bodies.get(i).getY(), bodies.get(i).getMass(), b.getX(), b.getY(), b.getMass());
                    bodies.get(i).setForceX(force * Math.cos(physics.calcAngle(a.getX(), a.getY(),b.getX(), b.getY())));
                    bodies.get(i).setForceY(force * Math.sin(physics.calcAngle(bodies.get(i).getX(), bodies.get(i).getY(),b.getX(), b.getY())));
            }
            System.out.println(bodies.get(i));
        }
        for (int i = 0; i < bodies.size(); i++) {
            bodies.get(i).updatePosition(dt);
        }
        System.out.println("");
    }

    public ArrayList<Body> getBodies() {
        return bodies;
    }
    public Body get(int i) {
        return bodies.get(i);
    }
}
