package me.diegxherrera.umsd;

public class GameController {
    static String phaseKey = "0";

    static void nextPhaseKey(String option) {
        String nextPhases = DatabaseManager.retrieveDataFromDatabase(phaseKey, "NextPhase");
        String[] availablePhases = nextPhases.split(",");

        if (availablePhases.length >= 2) {
            String selectedPhase = option.equals("Option1") ?
                    availablePhases[0] : availablePhases[1];
            String[] phaseKeyArray = selectedPhase.split("");

            if (phaseKeyArray.length >= 2) {
                if (phaseKeyArray[0].equals("O") || phaseKeyArray[0].equals("W")) {
                    phaseKey = selectedPhase;
                    GameFrame.showEndingFrames();
                } else {
                    phaseKey = selectedPhase;
                    GameFrame.updateUI();
                }
            } else {
                System.out.println("Invalid phase key format.");
            }
        } else {
            System.out.println("Not enough phases for Option2.");
        }
    }
}
