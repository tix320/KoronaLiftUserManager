package server;

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
@WebServlet(urlPatterns = "/file")
@MultipartConfig
public class UserAvatarServlet extends HttpServlet {
    private static final long serialVersionUID = 5989313933863110345L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Part avatar = req.getPart("file");

        byte[] array = new byte[(int) avatar.getSize()];

        readFileFromRequest(avatar.getInputStream(), array);

        File file = new File(getServletContext().getRealPath("/images/" + avatar.getSubmittedFileName()));
        file.createNewFile();

        writeFileToDisk(file, array);
    }

    /**
     * Read file from request.
     *
     * @param inputStream for reading from request and write to array.
     * @param bytes       of avatar's array.
     */
    private void readFileFromRequest(InputStream inputStream, byte[] bytes) throws IOException {
        inputStream.read(bytes);
        inputStream.close();

    }

    /**
     * Read from array and write to disk as a image.
     *
     * @param file  where be written.
     * @param bytes of avatar's array.
     */
    private void writeFileToDisk(File file, byte[] bytes) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }

}
