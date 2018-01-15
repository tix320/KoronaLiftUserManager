package server.log;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Logger of users information.
 */
@Stateless
public class UserLogger {

    /** Logger instance. */
    private static final Logger LOGGER = Logger.getLogger(UserLogger.class.getName());

    /** Path of log file. */
    private static final String LOG_PATH = System.getProperty("user.home") + "\\user.log";

    @PersistenceContext(unitName = "TestUnit")
    private EntityManager entityManager;

    /**
     * Initialize file handler of logger.
     */
    @PostConstruct
    public void initLogger() {
        try {
            FileHandler fileHandler = new FileHandler(LOG_PATH);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.setUseParentHandlers(false);
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Log count of users every 5 minutes.
     */
    @Schedule(hour = "*", minute = "*/5")
    public void usersCount() {
        Long usersCount = entityManager.createQuery("SELECT count (user) FROM User user", Long.class).getSingleResult();
        LOGGER.info("count of users: " + usersCount.toString());
    }
}
