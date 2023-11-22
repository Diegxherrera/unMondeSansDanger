package me.diegxherrera.umsd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameController {
    static String phaseKey = "0";
    protected static final Logger logger = LogManager.getLogger();

    static void nextPhaseKey(String option) {
        String nextPhases = DatabaseManager.retrieveDataFromDatabase("NextPhase");
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
                logger.error("Invalid phase key format.");
            }
        } else {
            logger.error("Not enough phases for Option2.");
        }
    }
}
