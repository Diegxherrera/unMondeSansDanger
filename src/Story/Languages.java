package src.Story;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Languages {
    public static void main(String args[]) {
        // Frame declaration
        JFrame frame = new JFrame("Conversational Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Welcome title + body
        JLabel MainTitle = new JLabel("Select Language / Elige el idioma", SwingConstants.CENTER);
        MainTitle.setBorder(new EmptyBorder(20, 10, 10, 10));
        MainTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));

        JLabel Body = new JLabel("<HTML><center>Available in English / Disponible en español / Disponibile in Italiano<center></HTML>", SwingConstants.CENTER);
        Body.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        Body.setBorder(new EmptyBorder(0, 40, 0, 10));

        JButton englishButton = new JButton("English");
        JButton spanishButton = new JButton("Español");
        JButton italianButton = new JButton("Italiano");
        
        // Create a JPanel to hold the buttons
        JPanel buttonPanel = new JPanel(); //¡¡Panel!! NOT ButtonGroup, that's not a Component.
        buttonPanel.add(englishButton);
        englishButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                Welcome welcome = new Welcome();
                welcome.displayWelcomeFrame();
            }
        });
        buttonPanel.add(spanishButton);
        buttonPanel.add(italianButton);
        buttonPanel.setBorder(new EmptyBorder(0, 10, 120, 10));

        // Showing panel content
        frame.getContentPane().add(BorderLayout.NORTH, MainTitle);
        frame.getContentPane().add(BorderLayout.CENTER, Body);
        frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
        frame.setVisible(true);
    }
}
