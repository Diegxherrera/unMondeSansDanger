package me.diegxherrera.umsd;

import java.sql.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DatabaseManager {
    protected static final Logger logger = LogManager.getLogger();

    public static String retrieveDataFromDatabase(String phaseKey, String requestedContent)  {
        String url = "jdbc:mysql://localhost:3306/UMSD";
        String username = "root";
        String password = "rootpassword";

        try {
            // Connection and query
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT " + requestedContent + " FROM " + GameFrame.language + "Phases" + " WHERE phaseKey='" + phaseKey + "'";
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
            logger.error(e);
            if (e.getMessage().contains("No suitable driver was found.")) {
                System.out.println("The MySQL connector driver is missing.");
            } else {
                System.out.println("SQL Error: " + e.getMessage());
            }
            GameFrame.startGameFrame();
        }
        return "resultSet is not working as expected";
    }
}
