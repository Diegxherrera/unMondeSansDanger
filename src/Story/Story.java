package src.Story;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

public class Story {
    public static void openStoryFrame(String language) {
        JFrame frame = new JFrame("Conversational Game | DHR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setResizable(false);

        // Create a custom JPanel for the gradient background
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

        // Set the gradient panel as the content pane of the frame
        frame.setContentPane(gradientPanel);

        JLabel Location = new JLabel(getLocationText(language), SwingConstants.LEFT);
        Location.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Location.setBorder(new EmptyBorder(35, 20, 0, 20));

        JLabel Body = new JLabel(getMainOutput(language), SwingConstants.LEFT);
        Body.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        Body.setBorder(new EmptyBorder(0, 20, 150, 20));

        JPanel Panel = new JPanel();
        JButton O1 = new JButton(getOption1(language));
        JButton O2 = new JButton(getOption2(language));

        O1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle button click
            }
        });

        O2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
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

    private static String getLocationText(String language) {
        switch (language) {
            case "Spanish":
                return "<HTML>Boulogne-Billancourt, Francia</HTML>";
            case "English":
                return "<HTML>Boulogne-Billancourt, France</HTML>";
            case "Italian":
                return "<HTML>Boulogne-Billancourt, Francia</HTML>";
            case "French":
                return "<HTML>Boulogne-Billancourt, France</HTML>";
            default:
                return "<HTML>Boulogne-Billancourt, France</HTML>";
        }
    }

    private static String getOption1(String language) {
        switch (language) {
            case "Spanish":
                return "Pasas el puente y entras";
            case "English":
                return "Pass the bridge and enter";
            case "Italian":
                return "Passa il ponte e entra";
            case "French":
                return "Traversez le pont et entrez";
            default:
                return "Pass the bridge and enter";
        }
    }

    private static String getOption2(String language) {
        switch (language) {
            case "Spanish":
                return "Lo ignoras y vuelves a casa";
            case "English":
                return "Ignore it and go back home";
            case "Italian":
                return "Ignora e torna a casa";
            case "French":
                return "Ignorez et rentrez chez vous";
            default:
                return "Ignore it and go back home";
        }
    }

    private static String getMainOutput(String language) {
        switch (language) {
            case "Spanish":
                return "<HTML>Acabas de salir de la Academia Kadic y vas de camino a casa pero hoy decides ir a pasear por el bosque y cruzar a ver esa fábrica en la isla de La Seine. El puente aunque esté un poco dañado aún se puede transitar. Parece que uno de los portones de la fábrica abandonada está casi abierta. ¿Qué harás?</HTML>";
            case "English":
                return "<HTML>You've just left Kadic Academy and you're on your way home, but today you decide to take a walk through the forest and visit that factory on La Seine Island. Although the bridge is a bit damaged, it can still be crossed. It seems that one of the gates to the abandoned factory is almost open. What will you do?</HTML>";
            case "Italian":
                return "<HTML>Hai appena lasciato l'Accademia Kadic e sei sulla strada di casa, ma oggi decidi di fare una passeggiata nel bosco e visitare quella fabbrica sull'isola di La Seine. Anche se il ponte è un po' danneggiato, può ancora essere attraversato. Sembra che uno dei cancelli della fabbrica abbandonata sia quasi aperto. Cosa farai?</HTML>";
            case "French":
                return "<HTML>Vous venez de quitter l'Académie Kadic et vous êtes en route pour rentrer chez vous, mais aujourd'hui vous décidez de faire une promenade dans la forêt et de visiter cette usine sur l'île de La Seine. Bien que le pont soit un peu endommagé, il peut toujours être traversé. Il semble qu'une des portes de l'usine abandonnée soit presque ouverte. Que ferez-vous ?</HTML>";
            default:
                return "<HTML>You've just left Kadic Academy and you're on your way home, but today you decide to take a walk through the forest and visit that factory on La Seine Island. Although the bridge is a bit damaged, it can still be crossed. It seems that one of the gates to the abandoned factory is almost open. What will you do?</HTML>";
        }
    }

    public static void main(String[] args) {
        openStoryFrame("Spanish");
    }
}
