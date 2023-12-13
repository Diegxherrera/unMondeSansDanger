package me.diegxherrera.umsd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameController {
    String phaseKey = "0";
    protected static final Logger logger = LogManager.getLogger();
    private final DIContainer container;

    public GameController(DIContainer container) {
        this.container = container;
    }

    void nextPhaseKey(String option) {
        String nextPhases = ControllerDBManager.retrieveDataFromDatabase("NextPhase");
        String[] availablePhases = nextPhases.split(",");

        if (availablePhases.length >= 2) {
            String selectedPhase = option.equals("Option1") ?
                    availablePhases[0] : availablePhases[1];
            String[] phaseKeyArray = selectedPhase.split("");

            if (phaseKeyArray.length >= 2) {
                if (phaseKeyArray[0].equals("O") || phaseKeyArray[0].equals("W")) {
                    phaseKey = selectedPhase;
                    ControllerFrame.showEndingFrames();
                } else {
                    phaseKey = selectedPhase;
                    ControllerFrame.updateUI();
                }
            } else {
                logger.error("Invalid phase key format.");
            }
        } else {
            logger.error("Not enough phases for Option2.");
        }
    }
}
