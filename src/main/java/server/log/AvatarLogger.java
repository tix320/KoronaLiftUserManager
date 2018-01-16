package server.log;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import java.io.File;
import java.util.logging.Logger;

/**
 * Logger of uploading avatar files.
 */
@Stateless
public class AvatarLogger {

    /** Path of avatar revision file. */
    private static final String AVATAR_REVISION_FILE = System.getProperty("user.home") + File.separator + "fileUploadRevision.log";

    /** Logger instance. */
    private static final Logger LOGGER = FileLoggerCreator.createLogger(AvatarLogger.class, AVATAR_REVISION_FILE);

    /**
     * Write uploaded avatar information to file.
     *
     * @param fileName is name of avatar file.
     */
    @Asynchronous
    public void writeAvatarInfo(String fileName) {
        LOGGER.info("Uploaded file name: " + fileName);
    }
}
