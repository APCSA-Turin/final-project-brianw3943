package com.example;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class App extends JPanel implements ActionListener
{
    private int count = 0;
    private int[] position = {0, 100};     // [x, y]
    private Timer timer;
    private Timer timer2;
    private int time = 180;
    private boolean running = false;
    JButton button;
    JButton start;
    JLabel label;
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();
    JFrame frame = new JFrame("Cat Clicker");
    public App() throws Exception {
        setLayout(null);
        frame.add(this);
        frame.setSize(1920, 1030);
        frame.setLayout(null);
        button = new JButton();
        button.setPreferredSize(new Dimension(100, 100));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setLayout(null);
        button.setBounds(0, 100, 100, 100);
        frame.add(button);
        start = new JButton("Start");
        start.setPreferredSize(new Dimension(100, 30));
        start.setBounds(900, 0, 100, 30);
        start.addActionListener(this);
        frame.add(start);
        label = new JLabel("Score: " + count);
        label.setVisible(false);
        frame.add(label);
        label.setPreferredSize(new Dimension(50, 20));
        label.setBounds(10,10,100,20);
        label2.setIcon(new ImageIcon(new ImageIcon(new URL(API.getData("https://api.thecatapi.com/v1/images/search"))).getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH)));
        label2.setBounds(0, 100, 100, 100);
        label2.setVisible(false);
        frame.add(label2);
        label3.setText("Time: " + time + "s");
        label3.setBounds(850,10,100,20);
        label3.setVisible(false);
        frame.add(label3);
        timer = new Timer(20, this);
        timer2 = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                time--;
                label3.setText("Time: " + time + "s");
                if (time <= 0) {
                    endGame();
                }
            }
        });
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        label2.setBounds(position[0],position[1], label2.getWidth(), label2.getHeight());

        /*Uncomment below and comment above command if you want to use Java Swings native shapes like a circle instead of an image*/
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            try {
                label2.setIcon(new ImageIcon(new ImageIcon(new URL(API.getData("https://api.thecatapi.com/v1/images/search"))).getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH)));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            label.setText("Score: " + count);
            count++;
            int random = (int) (Math.random() * 1690) + 100;
            int random2 = (int) (Math.random() * 850) + 50;
            position[0] = random;
            position[1] = random2;
            Dimension size = button.getPreferredSize();
            button.setBounds(random, random2, size.width, size.height);
            label2.setBounds(random, random2, size.width, size.height);
            repaint();
        } else if (e.getSource() == start) {
            running = true;
            time = 180;
            label3.setText("Time: 180s");
            count = 0;
            count++;
            start.setVisible(false);
            start.removeActionListener(this);
            button.addActionListener(this);
            label2.setVisible(true);
            label.setVisible(true);
            label3.setVisible(true);
            timer.start();
            timer2.start();
        } else {

        }
    }
    private void endGame() {
        running = false;
        timer.stop();
        timer2.stop();
        button.setVisible(false);
        button.removeActionListener(this);
        label2.setVisible(false);
        JOptionPane.showMessageDialog(frame, "Final Score: " + (count - 1) + "\nCPS(Cats Per Second): " + (double)(count - 1)/180, "Game Over!", JOptionPane.INFORMATION_MESSAGE);
    }
}
