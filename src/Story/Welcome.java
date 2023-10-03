package src.Story;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

public class Welcome {
    public void displayWelcomeFrame(String language) {
        String title;
        String bodyLang;
        String proceedButtonText;

        switch (language) {
            case "Spanish":
                title = "Aventura Conversacional";
                bodyLang = "<HTML><center>Este juego de historia te dará dos opciones en cada situación que encuentres, cada una de ellas representa un camino diferente hacia el final. Tienes hasta 2 historias para elegir.<center></HTML>";
                proceedButtonText = "Proceder";
                break;
            case "English":
                title = "Conversational Adventure";
                bodyLang = "<HTML><center>This story game will give you two options in each situation you encounter, each of them represents a different path to the ending. You have up to 2 stories to choose from.<center></HTML>";
                proceedButtonText = "Proceed";
                break;
            case "Italian":
                title = "Avventura Conversazionale";
                bodyLang = "<HTML><center>Questo gioco di storia ti darà due opzioni in ogni situazione che incontri, ognuna di esse rappresenta un percorso diverso verso la fine. Hai fino a 2 storie da cui scegliere.<center></HTML>";
                proceedButtonText = "Procedi";
                break;
            case "Portuguese":
                title = "Aventura Conversacional";
                bodyLang = "<HTML><center>Este jogo de história dar-lhe-á duas opções em cada situação que encontrar, cada uma delas representa um caminho diferente para o final. Tem até 2 histórias para escolher.<center></HTML>";
                proceedButtonText = "Prosseguir";
                break;
            case "French":
                title = "Aventure Conversationnelle";
                bodyLang = "<HTML><center>Ce jeu d'histoire vous donnera deux options dans chaque situation que vous rencontrerez, chacune d'elles représente un chemin différent vers la fin. Vous avez jusqu'à 2 histoires à choisir.<center></HTML>";
                proceedButtonText = "Procéder";
                break;
            case "German":
                title = "Konversationelle Abenteuer";
                bodyLang = "<HTML><center>Dieses Geschichtsspiel bietet Ihnen in jeder Situation zwei Optionen, von denen jede einen anderen Weg zum Ende darstellt. Sie haben bis zu 2 Geschichten zur Auswahl.<center></HTML>";
                proceedButtonText = "Weiter";
                break;
            case "Mandarin":
                title = "会话式冒险";
                bodyLang = "<HTML><center>这个故事游戏将为您提供在遇到的每种情况下的两个选项，它们代表着通往结局的不同路径。您最多可以选择2个故事。<center></HTML>";
                proceedButtonText = "继续";
                break;
            case "Japanese":
                title = "対話型冒険";
                bodyLang = "<HTML><center>このストーリーゲームでは、遭遇する各状況で2つのオプションが提供され、それぞれが結末への異なる道を表しています。最大で2つのストーリーを選択できます。<center></HTML>";
                proceedButtonText = "進む";
                break;
            case "Arabic":
                title = "مغامرة الحوار";
                bodyLang = "<HTML><center>هذه لعبة قصة ستمنحك خيارين في كل موقف تواجهه، حيث يمثل كل منهما مسارًا مختلفًا نحو النهاية. لديك ما يصل إلى 2 قصة للاختيار من بينها.<center></HTML>";
                proceedButtonText = "المضي قدمًا";
                break;
            default:
                title = "Conversational Adventure";
                bodyLang = "<HTML><center>This story game will give you two options in each situation you encounter, each of them represents a different path to the ending. You have up to 2 stories to choose from.<center></HTML>";
                proceedButtonText = "Proceed";
                break;
        }

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
                Color color1 = Color.LIGHT_GRAY; // Lightest gray
                Color color2 = getBackground(); // Default color
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);
                g2d.setPaint(gp);
                g2d.fill(new Rectangle2D.Double(0, 0, width, height));
            }
        };

        // Welcome title + body
        JLabel MainTitle = new JLabel(title, SwingConstants.CENTER);
        MainTitle.setBorder(new EmptyBorder(20, 10, 10, 10));
        MainTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));

        JLabel Body = new JLabel(bodyLang, SwingConstants.CENTER);
        Body.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        Body.setBorder(new EmptyBorder(0, 10, 20, 10)); // Adjusted bottom border

        // Create a panel for the button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10)); // Centered button with vertical spacing
        JButton closeButton = new JButton(proceedButtonText);
        closeButton.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        closeButton.setFocusPainted(false); // Remove the focus border
        closeButton.setPreferredSize(new Dimension(150, 30)); // Set button size
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the window when the button is clicked
                Story.openStoryFrame(language);
            }
        });
        buttonPanel.add(closeButton);

        // Add components to the gradient panel
        gradientPanel.setLayout(new BorderLayout());
        gradientPanel.add(MainTitle, BorderLayout.NORTH);
        gradientPanel.add(Body, BorderLayout.CENTER);
        gradientPanel.add(buttonPanel, BorderLayout.SOUTH); // Add the button panel

        // Set the gradient panel as the content pane of the frame
        frame.setContentPane(gradientPanel);

        frame.setVisible(true);
    }
}
