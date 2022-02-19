package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Bodies {
    private ArrayList<Body> bodies = new ArrayList<Body>();
    Random rand = new Random();
    public Bodies() {

    }
    public void clear() {
        bodies.clear();
    }
    public int size() {
        return bodies.size();
    }
    public Body get(int i) {
        return bodies.get(i);
    }
    public ArrayList<Body> getBodies() {
        return bodies;
    }
    public void spacedFill(int space, int rad, int mass, int x0, int y0, int x1, int y1) {
        clear();
        int X = 0;
        for (int i = 0; 2 * i * rad + (i - 1) * space <= x1 - x0; i++) {
            if (2 * i * rad + (i - 1) * space <= x1 - x0) X = i;
            else break;
        }
        int Y = 0;
        for (int i = 0; 2 * i * rad + (i - 1) * space <= y1 - y0; i++) {
            if (2 * i * rad + (i - 1) * space <= y1 - y0) Y = i;
            else break;
        }
        for (int x = 0; x < X; x++) {
            for (int y = 0; y < Y; y++) {
               // bodies.add(new Body(x0 + x * space + rad, y0 + y * space + rad, 0, 0, mass, rad, new Color((int)(Math.random() * 0x1000000))));
            }
        }

    }

}
