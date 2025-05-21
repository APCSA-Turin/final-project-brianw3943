package com.example;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;


import org.json.JSONObject;
public class App extends JPanel implements ActionListener
{
    private int count = 0;
    private int[] position = {0, 100};     // [x, y]
    private Image sprite;
    private Timer timer;
    JButton button;
    JButton start;
    JLabel label;
    public App() throws Exception {
        setLayout(null);
        button = new JButton();
        button.setPreferredSize(new Dimension(30, 30));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setLayout(null);
        button.setBounds(0, 100, 30, 30);
        this.add(button);
        start = new JButton("Start");
        start.setPreferredSize(new Dimension(100, 30));
        start.setBounds(900, 0, 100, 30);
        start.addActionListener(this);
        this.add(start);
        label = new JLabel("Score: " + count);
        this.add(label);
        label.setPreferredSize(new Dimension(50, 20));
        label.setBounds(10,10,100,20);
        URL url = new URL("https://api.thecatapi.com/v1/images/search");
        BufferedImage image = ImageIO.read(url);
        ImageIcon icon = new ImageIcon(image);
        sprite = icon.getImage();
        timer = new Timer(20, this);
        timer.start();
        
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(sprite,position[0],position[1],50,50, this);

        /*Uncomment below and comment above command if you want to use Java Swings native shapes like a circle instead of an image*/
        g.setColor(Color.BLUE);
        g.fillOval(position[0], position[1], 30, 30); // Draw a blue ball
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            label.setText("Score: " + count);
            count++;
            int random = (int) (Math.random() * 1760) + 100;
            int random2 = (int) (Math.random() * 920) + 50;
            position[0] = random;
            position[1] = random2;
            Dimension size = button.getPreferredSize();
            button.setBounds(random, random2, size.width, size.height);
            repaint();
        } else if (e.getSource() == start) {
            count++;
            start.setVisible(false);
            start.removeActionListener(this);
            button.addActionListener(this);
        } else {
            
        }
    }
    public static void main( String[] args ) throws Exception
    {
        JFrame frame = new JFrame("a");
        App game = new App();
        frame.add(game);
        frame.setSize(1920, 1030);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);
    }
}
