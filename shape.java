package hk.edu.polyu.comp.comp2021.clevis.model;

import javax.swing.*;
import java.awt.*;

public class shape {
    static class node {
        private Object g;
        private String info;
        private String name;
        node next;
        node pre;

        public node(Object g, String n, String info) {
            this.g = g;
            this.name = n;
            this.info = info;
        }
    }
    static  node head;

    public static void insert(Object g, String n, String info) {
        node newNode = new node(g, n, info);
        newNode.next = head;
        newNode.pre = null;
        if (head != null)
            head.pre = newNode;
        head = newNode;
    }

    public static void delete(String n){
        if (NoOfShape() == 0) {NoShapeErr(); return;}
        if (findN(n) == null) {NoThisShapeErr(n); return;}
        if (head == null) {return;}
        node current = findN(n);
        if (head == current) head = current.next;
        if (current.next != null) current.next.pre = current.pre;
        if(current.pre != null) current.pre.next = current.next;
        System.out.println("Shape '"+ n + "' has been deleted!\n");
        return;
    }

    public static void createRect(String n, double x, double y, double w, double h) {
        if (x < 0 || y < 0 || w < 0 || h < 0) {negParErr(); return;}
        rectangle a = new rectangle(x, y, w, h);
        insert(a, n, a.info());
        System.out.println("A rectangle has been created!\n");
    }

    public static void createLine(String n, double x1, double y1, double x2, double y2) {
        if (x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0){negParErr(); return;}
        line a = new line(x1, y1, x2, y2);
        insert(a, n,a.info());
        System.out.println("A line has been created!\n");
    }

    public static void createCircle(String n, double x, double y, double r) {
        if (x < 0 || y < 0 || r < 0){negParErr(); return;}
        circle a = new circle(x, y, r);
        insert(a, n, a.info());
        System.out.println("A circle has been created!\n");
    }

    public static void createSquare(String n, double x, double y, double l) {
        if (x < 0 || y < 0 || l < 0){negParErr(); return;}
        square a = new square(x, y, l);
        insert(a,n,a.info());
        System.out.println("A square has been created!\n");
    }

    public  static void draw(String n){
        if (NoOfShape() == 0) {NoShapeErr(); return;}
        if (findN(n) == null) {NoThisShapeErr(n); return;}

        JFrame f = new JFrame();
        f.setTitle(n);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 300);
        f.getContentPane().add((Component) findN(n).g);
        f.setVisible(true);
    }
    public static void drawAll(){
        if (NoOfShape() == 0) {NoShapeErr(); return;}
        node current = head;
        while(current != null){
            draw(current.name);
            current = current.next;
        }
    }

    public static void NoShapeErr(){
        System.out.println("No shape at all!");
    }

    public  static void NoThisShapeErr(String n){
        System.out.println("No shape called " + n + "!");
    }

    public static void negParErr(){
        System.out.println("No negative parameter is accepted!");
    }


    public static void list(String n){
        if (NoOfShape() == 0) {NoShapeErr(); return;}
        if (findN(n) == null) {NoThisShapeErr(n); return;}
        System.out.println("Name: " + n + "\n");
        System.out.println(findN(n).info + "\n");
    }

    public static void listAll(){
        if (NoOfShape() == 0) {NoShapeErr(); return;}
        node current = head;
        getNoOfShape();
        while(current != null){
            System.out.println("Name: " + current.name);
            System.out.println(current.info + "\n");
            current = current.next;
        }
    }

    public static node findN(String n){
        node current = head;
        while(current != null){
            if (current.name != n) {current = current.next;}
            else return current;
        }
        return null;
    }

    public static int NoOfShape(){
        int c = 0;
        if (head == null) return c;
        node current = head;
        while(current != null){
            c++;
            current = current.next;
        }
        return c;
    }

    public static void getNoOfShape(){
        System.out.println("Now we have " + String.valueOf(NoOfShape()) + " shape(s).");
    }
    
    public static void main(String[] args)  {
        createLine("a", 50,50,100,100);
        createSquare("b", 50,50,100);
        createRect("c", 50,50,50,100);
        createCircle("d", 50,50,50);
    }
}
