package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
//bodies.add(new Body(Math.random() * 600, Math.random() * 980, 0, 0, 60, 20, new Color((int)(Math.random() * 0x1000000))));
public class MainPanel extends JPanel implements KeyListener {

    private Bodies bodies = new Bodies();
    public Timer tick;

    public static int frameTime = 16;

    public MainPanel() {
        tick = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < bodies.size(); i++) {
                    bodies.get(i).updatePosition(1);
                }
                repaint();
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Iterate through bodies, change the color and draw at circle in that position

        for (Body b : bodies.getBodies()) {
            System.out.println(b.getX() + " " + b.getY());
            g.setColor(b.color);
            g.fillOval((int) b.getX(), (int) b.getY(), (int) b.r, (int) b.r);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }


    public void start() {
        //tick.start();
        bodies.spacedFill(50, 20, 5, 0, 0, 500, 500);
        for (int i = 0; i < bodies.size(); i++) {
            bodies.get(i).setVelocity(2, 2);
        }
        tick.start();
    }

   /* public static void main(String[] args ){
        JFrame f = new JFrame("Ball Drop");
        MainPanel p = new MainPanel();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(new Dimension(800,800));
        f.add(p);

        f.setVisible(true);
        p.start();
    }
*/
}

