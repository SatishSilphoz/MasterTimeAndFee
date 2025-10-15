package com.Capium.Utilites;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class Log {
	
    public static final Logger logger = LogManager.getLogger(Log.class);

    public static void info(String message) {
        logger.info(message);
    }

    public static void info(String message, String user, String action) {
        ThreadContext.put("user", user);
        ThreadContext.put("action", action);
        logger.info(message);
        ThreadContext.clearAll();
    }

    public static void info(String message, String action) {
        String user = System.getProperty("user.name"); // Automatically fetch logged-in user
        ThreadContext.put("user", user);
        ThreadContext.put("action", action);
        logger.info(message);
        ThreadContext.clearAll();
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }
}
