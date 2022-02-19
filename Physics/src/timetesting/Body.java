package timetesting;

import java.awt.*;

public class Body {
    int r;
    int x;
    int y;
    Color color;
    public Body(int x, int y, int r, Color color) {
        this.r = r;
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public boolean intersects(Body b) {
        return Math.sqrt(Math.pow(b.x - x, 2) + Math.pow(b.y - y, 2)) < b.r + r ? true : false;
    }
    public void setColor(Color color) {
        this.color = color;
    }


}
