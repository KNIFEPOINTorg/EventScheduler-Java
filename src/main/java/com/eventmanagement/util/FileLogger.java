

package com.eventmanagement.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger {
    private static final String LOG_FILE = "event_log.txt";

    public static void log(String message) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String logEntry = String.format("[%s] %s", timestamp, message);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(logEntry);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 