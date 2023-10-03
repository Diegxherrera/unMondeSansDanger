package src.Story;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.Map;

public class Story {
    public static void openStoryFrame(String language) {
        int storyPhase = 0;
        
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

        // Set the gradient panel as the content pane of the frame
        frame.setContentPane(gradientPanel);

        // Location + Body + Panel
        JLabel Location = new JLabel(getLocationText(language), SwingConstants.LEFT);
        Location.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Location.setBorder(new EmptyBorder(35, 20, 0, 20));

        // String BodyConditional = (storyPhase == 0) ? actionMap.get(globalKey).run() : System.out.println("Demon") ; 

        JLabel Body = new JLabel(getMainOutput(language), SwingConstants.LEFT);
        Body.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        Body.setBorder(new EmptyBorder(0, 20, 150, 20));

        JPanel Panel = new JPanel();
        JButton O1 = new JButton(getOption1(language));
        JButton O2 = new JButton(getOption2(language));

        // Texts Hash Map
        Map<String, Runnable> actionMap = new HashMap<>();

        actionMap.put("0English", () -> {
            // Your code for storyPhase 2 and Italian
        });
        actionMap.put("0Spanish", () -> {
            // Your code for storyPhase 2 and French
        });
        actionMap.put("0Italian", () -> {
            // Your code for storyPhase 2 and Italian
        });
        actionMap.put("0French", () -> {
            // Your code for storyPhase 2 and French
        });
        actionMap.put("0German", () -> {
            // Your code for storyPhase 2 and German (Deutsch)
        });
        actionMap.put("0Portuguese", () -> {
            // Your code for storyPhase 2 and Portuguese
        });
        actionMap.put("0Mandarin", () -> {
            // Your code for storyPhase 0 and Mandarin
        });
        actionMap.put("0Arabic", () -> {
            // Your code for storyPhase 2 and Arabic
        });
        actionMap.put("0Japanese", () -> {
            // Your code for storyPhase 2 and Japanese
        });

        // -----------------------------------------------

        actionMap.put("1English", () -> {
            // Your code for storyPhase 2 and Italian
        });
        actionMap.put("1Spanish", () -> {
            // Your code for storyPhase 2 and French
        });
        actionMap.put("1Italian", () -> {
            // Your code for storyPhase 2 and Italian
        });
        actionMap.put("1French", () -> {
            // Your code for storyPhase 2 and French
        });
        actionMap.put("1German", () -> {
            // Your code for storyPhase 2 and German (Deutsch)
        });
        actionMap.put("1Portuguese", () -> {
            // Your code for storyPhase 2 and Portuguese
        });
        actionMap.put("1Mandarin", () -> {
            // Your code for storyPhase 0 and Mandarin
        });
        actionMap.put("1Arabic", () -> {
            // Your code for storyPhase 2 and Arabic
        });
        actionMap.put("1Japanese", () -> {
            // Your code for storyPhase 2 and Japanese
        });

        // -----------------------------------------------

        actionMap.put("2Spanish", () -> {
            // Your code for storyPhase 2 and French
        });

        // -----------------------------------------------

        actionMap.put("3Spanish", () -> {
            // Your code for storyPhase 2 and French
        });

        // -----------------------------------------------

        actionMap.put("4Spanish", () -> {
            // Your code for storyPhase 2 and French
        });

        // -----------------------------------------------

        actionMap.put("5Spanish", () -> {
            // Your code for storyPhase 2 and French
        });

        // -----------------------------------------------

        actionMap.put("6Spanish", () -> {
            // Your code for storyPhase 2 and French
        });

        // -----------------------------------------------

        actionMap.put("7Spanish", () -> {
            // Your code for storyPhase 2 and French
        });

        // -----------------------------------------------

        actionMap.put("8Spanish", () -> {
            // Your code for storyPhase i2 and French
        });

        // -----------------------------------------------


        O1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String key = storyPhase + language;
                if (actionMap.containsKey(key)) {
                    actionMap.get(key).run();
                }
            }
        });

        O2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String key = storyPhase + language;
                // globalKey = key;
                if (actionMap.containsKey(key)) {
                    actionMap.get(key).run();
                }
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
                return "<HTML>Boulogne-Billancourt, Francia - 2009</HTML>";
            case "English":
                return "<HTML>Boulogne-Billancourt, France - 2009</HTML>";
            case "Italian":
                return "<HTML>Boulogne-Billancourt, Francia - 2009</HTML>";
            case "French":
                return "<HTML>Boulogne-Billancourt, France - 2009</HTML>";
            case "German":
                return "<HTML>Boulogne-Billancourt, Frankreich - 2009</HTML>";
            case "Mandarin":
                return "<HTML>Boulogne-Billancourt，法国 - 2009</HTML>";
            case "Japanese":
                return "<HTML>ブローニュ＝ビヤンクール、フランス - 2009</HTML>";
            case "Arabic":
                return "<HTML>2009 - بولوني بيانكور، فرنسا</HTML>";
            case "Portuguese":
                return "<HTML>Boulogne-Billancourt, França - 2009</HTML>";
            default:
                return "<HTML>Boulogne-Billancourt, France - 2009</HTML>";
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
            case "German":
                return "Überquere die Brücke und gehe hinein";
            case "Mandarin":
                return "走过桥，进入";
            case "Japanese":
                return "橋を渡って中に入る";
            case "Arabic":
                return "عبر الجسر وادخل";
            case "Portuguese":
                return "Atravesse a ponte e entre";
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
            case "German":
                return "Ignorieren Sie es und gehen Sie nach Hause";
            case "Mandarin":
                return "忽略它，回家";
            case "Japanese":
                return "無視して家に帰る";
            case "Arabic":
                return "تجاهلها وعُد إلى المنزل";
            case "Portuguese":
                return "Ignore e volte para casa";
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
            case "German":
                return "<HTML>Sie haben gerade die Kadic Academy verlassen und sind auf dem Weg nach Hause, aber heute entscheiden Sie sich, einen Spaziergang durch den Wald zu machen und die Fabrik auf der Insel La Seine zu besuchen. Obwohl die Brücke ein wenig beschädigt ist, kann sie immer noch überquert werden. Es scheint, dass eines der Tore zur verlassenen Fabrik fast offen ist. Was werden Sie tun?</HTML>";
            case "Mandarin":
                return "<HTML>你刚刚离开了Kadic学院，正在回家的路上，但今天你决定在森林中散步，参观La Seine岛上的工厂。虽然桥有点破损，但仍然可以过去。</HTML>";
            case "Japanese":
                return "<HTML>Kadic Academyを出てすぐ、家に帰る途中ですが、今日は森を散歩し、La Seine Islandの工場を訪れることに決めました。橋は少し損傷していますが、渡ることはできます。廃工場へのゲートの1つはほぼ開いているようです。あなたは何をしますか？</HTML>";
            case "Arabic":
                return "<HTML>لقد تركت للتو أكاديمية كاديك وأنت في طريق عودتك إلى المنزل، ولكن اليوم قررت أن تتجول في الغابة وتزور تلك المصنع على جزيرة لا سين. على الرغم من أن الجسر قد تضرر قليلاً، إلا أنه يمكن عبوره. يبدو أن أحد أبواب المصنع المهجور مفتوح تقريبًا. ماذا ستفعل؟</HTML>";
            case "Portuguese":
                return "<HTML>Você acabou de sair da Academia Kadic e está a caminho de casa, mas hoje decide fazer uma caminhada pela floresta e visitar aquela fábrica na Ilha de La Seine. Embora a ponte esteja um pouco danificada, ainda é possível atravessar. Parece que um dos portões da fábrica abandonada está quase aberto. O que você vai fazer?</HTML>";
            default:
                return "An error was found.";
        }
    }

    public static void main(String[] args) {
        openStoryFrame("English"); // Change the language to Portuguese
    }
}
