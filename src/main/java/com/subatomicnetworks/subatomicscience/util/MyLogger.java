package com.subatomicnetworks.subatomicscience.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

public class MyLogger {

    private Logger logger;
    private boolean showName;

    public MyLogger(Logger logger, boolean showName) {
        this.logger = logger;
        this.showName = showName;
    }

    public void log(Level level, String message) {
        if (this.showName) {
            logger.log(level, "[" + this.logger.getName() + "]: " + message);
        } else {
            logger.log(level, message);
        }
    }

    public void info(String message) {
        this.log(Level.INFO, message);
    }

    public void warn(String message) {
        this.log(Level.WARN, message);
    }

    public void error(String message) {
        this.log(Level.ERROR, message);
    }

    public void debug(String message) {
        this.log(Level.DEBUG, message);
    }

}
