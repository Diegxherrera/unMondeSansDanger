package me.diegxherrera.unMondeSansDanger;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.sql.*;

class Frame {
    private static String phaseKey = "0";
    JLabel Location = new JLabel(retrieveDataFromDatabase(phaseKey,"Location")
            , SwingConstants.LEFT);
    JLabel Body = new JLabel(retrieveDataFromDatabase(phaseKey,"Body")
            , SwingConstants.LEFT);
    JButton Option1 = new JButton(retrieveDataFromDatabase(phaseKey,"Option1"));
    JButton Option2 = new JButton(retrieveDataFromDatabase(phaseKey,"Option2"));

    public Frame() {
        startGameFrame();
    }
    private void showEndingFrames() {
        // Declaration and config of the window.
        JFrame frame = new JFrame("Conversational Game | DHR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 420);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JPanel gradientPanel = getLightPanel();
        System.out.println(phaseKey);
        String[] phaseKeyArray = phaseKey.split("");

        String mainText;
        if (phaseKeyArray[0].equals("O")){
            mainText = "GAME OVER";
        } else if (phaseKeyArray[0].equals("W")) {
            mainText = "WINNER!";
        } else {
            mainText = "";
        }
        JLabel MainTitle = new JLabel(mainText, SwingConstants.CENTER);
        MainTitle.setBorder(new EmptyBorder(20, 10, 10, 10));
        MainTitle.setFont(new Font("Segoe UI", Font.BOLD, 50));

        JLabel Body = new JLabel(retrieveDataFromDatabase(phaseKey, "GameOver"), SwingConstants.CENTER);
        if (phaseKeyArray[0].equals("O")){
            Body = new JLabel("<HTML><center>" + retrieveDataFromDatabase(phaseKey, "GameOver") +
                    "</center></HTML>", SwingConstants.CENTER);
        } else if (phaseKeyArray[0].equals("W")) {
            Body = new JLabel("<HTML><center>Has conseguido llegar al final (realmente no sé cómo). Enhorabuena " +
                    "por ganar en Un Monde Sans Danger</center></HTML>", SwingConstants.CENTER);
        }
        Body.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        Body.setBorder(new EmptyBorder(0, 20, 20, 20));

        JPanel Panel = new JPanel();

        JButton O1 = new JButton("Volver al menú.");
        O1.addActionListener(e -> {
            frame.setVisible(false);
            phaseKey = "0";
            startGameFrame();
        });

        JButton O2 = new JButton("Cerrar el juego.");
        O2.addActionListener(e -> {
            frame.dispose();
            System.exit(0);
        });

        Panel.add(O1);
        Panel.add(O2);

        gradientPanel.setLayout(new BorderLayout());
        gradientPanel.add(MainTitle, BorderLayout.NORTH);
        gradientPanel.add(Body, BorderLayout.CENTER);
        gradientPanel.add(Panel, BorderLayout.SOUTH);

        frame.setContentPane(gradientPanel);
        frame.setVisible(true);
    }
    private static JPanel getLightPanel() {
        JPanel gradientPanel;
        gradientPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();
                Color color1 = Color.LIGHT_GRAY;
                Color color2 = Color.WHITE;
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);
                g2d.setPaint(gp);
                g2d.fill(new Rectangle2D.Double(0, 0, width, height));
            }
        };
        return gradientPanel;
    }
    private void updateUI() {
        Location.setText(retrieveDataFromDatabase(phaseKey, "Location"));
        Body.setText(retrieveDataFromDatabase(phaseKey, "Body"));
        Option1.setText(retrieveDataFromDatabase(phaseKey, "Option1"));
        Option2.setText(retrieveDataFromDatabase(phaseKey, "Option2"));
    }
    private void nextPhaseKey(String option) {
        String nextPhases = retrieveDataFromDatabase(phaseKey, "NextPhase");
        String[] availablePhases = nextPhases.split(",");

        if (availablePhases.length >= 2) {
            String selectedPhase = option.equals("Option1") ? availablePhases[0] : availablePhases[1];
            String[] phaseKeyArray = selectedPhase.split("");
            System.out.println(selectedPhase);

            if (phaseKeyArray.length >= 2) {
                if (phaseKeyArray[0].equals("O") || phaseKeyArray[0].equals("W")) {
                    phaseKey = selectedPhase;
                    showEndingFrames();
                } else {
                    phaseKey = selectedPhase;
                    updateUI();
                }
            } else {
                System.out.println("Invalid phase key format.");
            }
        } else {
            System.out.println("Not enough phases for Option2.");
        }
    }
    private String retrieveDataFromDatabase(String phaseKey, String requestedContent) {
        String url = "jdbc:mysql://localhost:3306/UMSD";
        String username = "root";
        String password = "rootpassword";

        try {
            // Connection and query
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT " + requestedContent + " FROM Phases WHERE phaseKey='" + phaseKey + "'";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            String data;
            if (resultSet.next()) {
                data = resultSet.getString(requestedContent);
                if ("Body".equals(requestedContent)) {
                    data = "<HTML>" + data + "</HTML>";
                }
                connection.close();
                return data;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error 1: Data Not Found";
        }
        return "resultSet is not working as expected";
    }
    public JFrame startGameFrame() {
        // Declaration of frame disposition and presentation
        String windowName = "Conversational Game | DHR";
        JFrame frame = new JFrame(windowName);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 420);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // Gradient panel reference and set
        JPanel gradientPanel = getLightPanel();
        frame.setContentPane(gradientPanel);

        // Borders + Font
        Location.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
        Body.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
        Option1.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        Option2.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        Location.setBorder(new EmptyBorder(35, 20, 0, 20));
        Body.setBorder(new EmptyBorder(0, 20, 20, 20));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(Option1);
        buttonPanel.add(Option2);

        JPanel mainOutputPanel = new JPanel();
        mainOutputPanel.setLayout(new BoxLayout(mainOutputPanel, BoxLayout.Y_AXIS));
        mainOutputPanel.add(Location);
        mainOutputPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainOutputPanel.add(Body);

        Option1.addActionListener(e -> nextPhaseKey("Option1"));
        Option2.addActionListener(e -> nextPhaseKey("Option2"));

        gradientPanel.setLayout(new BorderLayout());
        gradientPanel.add(buttonPanel, BorderLayout.SOUTH);
        gradientPanel.add(mainOutputPanel, BorderLayout.CENTER);

        frame.setVisible(true);
        return frame;
    }
}
public class Story {
    public static void main(String[] args) {
        new Frame();
    }
}