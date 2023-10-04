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
    public static int storyPhase = 0;
    public static String[] phasesDone;
    public static void openStoryFrame(String language) {
        String[] phases = {
            "0",
            "1A",
            "1B",
            "2A",
            "2B",
            "2C",
            "2D",
            "3A",
            "3B",
            "3C",
            "3D",
            "3E",
            "3F",
            "3H",
            "4A",
            "4B",
            "4C",
            "4D",
            "4E",
            "4F",
            "4G",
            "4H",
            "4I",
            "4J",
            "4K",
            "4L",
            "4M",
            "4N",
            "4O",
            "4P",
            "5A",
            "5B",
            "5C",
            "5D",
            "5E",
            "5F",
            "5G",
            "5H",
            "5I",
            "5J",
            "5K",
            "5L",
            "5M",
            "5N",
            "5O",
            "5P",
            "5Q",
            "5R",
            "5S",
            "5T",
            "5U",
            "5W",
            "5X",
            "5Y",
            "5Z",
            "5AA",
            "5AB",
            "5AC",
            "5AD",
            "5AE",
            "5AF",
            "5AG"
        };
        String phaseKey = storyPhase + "";

        // Hash Map with data
        Map<String, String[]> dataBase = new HashMap<>();

        String[] phase1A = {"valore1", "valore2", "valore3"};
        dataBase.put("phase1A", phase1A);

        String[] phase1B = {"valore1", "valore2", "valore3"};
        dataBase.put("phase1B", phase1B);
        
        String[] phase2A = {"valore1", "valore2", "valore3"};
        dataBase.put("phase2A", phase2A);

        String[] phase2B = {"valore1", "valore2", "valore3"};
        dataBase.put("phase2B", phase2B);

        String[] phase2C = {"valore1", "valore2", "valore3"};
        dataBase.put("phase2C", phase2C);

        String[] phase2D = {"valore1", "valore2", "valore3"};
        dataBase.put("phase2D", phase2D);

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

        JLabel Body = new JLabel(getMainOutput(language), SwingConstants.LEFT);
        Body.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        Body.setBorder(new EmptyBorder(0, 20, 150, 20));

        JPanel Panel = new JPanel();
        JButton O1 = new JButton(getOption1(language));
        JButton O2 = new JButton(getOption2(language));

        O1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                storyPhase = storyPhase++;
                O1.setText("<HTML>Te acercas al ascensor a investigarlo.</HTML>");
                O2.setText("<HTML>Decides salir de la fábrica, sintiendo que tal vez no deberías estar ahí.</HTML>");
                String[] retrievedValues = dataBase.get(e);
                for (String value : retrievedValues) {
                    System.out.println(value);
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
                return "Boulogne-Billancourt, Francia - 2009";
            case "1A":
                return "Fábrica Renault, Boulogne-Billancourt";
            case "1B":
                return "Reprogrammez";
            case "2A":
                return "Traversez le pont et entrez";
            case "2B":
                return "Überquere die Brücke und gehe hinein";
            case "2C":
                return "走过桥，进入";
            case "2D":
                return "橋を渡って中に入る";
            case "3A":
                return "عبر الجسر وادخل";
            case "3B":
                return "Atravesse a ponte e entre";
            default:
                return "Systems failing... help";
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
        openStoryFrame("English");
    }
}
