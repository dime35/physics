package timetesting;


import javax.swing.*;
import javax.swing.text.Utilities;
import java.awt.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;

public class TimeTest extends JFrame {

    //int r = 1;
    //int c = 1;
    int bo = 500;
    Random rand = new Random();
    DrawPanel p;

    public TimeTest() {
        p = new DrawPanel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(p);
        pack();
        setVisible(true);

        p.spacedFill(100, 10, 0, 0, 0, 500, 1000);

        // System.out.println("r: " + r + " c:" + c + " b:" + bo + " time:" + (end-start)+"ms");


    }

    public String valueTester(int r, int max) {
        long start = System.currentTimeMillis();

        long end = System.currentTimeMillis();

        return (r + " " + max + " " + (end - start) + " ");
    }

    public static void main(String[] args) {
        TimeTest t = new TimeTest();


    }

    class DrawPanel extends JPanel {
        public ArrayList<Body> bodies = new ArrayList<Body>();

        DrawPanel() {
            setPreferredSize(new Dimension(600, 1000));
        }



        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Body b : bodies) {
                g.setColor(b.color);
                g.fillOval(b.x, b.y, b.r, b.r);
            }
        }

        public void spacedFill(int space, int rad, int mass, int x0, int y0, int x1, int y1) {
            bodies.clear();
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
                    bodies.add(new Body(x0 + x * space + rad, y0 + y * space + rad, rad, new Color((int) (Math.random() * 0x1000000))));
                }
            }
            repaint();
        }
    }
}
