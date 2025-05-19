package com.example;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


import org.json.JSONObject;
public class App extends JPanel implements ActionListener
{
    private int count = 0;
    private int[] position = {0, 100};     // [x, y]
    private Image sprite;
    private Timer timer;
    public App() {
        sprite = new ImageIcon("https://api.thecatapi.com/v1/images/search").getImage();
        timer = new Timer(20, this);
        timer.start();
    }
    protected void paintComponent(Graphics g) {
        // super.paintComponent(g);
        // g.drawImage(sprite,position[0],position[1],50,50, this);

        /*Uncomment below and comment above command if you want to use Java Swings native shapes like a circle instead of an image*/
        g.setColor(Color.BLUE);
        g.fillOval(position[0], position[1], 30, 30); // Draw a blue ball
    }
    public void actionPerformed(ActionEvent e) {
        count++;
        int random = (int) (Math.random() * 200);
        int random2 = (int) (Math.random() * 200);
        position[0] = random;
        position[1] = random2;
        repaint();
    }
    public static void main( String[] args )
    {
        JFrame frame = new JFrame("Cat Clicker");
        App game = new App();
        frame.add(game);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
