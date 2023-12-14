package me.diegxherrera.umsd;

import java.sql.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DatabaseManager {
    protected static final Logger logger = LogManager.getLogger();
    private final DIContainer container;
    private GameController DBController;
    private GameFrame DBFrame;

    public DatabaseManager(DIContainer container) {
        this.container = container;
        this.DBController = container.getGameController();
        this.DBFrame = container.getGameFrame();
    }

    public void setDependencies(DIContainer container) {
        this.DBFrame = container.getGameFrame();
        this.DBController = container.getGameController();
    }

    /**
     * This function runs the query to the SQL database using the requestedContent and
     * then returns it in a String. Setting up the query requires of url, username and
     * password to effectively run the Connection making an instance of connection from
     * the JDBC connector
     * @param requestedContent
     * @return Data retrieved in String type
     * @throws SQLException
     */
    public String retrieveDataFromDatabase(String requestedContent)  {
        String url = "jdbc:mysql://localhost:3306/UMSD";
        String username = "root";
        String password = "rootpassword";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT " + requestedContent + " FROM " + "es_ES" + "Phases" +
                    " WHERE phaseKey='" + DBController.phaseKey + "'";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            String data;
            if (resultSet.next()) {
                data = resultSet.getString(requestedContent);
                if ("Body".equals(requestedContent)) {
                    data = "<HTML>" + data + "</HTML>";
                }
                connection.close();
                return data;
            }
        } catch (SQLException e) {
            if (e.getMessage().contains("No suitable driver was found.")) {
                logger.error(e);
            }

            DBFrame.showStoryFrame();
        }
        return "resultSet is not working as expected";
    }
}
