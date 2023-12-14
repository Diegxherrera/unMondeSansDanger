package me.diegxherrera.umsd;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import static java.awt.Font.PLAIN;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class GameFrame {
    // Dependency Injection fields
    private final DIContainer container;
    private GameController frameController;
    private DatabaseManager frameDBManager;

    // Logger for the program
    protected final Logger logger = LogManager.getLogger();

    // User Interface fields
    private JLabel Location;
    private JLabel Body;
    private JButton Option1;
    private JButton Option2;

    public GameFrame(DIContainer container) {
        this.container = container;
        this.frameController = container.getGameController();
        this.frameDBManager = container.getDatabaseManager();
        initializeComponents();
    }

    public void setDependencies(DIContainer container) {
        this.frameController = container.getGameController();
        this.frameDBManager = container.getDatabaseManager();
    }

    private void initializeComponents() {
        Location = new JLabel(frameDBManager.retrieveDataFromDatabase("Location"));
        Body = new JLabel(frameDBManager.retrieveDataFromDatabase("Body"));
        Option1 = new JButton(frameDBManager.retrieveDataFromDatabase("Option1"));
        Option2 = new JButton(frameDBManager.retrieveDataFromDatabase("Option2"));
    }

    void showEndingFrames() {
        // Declaration and config of the window.
        JFrame frame = new JFrame("Un Monde Sans Danger");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 420);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        String[] phaseKeyArray = frameController.phaseKey.split("");

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

        JLabel Body = new JLabel(frameDBManager.retrieveDataFromDatabase("GameOver"), SwingConstants.CENTER);
        if (phaseKeyArray[0].equals("O")){
            Body = new JLabel("<HTML><center>" + frameDBManager.retrieveDataFromDatabase("GameOver") +
                    "</center></HTML>", SwingConstants.CENTER);
        } else if (phaseKeyArray[0].equals("W")) {
            Body = new JLabel("<HTML><center>Has conseguido llegar al final (realmente no sé cómo). Enhorabuena " +
                    "por ganar en Un Monde Sans Danger</center></HTML>", SwingConstants.CENTER);
        }
        Body.setFont(new Font("Segoe UI", PLAIN, 20));
        Body.setBorder(new EmptyBorder(0, 20, 20, 20));

        JPanel Panel = new JPanel();
        Panel.setOpaque(false);

        JButton O1 = new JButton("Volver al menú.");
        O1.addActionListener(e -> {
            frameController.phaseKey = "0";
            showStoryFrame();
        });

        JButton O2 = new JButton("Cerrar el juego.");
        O2.addActionListener(e -> {
            frame.dispose();
            System.exit(0);
        });

        Panel.add(O1);
        Panel.add(O2);

        JPanel gradientPanel = getLightPanel();
        gradientPanel.setLayout(new BorderLayout());
        gradientPanel.add(MainTitle, BorderLayout.NORTH);
        gradientPanel.add(Body, BorderLayout.CENTER);
        gradientPanel.add(Panel, BorderLayout.SOUTH);

        frame.setContentPane(gradientPanel);
        frame.setVisible(true);
    }
    private JPanel getLightPanel() {
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
    void updateUI() {
        try {
            Location.setText(frameDBManager.retrieveDataFromDatabase("Location"));
            Body.setText(frameDBManager.retrieveDataFromDatabase("Body"));
            Option1.setText(frameDBManager.retrieveDataFromDatabase("Option1"));

            // TODO Refactor to find a way to make the following code mantainable and sustainable.
            if(frameController.phaseKey.equals("2D") || frameController.phaseKey.equals("3G")){
                Option2.setVisible(false);
            } else {
                Option2.setText(frameDBManager.retrieveDataFromDatabase("Option2"));
            }

            logger.info("UI updated successfully.");
        } catch (NullPointerException e) {
            logger.error(e);
        }
    }
    void showStoryFrame() {
        // Declaration of frame disposition and presentation
        String windowName = "Un Monde Sans Danger";
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
        Body.setFont(new Font("Helvetica Neue", PLAIN, 17));
        Option1.setFont(new Font("Helvetica Neue", PLAIN, 13));
        Option2.setFont(new Font("Helvetica Neue", PLAIN, 13));
        Location.setBorder(new EmptyBorder(35, 20, 0, 20));
        Body.setBorder(new EmptyBorder(0, 20, 20, 20));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(Option1);
        buttonPanel.add(Option2);
        buttonPanel.setOpaque(false);

        JPanel mainOutputPanel = new JPanel();
        mainOutputPanel.setLayout(new BoxLayout(mainOutputPanel, BoxLayout.Y_AXIS));
        mainOutputPanel.add(Location);
        mainOutputPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainOutputPanel.add(Body);
        mainOutputPanel.setOpaque(false);

        Option1.addActionListener(e -> frameController.nextPhaseKey("Option1"));
        Option2.addActionListener(e -> frameController.nextPhaseKey("Option2"));

        gradientPanel.setLayout(new BorderLayout());
        gradientPanel.add(buttonPanel, BorderLayout.SOUTH);
        gradientPanel.add(mainOutputPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}