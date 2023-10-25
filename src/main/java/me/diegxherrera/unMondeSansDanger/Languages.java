package net.diegxherrera.story;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

public class Languages {
    public static void main() {
        // Frame declaration
        JFrame frame = new JFrame("Conversational Game | DHR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel gradientPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();
                Color color1 = Color.LIGHT_GRAY;
                Color color2 = getBackground();
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);
                g2d.setPaint(gp);
                g2d.fill(new Rectangle2D.Double(0, 0, width, height));
            }
        };
        
        frame.setContentPane(gradientPanel);
        
        // Welcome title + body
        JLabel MainTitle = new JLabel("Select Language / Elige el idioma", SwingConstants.CENTER);
        MainTitle.setBorder(new EmptyBorder(20, 10, 10, 10));
        MainTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));

        // Available in different languages
        JLabel Body = new JLabel("<HTML><center>Available in English / Disponible en español / Disponibile in Italiano / Disponible en français / Disponível em Português / Verfügbar auf Deutsch / 可用于中文 / 日本語で利用可能 / متاح باللغة العربية<center></HTML>", SwingConstants.CENTER);
        Body.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        Body.setBorder(new EmptyBorder(0, 40, 0, 10));

        // Button declarations
        JButton englishButton = new JButton("English");
        JButton spanishButton = new JButton("Español");
        JButton italianButton = new JButton("Italiano");
        JButton frenchButton = new JButton("Français");
        JButton portugueseButton = new JButton("Português");
        JButton germanButton = new JButton("Deutsch");
        JButton mandarinButton = new JButton("中文");
        JButton japaneseButton = new JButton("日本語");
        JButton arabicButton = new JButton("العربية");

        // Create a JPanel to organize the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); // Make the button panel transparent
        buttonPanel.add(englishButton);
        englishButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                Welcome welcome = new Welcome();
                welcome.displayWelcomeFrame("English");
            }
        });
        buttonPanel.add(spanishButton);
        spanishButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                Welcome welcome = new Welcome();
                welcome.displayWelcomeFrame("Spanish");
            }
        });
        buttonPanel.add(italianButton);
        italianButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                Welcome welcome = new Welcome();
                welcome.displayWelcomeFrame("Italian");
            }
        });
        buttonPanel.add(frenchButton);
        frenchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                Welcome welcome = new Welcome();
                welcome.displayWelcomeFrame("French");
            }
        });
        buttonPanel.add(portugueseButton);
        portugueseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                Welcome welcome = new Welcome();
                welcome.displayWelcomeFrame("Portuguese");
            }
        });
        buttonPanel.add(germanButton);
        germanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                Welcome welcome = new Welcome();
                welcome.displayWelcomeFrame("German");
            }
        });
        buttonPanel.add(mandarinButton);
        mandarinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                Welcome welcome = new Welcome();
                welcome.displayWelcomeFrame("Mandarin");
            }
        });
        buttonPanel.add(japaneseButton);
        japaneseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                Welcome welcome = new Welcome();
                welcome.displayWelcomeFrame("Japanese");
            }
        });
        buttonPanel.add(arabicButton);
        arabicButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                Welcome welcome = new Welcome();
                welcome.displayWelcomeFrame("Arabic");
            }
        });
        buttonPanel.setBorder(new EmptyBorder(0, 10, 50, 10));

        // Add components to the gradient panel
        gradientPanel.setLayout(new BorderLayout());
        gradientPanel.add(MainTitle, BorderLayout.NORTH);
        gradientPanel.add(Body, BorderLayout.CENTER);
        gradientPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
