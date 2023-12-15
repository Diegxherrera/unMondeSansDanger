package me.diegxherrera.umsd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The GameController class manages game logic and state transitions based on user interactions.
 * It utilizes dependency injection for integrating various components like GameFrame and DatabaseManager.
 */
public class GameController {
    String phaseKey = "0";
    protected static final Logger logger = LogManager.getLogger(GameController.class);

    // Dependency injection fields
    private final DIContainer container;
    private GameFrame controllerFrame;
    private DatabaseManager controllerDBManager;

    /**
     * Constructor for GameController.
     * Initializes the class with dependencies from the provided DIContainer.
     *
     * @param container The DIContainer instance providing necessary dependencies.
     */
    public GameController(DIContainer container) {
        this.container = container;
        this.controllerFrame = container.getGameFrame();
        this.controllerDBManager = container.getDatabaseManager();
    }

    /**
     * Sets or updates the dependencies from the provided DIContainer.
     * This method is used for dependency injection.
     *
     * @param container The DIContainer instance providing new dependencies.
     */
    public void setDependencies(DIContainer container) {
        this.controllerFrame = container.getGameFrame();
        this.controllerDBManager = container.getDatabaseManager();
    }

    /**
     * Processes the player's choice and updates the game phase accordingly.
     * This method determines the next phase of the game based on the user's selection
     * and updates the game state and UI.
     *
     * @param option The player's choice that determines the next phase.
     */
    void nextPhaseKey(String option) {
        String nextPhases = controllerDBManager.retrieveDataFromDatabase("NextPhase");
        String[] availablePhases = nextPhases.split(",");

        if (availablePhases.length >= 2) {
            String selectedPhase = option.equals("Option1") ?
                    availablePhases[0] : availablePhases[1];
            String[] phaseKeyArray = selectedPhase.split("");

            if (phaseKeyArray.length >= 2) {
                if (phaseKeyArray[0].equals("O") || phaseKeyArray[0].equals("W")) {
                    phaseKey = selectedPhase;
                    controllerFrame.showEndingFrames();
                } else {
                    phaseKey = selectedPhase;
                    controllerFrame.updateUI();
                }
            } else {
                logger.error("Invalid phase key format.");
            }
        } else {
            logger.error("Not enough phases for Option2.");
        }

    }
}
