package src.Story;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

class Story {   
    public static void main(String args[]) {
        // Text variables
        String option1 = "Run";
        String option2 = "Option 2";
        String mainOutput = "<HTML>You find yourself at 11 p.m. walking down the streets of the suburban zones after work.</HTML>";
        //int stageCounter = 0;

        JFrame frame = new JFrame("Conversational Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Options panel
        JPanel Panel = new JPanel();
        JButton O1 = new JButton(option1);
        JButton O2 = new JButton(option2);
        Panel.add(O1);
        Panel.add(O2);
        
        // Localización + Descripción
        JLabel Location = new JLabel("<HTML>Shenzhen, China</HTML>", SwingConstants.LEFT);
        Location.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Location.setBorder(new EmptyBorder(35, 20, 0, 20));

        JLabel Body = new JLabel(mainOutput, SwingConstants.LEFT);
        Body.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        Body.setBorder(new EmptyBorder(0, 20, 200, 20));

        //Añadido de los elementos al panel principal
        frame.getContentPane().add(BorderLayout.SOUTH, Panel);
        frame.getContentPane().add(BorderLayout.NORTH, Location);
        frame.getContentPane().add(BorderLayout.CENTER, Body);
        frame.setVisible(true);
    }
}