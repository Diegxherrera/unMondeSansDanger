package src.Story;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

class Story {
    public static void main(String args[], String language) {
        // Text variables
        String option1 = "";
        String option2 = "";
        String mainOutput = "";
        String secondOutput = "";
        String thirdOutput = "";
        String fourthOutput = "";
        String fifthOutput = "";
        String sixthOutput = "";
        String seventhOutput = "";

        if (language.equals("Spanish")) {
            option1 = "Pasas el puente y entras";
            option2 = "Lo ignoras y vuelves a casa";
            mainOutput = "<HTML>Acabas de salir de la Academia Kadic y vas de camino a casa pero hoy decides ir a pasear por el bosque y cruzar a ver esa fábrica en la isla de La Seine. El puente aunque esté un poco dañado aún se puede transitar. Parece que uno de los portones de la fábrica abandonada está casi abierta. ¿Qué harás?</HTML>";
        } else if (language.equals("English")) {
            option1 = "Pass the bridge and enter";
            option2 = "Ignore it and go back home";
            mainOutput = "<HTML>You've just left Kadic Academy and you're on your way home, but today you decide to take a walk through the forest and visit that factory on La Seine Island. Although the bridge is a bit damaged, it can still be crossed. It seems that one of the gates to the abandoned factory is almost open. What will you do?</HTML>";
        } else if (language.equals("Italian")) {
            option1 = "Passa il ponte e entra";
            option2 = "Ignora e torna a casa";
            mainOutput = "<HTML>Hai appena lasciato l'Accademia Kadic e sei sulla strada di casa, ma oggi decidi di fare una passeggiata nel bosco e visitare quella fabbrica sull'isola di La Seine. Anche se il ponte è un po' danneggiato, può ancora essere attraversato. Sembra che uno dei cancelli della fabbrica abbandonata sia quasi aperto. Cosa farai?</HTML>";
        } else if (language.equals("French")) {
            option1 = "Traversez le pont et entrez";
            option2 = "Ignorez et rentrez chez vous";
            mainOutput = "<HTML>Vous venez de quitter l'Académie Kadic et vous êtes en route pour rentrer chez vous, mais aujourd'hui vous décidez de faire une promenade dans la forêt et de visiter cette usine sur l'île de La Seine. Bien que le pont soit un peu endommagé, il peut toujours être traversé. Il semble qu'une des portes de l'usine abandonnée soit presque ouverte. Que ferez-vous ?</HTML>";
        }
        //int stageCounter = 0;

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

        // Localización + Descripción
        JLabel Location = new JLabel("<HTML>Boulogne-Billancourt, Francia</HTML>", SwingConstants.LEFT);
        Location.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Location.setBorder(new EmptyBorder(35, 20, 0, 20));

        JLabel Body = new JLabel(mainOutput, SwingConstants.LEFT);
        Body.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        Body.setBorder(new EmptyBorder(0, 20, 150, 20));

        // Options panel
        JPanel Panel = new JPanel();
        JButton O1 = new JButton(option1);
        JButton O2 = new JButton(option2);

        O1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        O2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        Panel.add(O1);
        Panel.add(O2);

        // Add components to the gradient panel
        gradientPanel.setLayout(new BorderLayout());
        gradientPanel.add(Panel, BorderLayout.SOUTH);
        gradientPanel.add(Location, BorderLayout.NORTH);
        gradientPanel.add(Body, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}