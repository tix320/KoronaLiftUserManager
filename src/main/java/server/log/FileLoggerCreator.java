package server.log;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Logger creator with file handler.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileLoggerCreator {

    /**
     * Create file logger.
     *
     * @param clazz    is class of logger.
     * @param filePath is path of log file.
     * @return created logger.
     */
    public static Logger createLogger(Class clazz, String filePath) {
        Logger logger = Logger.getLogger(clazz.getName());
        try {
            FileHandler fileHandler = new FileHandler(filePath);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.setUseParentHandlers(false);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logger;
    }
}
