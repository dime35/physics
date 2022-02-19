package nbody;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.StandardSocketOptions;
import java.util.ArrayList;
//bodies.add(new Body(Math.random() * 600, Math.random() * 980, 0, 0, 60, 20, new Color((int)(Math.random() * 0x1000000))));
public class Window extends JPanel implements KeyListener {

    private static Bodies bodies = new Bodies();
    public Timer tick;

    public static int frameTime = 16;

    public Window() {
        //Body b1 = new Body(100, 500, 0, .5, 20,5, Color.BLUE);
       // Body b2 = new Body(300, 400, 0, 0, 200, 5, Color.BLACK);
       // Body b3 = new Body(400, 200, 0, 0, 20, 5, Color.BLACK);

       // bodies.add(b1);
       // bodies.add(b2);

       // bodies.add(b3);

        for (int i = 0; i < 1000; i++) {
            int x = (int) (Math.random() * bodies.width);
            int y = (int) (Math.random() * bodies.height);
            bodies.add(new Body(x,y, Math.random() *0.2 - 0.1, Math.random() *0.2 - 0.1, 2, 5, Color.BLACK));
        }
        tick = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bodies.timeStep(1);
                repaint();
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Iterate through bodies, change the color and draw at circle in that position

        for (int i = 0; i < bodies.size(); i++) {
            Body b = bodies.get(i);

            g.setColor(b.getColor());
            g.fillOval((int) b.getX(), (int) b.getY(), (int) b.getR(), (int) b.getR());
           /* g.setColor(Color.RED);
            g.drawLine((int) b.getX(), (int) b.getY(), (int) (b.getX() + sign(b.getFx()) * 2 *b.getR()), (int) (b.getY()));
            g.drawLine((int) b.getX(), (int) b.getY(), (int) (b.getX()), (int) (b.getY() + sign(b.getFy()) * 2 *b.getR()));*/
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
        tick.start();
    }

    public static void main(String[] args ){
        JFrame f = new JFrame("Ball Drop");
        Window p = new Window();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(new Dimension(bodies.width,bodies.height));
        f.add(p);

        f.setVisible(true);
        p.start();
    }
    public int sign(int num) {
        if (num < 0) return -1;
        else return 1;
    }
    public double sign(double num) {
        if (num < 0) return -1;
        else return 1;
    }

}

