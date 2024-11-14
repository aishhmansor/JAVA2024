/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sample.program;

/**
 *
 * @author User-PC
 */
/*import java.awt.*;
import javax.swing.*;

public class SampleProgram extends JFrame {

   
    public void paint (Graphics g) {
        
        // TODO code application logic here
        super.paint(g);
        
        g.setFont(new Font("Times New Roman", Font.BOLD+Font.ITALIC,24));
        
            g.drawString("This is my first graphic design in Java ",10,20);
            g.setColor(Color.red);
            g.drawLine(5, 30, 380, 30);
            g.setColor(Color.magenta);
            g.fillArc(10, 120, 90, 90, 45, 30);
    }
    
    public static void main(String[] args) {
        SampleProgram frame = new SampleProgram ();
        frame.setVisible(true);
    }
}
*/
import javax.swing.*;
import java.awt.*;

public class JustWatch extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Set anti-aliasing for smoother edges
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Clock dimensions
        int clockRadius = Math.min(getWidth(), getHeight()) / 2 - 10;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        
        // Draw the clock face
        g2.setColor(Color.LIGHT_GRAY);
        g2.fillOval(centerX - clockRadius, centerY - clockRadius, 2 * clockRadius, 2 * clockRadius);
        
        g2.setColor(Color.BLACK);
        g2.drawOval(centerX - clockRadius, centerY - clockRadius, 2 * clockRadius, 2 * clockRadius);

        // Set fixed time (10:10:30)
        int hour = 4;
        int minute = 14;
        int second = 40;
        
        // Draw the clock hands for fixed time
        drawHand(g2, centerX, centerY, (hour % 12 + minute / 60.0) * 30, clockRadius * 0.5, 8, Color.BLACK);  // Hour hand
        drawHand(g2, centerX, centerY, minute * 6, clockRadius * 0.75, 5, Color.BLUE);                         // Minute hand
        drawHand(g2, centerX, centerY, second * 6, clockRadius * 0.9, 2, Color.RED);                           // Second hand

        // Draw minute ticks
        for (int i = 0; i < 60; i++) {
            double angle = Math.toRadians(i * 6);
            int xStart = (int) (centerX + clockRadius * 0.9 * Math.cos(angle));
            int yStart = (int) (centerY - clockRadius * 0.9 * Math.sin(angle));
            int xEnd = (int) (centerX + clockRadius * Math.cos(angle));
            int yEnd = (int) (centerY - clockRadius * Math.sin(angle));
            g2.drawLine(xStart, yStart, xEnd, yEnd);
        }
    }

    private void drawHand(Graphics2D g, int x, int y, double angle, double length, int width, Color color) {
        angle = Math.toRadians(angle - 90); // Convert angle and adjust for 12 o'clock being 0 degrees
        int xEnd = (int) (x + length * Math.cos(angle));
        int yEnd = (int) (y + length * Math.sin(angle));
        
        g.setColor(color);
        g.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g.drawLine(x, y, xEnd, yEnd);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Just Watch");
        JustWatch watch = new JustWatch();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(watch);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
