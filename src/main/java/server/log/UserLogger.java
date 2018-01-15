package server.log;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.File;
import java.util.logging.Logger;

/**
 * Logger of users information.
 */
@Stateless
public class UserLogger {

    /** Path of log file. */
    private static final String LOG_PATH = System.getProperty("user.home") + File.separator + "user.log";

    /** Logger instance. */
    private static final Logger LOGGER = FileLoggerCreator.createLogger(UserLogger.class, LOG_PATH);

    @PersistenceContext(unitName = "TestUnit")
    private EntityManager entityManager;

    /**
     * Log count of users every 5 minutes.
     */
    @Schedule(hour = "*", minute = "*/5")
    public void usersCount() {
        Long usersCount = entityManager.createQuery("SELECT count (user) FROM User user", Long.class).getSingleResult();
        LOGGER.info("count of users: " + usersCount.toString());
    }
}
