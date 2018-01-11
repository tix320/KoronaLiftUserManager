package server;

import shared.utils.PathUtils;
import shared.utils.UserAvatarUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Servlet for save avatar on server.
 */
@WebServlet(urlPatterns = "/" + UserAvatarUtils.SERVLET_URL_PATTERN)
@MultipartConfig
public class UserAvatarServlet extends HttpServlet {
    private static final long serialVersionUID = 5989313933863110345L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Part avatar = req.getPart(UserAvatarUtils.FILE_INPUT_NAME);

        byte[] array = new byte[(int) avatar.getSize()];

        readFileFromRequest(avatar, array);

        File file = new File(getServletContext().getRealPath("/" + PathUtils.IMAGES_DIRECTORY + avatar.getSubmittedFileName()));
        file.createNewFile();

        writeFileToDisk(file, array);
    }

    /**
     * Read file from request.
     *
     * @param avatar to get input stream from request and write to array.
     * @param bytes of avatar's array.
     */
    private void readFileFromRequest(Part avatar, byte[] bytes) {
        try (InputStream inputStream = avatar.getInputStream()) {
            inputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read from array and write to disk as a image.
     *
     * @param file  where be written.
     * @param bytes of avatar's array.
     */
    private void writeFileToDisk(File file, byte[] bytes) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
