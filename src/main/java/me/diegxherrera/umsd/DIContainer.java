package me.diegxherrera.umsd;

public class DIContainer {
    private final DatabaseManager databaseManager;
    private final GameController gameController;

    public DIContainer() {
        this.databaseManager = new DatabaseManager();
        this.gameController = new GameController(this);
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public GameController getGameController() {
        return gameController;
    }

}
