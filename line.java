package hk.edu.polyu.comp.comp2021.clevis.model;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class line extends JComponent {
    private double x1;
    private double x2;
    private double y1;
    private double y2;

    public line(double x1, double y1, double x2, double y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public void paint(Graphics g) {
        Graphics2D gg = (Graphics2D) g;
        gg.draw(new Line2D.Double(x1, y1, x2, y2));
    }

    public String info() {
        StringBuilder builder = new StringBuilder();
        builder.append("Type of shape: Line\n");
        builder.append("Two ends are at locations: (");
        builder.append(String.format("%.2f", x1) + "," + String.format("%.2f", y1) + ") ");
        builder.append("(" + String.format("%.2f", x2) + "," + String.format("%.2f", y2) + ")\n");
        builder.append("Length: " + String.format("%.2f", Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2))));
        return builder.toString();
    }
}
