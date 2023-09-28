package src.Story;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Welcome {
    public static void main(String args[]) {
        // Create an instance of Welcome and display the frame
        Welcome welcome = new Welcome();
        welcome.displayWelcomeFrame();
    }

    public void displayWelcomeFrame() {
        // Frame declaration
        JFrame frame = new JFrame("Conversational Game | DHR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Welcome title + body
        JLabel MainTitle = new JLabel("Converstational Adventure", SwingConstants.CENTER);
        MainTitle.setBorder(new EmptyBorder(20, 10, 10, 10));
        MainTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));

        JLabel Body = new JLabel("<HTML><center>This story game will give you two or three options, each of them represents a different ending. You have up to 3 stories to choose from.<center></HTML>", SwingConstants.CENTER);
        Body.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        Body.setBorder(new EmptyBorder(0, 10, 100, 10));

        // Showing panel content
        frame.getContentPane().add(BorderLayout.NORTH, MainTitle);
        frame.getContentPane().add(BorderLayout.CENTER, Body);
        frame.setVisible(true);
    }
}