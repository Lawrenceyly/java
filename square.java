package hk.edu.polyu.comp.comp2021.clevis.model;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class square extends JComponent {
    private double x;
    private double y;
    private double l;
    private Graphics g;

    public square( double x, double y, double l) {
        this.x = x;
        this.y = y;
        this.l = l;
    }

    public void paint(Graphics g) {
        Graphics2D gg = (Graphics2D) g;
        Rectangle2D rect = new Rectangle2D.Double(x, y, l, l);
        gg.draw(rect);
    }

    public String info() {
        StringBuilder builder = new StringBuilder();
        builder.append("Type of shape: Square\n");
        builder.append("The top-left corner at location: (");
        builder.append(String.format("%.2f", x) + "," + String.format("%.2f", x) + ")\n");
        builder.append("Length: " + String.format("%.2f", l) + "\n");
        builder.append("Area: " + String.format("%.2f", l*l));
        return builder.toString();
    }
}
