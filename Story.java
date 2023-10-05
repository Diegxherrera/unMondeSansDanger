
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

public class Story {
    public static int storyPhase = 0;
    public static String[] phasesDone;

    public static void openStoryFrame(String language) {
        String phaseKey = "0";

        // Frame declaration
        JFrame frame = new JFrame("Conversational Game | DHR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // Create a custom JPanel for the gradient background
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

        // Set the gradient panel as the content pane of the frame
        frame.setContentPane(gradientPanel);

        // Location + Body + Panel
        JLabel Location = new JLabel(getLocationText(language, phaseKey), SwingConstants.LEFT);
        System.out.println(phaseKey);
        Location.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Location.setBorder(new EmptyBorder(35, 20, 0, 20));

        JLabel Body = new JLabel(getMainOutput(language, phaseKey), SwingConstants.LEFT);
        Body.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        Body.setBorder(new EmptyBorder(0, 20, 150, 20));

        JPanel Panel = new JPanel();
        JButton O1 = new JButton(getOption1(language, phaseKey));
        JButton O2 = new JButton(getOption2(language, phaseKey));

        O1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                storyPhase = storyPhase++;
                if (phaseKey == "0") {
                    getOption1("Spanish", "1A");
                    getMainOutput("Spanish", "1A");
                    getOption2("Spanish", "1A");
                    getLocationText("Spanish", "1A");
                } else if (phaseKey == "") {

                }

                phasesDone[storyPhase] = storyPhase + "A";
            }
        });

        O2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        Panel.add(O1);
        Panel.add(O2);

        gradientPanel.setLayout(new BorderLayout());
        gradientPanel.add(Panel, BorderLayout.SOUTH);
        gradientPanel.add(Location, BorderLayout.NORTH);
        gradientPanel.add(Body, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private static String getLocationText(String language, String phaseKey) {
        switch (phaseKey) {
            case "0":
                return "Boulogne-Billancourt, Francia";
            case "1A":
                return "Boulogne-Billancourt, Francia";
            case "1B":
                return "Boulogne-Billancourt, Francia";
            case "2A":
                return "Boulogne-Billancourt, Francia";
            case "2B":
                return "Boulogne-Billancourt, Francia";
            case "2C":
                return "Boulogne-Billancourt, Francia";
            case "2D":
                return "Boulogne-Billancourt, Francia";
            case "3A":
                return "Boulogne-Billancourt, Francia";
            case "3B":
                return "Boulogne-Billancourt, Francia";
            case "3C":
                return "Boulogne-Billancourt, Francia";
            case "3D":
                return "Boulogne-Billancourt, Francia";
            case "3E":
                return "Boulogne-Billancourt, Francia";
            case "3F":
                return "Boulogne-Billancourt, Francia";
            case "3H":
                return "Boulogne-Billancourt, Francia";
            case "4A":
                return "Boulogne-Billancourt, Francia";
            case "4B":
                return "Boulogne-Billancourt, Francia";
            case "4C":
                return "Boulogne-Billancourt, Francia";
            case "4D":
                return "Boulogne-Billancourt, Francia";
            case "4E":
                return "Boulogne-Billancourt, Francia";
            case "4F":
                return "Boulogne-Billancourt, Francia";
            case "4G":
                return "Boulogne-Billancourt, Francia";
            case "4H":
                return "Boulogne-Billancourt, Francia";
            case "5A":
                return "Boulogne-Billancourt, Francia";
            case "5B":
                return "Boulogne-Billancourt, Francia";
            default:
                return "LocationText failed.";
        }
    }

    private static String getOption1(String language, String phaseKey) {
        switch (phaseKey) {
            case "0":
                return "Pasas el puente y entras.";
            case "1A":
                return "Te acercas al ascensor a investigarlo.";
            case "1B":
                return "Sigues visitando el sitio web en busca de más archivos de vídeo.";
            case "2A":
                return "Buscas la manera de encenderlo.";
            case "2B":
                return "Le crees y vas al bosque a verlas.";
            case "2C":
                return "Buscar a tus amigos Ulrich, Yumi y Odd para hacerles ver el archivo de vídeos.";
            case "2D":
                return "Continuar.";
            case "3A":
                return "Encender el interruptor.";
            case "3B":
                return "Encender el interruptor.";
            case "3C":
                return "Visitar el Piso -1.";
            case "3D":
                return "Volver al menú.";
            case "3E":
                return "XXXXX";
            case "3F":
                return "Volver al menú.";
            case "3H":
                return "Continuar.";
            case "4A":
                return "Volver al menú.";
            case "4B":
                return "Boulogne-Billancourt, Francia";
            case "4C":
                return "Boulogne-Billancourt, Francia";
            case "4D":
                return "Boulogne-Billancourt, Francia";
            case "4E":
                return "Boulogne-Billancourt, Francia";
            case "4F":
                return "Boulogne-Billancourt, Francia";
            case "4G":
                return "Boulogne-Billancourt, Francia";
            case "4H":
                return "Volver al menú.";
            case "5B":
                return "Boulogne-Billancourt, Francia";
            default:
                return "LocationText failed.";
        }
    }
    
    private static String getOption2(String language, String phaseKey) {
        switch (phaseKey) {
            case "0":
                return "Lo ignoras y vuelves a casa.";
            case "1A":
                return "Decides salir de la fábrica.";
            case "1B":
                return "Vas directamente a la fábrica en búsqueda de la sala de los vídeos.";
            case "2A":
                return "Visitas la sala y vas a otro piso.";
            case "2B":
                return "Le ignoras y le dices que es normal.";
            case "2C":
                return "Ir a la fábrica en búsqueda de respuestas.";
            case "3A":
                return "Decides andar encima del círculo que hay dibujado en el suelo.";
            case "3B":
                return "Decides andar encima del círculo que hay dibujado en el suelo.";
            case "3C":
                return "Visitar el Piso -2";
            case "3D":
                return "Cerrar el juego.";
            case "3E":
                return "XXXXX";
            case "3F":
                return "Cerrar el juego.";
            case "4A":
                return "XXXXX";
            case "4B":
                return "Cerrar el juego.";
            case "4C":
                return "Boulogne-Billancourt, Francia";
            case "4D":
                return "Boulogne-Billancourt, Francia";
            case "4E":
                return "Boulogne-Billancourt, Francia";
            case "4F":
                return "Boulogne-Billancourt, Francia";
            case "4G":
                return "Boulogne-Billancourt, Francia";
            case "4H":
                return "Volver al menú.";
            case "5B":
                return "Boulogne-Billancourt, Francia";
            default:
                return "LocationText failed.";
        }
    }

    private static String getMainOutput(String language, String phaseKey) {
        return "";
    }

    private static String gameOverFrame(String language) {
        JFrame frame = new JFrame("Conversational Game | DHR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JPanel gradientPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();
                Color color1 = Color.LIGHT_GRAY; // Lightest gray
                Color color2 = getBackground(); // Default color
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);
                g2d.setPaint(gp);
                g2d.fill(new Rectangle2D.Double(0, 0, width, height));
            }
        };

        JLabel MainTitle = new JLabel("GAME OVER", SwingConstants.CENTER);
        MainTitle.setBorder(new EmptyBorder(20, 10, 10, 10));
        MainTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));

        JLabel Body = new JLabel("<HTML><center>Lo podrías haber hecho mejor, has elegido una serie de decisiones erróneas que te han llevado a tu situación actual.</center></HTML>", SwingConstants.CENTER);
        Body.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        Body.setBorder(new EmptyBorder(0, 20, 20, 20));

        JPanel Panel = new JPanel();
        JButton O1 = new JButton("Volver al menú.");
        O1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Languages.main();
            }
        });
        JButton O2 = new JButton("Cerrar el juego.");
        O2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });

        Panel.add(O1);
        Panel.add(O2);

        gradientPanel.setLayout(new BorderLayout());
        gradientPanel.add(MainTitle, BorderLayout.NORTH);
        gradientPanel.add(Body, BorderLayout.CENTER);
        gradientPanel.add(Panel, BorderLayout.SOUTH);

        frame.setContentPane(gradientPanel);
        frame.setVisible(true);
        return "";
    }
    
    public static void main(String[] args) {
        gameOverFrame("English");
    }
}