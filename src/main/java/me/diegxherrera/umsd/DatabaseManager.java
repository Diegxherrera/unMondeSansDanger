package me.diegxherrera.umsd;

import java.sql.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DatabaseManager {
    protected static final Logger logger = LogManager.getLogger();
    DIContainer DBContainer = new DIContainer();
    GameController DBController = DBContainer.getGameController();
    GameFrame DBFrame = DBContainer.getGameFrame();

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
