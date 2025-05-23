package com.example;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("a");
        frame.setSize(600, 600);  
        JLabel label = new JLabel();
        URL url = new URL(API.getData("https://api.thecatapi.com/v1/images/search"));
        System.out.println(url);
        label.setIcon(new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH)));
        frame.add(label);
        frame.pack();
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }
    
}