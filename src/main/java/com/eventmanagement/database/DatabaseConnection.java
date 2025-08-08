

package com.eventmanagement.database;

import com.eventmanagement.exception.DatabaseException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class DatabaseConnection {
    private static final String CONFIG_FILE = "config.properties";

    public static Connection getConnection() throws SQLException {
        String url = null;
        try (InputStream input = new java.io.FileInputStream(CONFIG_FILE)) {
            Properties prop = new Properties();
            if (input == null) {
                throw new IOException("Unable to find " + CONFIG_FILE);
            }
            prop.load(input);
            url = prop.getProperty("db.url");
        } catch (IOException e) {
            throw new SQLException("Failed to load database configuration", e);
        }
        return DriverManager.getConnection(url);
    }
} 