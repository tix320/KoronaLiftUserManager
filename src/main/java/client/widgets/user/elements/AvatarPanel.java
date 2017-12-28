package client.widgets.user.elements;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;

/**
 * Panel for selection avatar.
 */
public class AvatarPanel extends Composite {

    /** Form panel to send avatar to server. */
    private final FormPanel formPanel = new FormPanel();

    /** Chooser of avatar. */
    private final FileUpload fileUpload = new FileUpload();

    /**
     * Configure form and file uploader.
     */
    public AvatarPanel() {
        fileUpload.setName("file");
        fileUpload.getElement().setAttribute("accept", "image/*");

        formPanel.setMethod(FormPanel.METHOD_POST);
        formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
        formPanel.setAction(GWT.getHostPageBaseURL() + "file");
        formPanel.setWidget(fileUpload);

        initWidget(formPanel);
    }

    /**
     * Get selected file name.
     *
     * @return file name.
     */
    public String getAvatarFileName() {
        String[] array = fileUpload.getFilename().split("\\\\");
        return array[array.length - 1];
    }

    /**
     * Send avatar to server.
     */
    public void sendAvatar() {
        formPanel.submit();
    }
}
