package hk.edu.polyu.comp.comp2021.clevis.model;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class circle extends JComponent {
    private double x;
    private double y;
    private double r;

    public circle(double x, double y, double r){
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public void paint(Graphics g){
        Graphics2D gg = (Graphics2D) g;
        Shape circle = new Ellipse2D.Double(x - r, y - r, r * 2.0, r * 2.0);
        gg.draw(circle);
    }

    public void move(double x, double y){
        this.x += x;
        this.y += y;
    }

    public String info() {
        StringBuilder builder = new StringBuilder();
        builder.append("Type of shape: Circle\n");
        builder.append("The center at location: (");
        builder.append(String.format("%.2f", x) + "," + String.format("%.2f", x) + ")\n");
        builder.append("Radius: " + String.format("%.2f", r) + "\n");
        builder.append("Area: " + String.format("%.2f", Math.PI* r*r));
        return builder.toString();
    }

}
