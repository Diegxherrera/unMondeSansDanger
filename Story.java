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

    public static void dataHandler(String L) {
        
        // Permissions verifier
        
        // Write / Open file - Verifying existence
        /*try {
            File phasesFile = new File("phasesFile.json");
            if (phasesFile.createNewFile()) {
                System.out.println("File created: " + phasesFile.getName());
            } else {
                System.out.println("Running opening task...");
                Scanner myReader = new Scanner(phasesFile);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
                myReader.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }*/
    }

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

        String[] phase1A = {"valore1", "valore2", "valore3", "valore4"};
        dataBase.put("phase1A", phase1A);

        String[] phase1B = {"valore1", "valore2", "valore3", "valore4"};
        dataBase.put("phase1B", phase1B);

        String[] phase2A = {"valore1", "valore2", "valore3", "valore4"};
        dataBase.put("phase2A", phase2A);

        String[] phase2B = {"valore1", "valore2", "valore3", "valore4"};
        dataBase.put("phase2B", phase2B);

        String[] phase2C = {"valore1", "valore2", "valore3", "valore4"};
        dataBase.put("phase2C", phase2C);
        
        String[] phase2D = {"valore1", "valore2", "valore3", "valore4"};
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
                O1.setText(".");
                O2.setText(".");
                String[] retrievedValues = dataBase.get("2");
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
        return "";
    }

    private static String getOption1(String language) {
        return "";
    }
    
    private static String getOption2(String language) {
        return "";
    }

    private static String getMainOutput(String language) {
        return "";
    }

    private static String gameOverFrame(String language, String phase) {
        JFrame frame = new JFrame("Conversational Game | DHR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
 
        return "";
    }

    public static void main(String[] args) {
        openStoryFrame("English");
    }
}