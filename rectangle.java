package hk.edu.polyu.comp.comp2021.clevis.model;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class rectangle extends JComponent {
    private double x;
    private double y;
    private double w;
    private double h;

    public rectangle(double x, double y, double w, double h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void paint(Graphics g) {
        Graphics2D gg = (Graphics2D) g;
        Rectangle2D rect = new Rectangle2D.Double(x, y, w, h);
        gg.draw(rect);
    }

    public String info() {
        StringBuilder builder = new StringBuilder();
        builder.append("Type of shape: Rectangle\n");
        builder.append("The top-left corner at location: (");
        builder.append(String.format("%.2f", x) + "," + String.format("%.2f", x) + ")\n");
        builder.append("Width: " + String.format("%.2f", w)
                        + "\t" + "Height: " + String.format("%.2f", h) + "\n");
        builder.append("Area: " + String.format("%.2f", w*h));
        return builder.toString();
    }
}
