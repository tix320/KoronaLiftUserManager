package shared.utils;

import com.google.gwt.core.client.GWT;

/**
 * Utils for path configurations.
 */
public class PathUtils {

    /** Directory name of images. */
    public static final String IMAGES_DIRECTORY = "images/";

    /** Full path of images storage. */
    public static final String IMAGES_FULL_PATH = GWT.getHostPageBaseURL() + IMAGES_DIRECTORY;


}
