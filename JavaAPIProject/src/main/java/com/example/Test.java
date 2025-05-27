package com.example;

import java.awt.FlowLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Test {
    public static void main(String[] args) throws Exception {
        URL url = new URL(API.getData("https://api.thecatapi.com/v1/images/search"));
        System.out.println(url);
        JFrame frame = new JFrame("a");
        frame.setLayout(null);
        frame.setSize(1500, 1000);  
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        label.setBounds(100, 100, 200, 200);
        frame.add(label);
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }
    
}