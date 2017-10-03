package client.widgets;

import client.Utility;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FullNamePanel extends Composite {

    private VerticalPanel fullNamePanel;
    private TextBox boxFirstName;
    private TextBox boxMiddleName;
    private TextBox boxLastName;

    public FullNamePanel() {
        initWidgets();
        setStyles();
        setPlaceHolders();

        initWidget(fullNamePanel);
    }

    /**
     * Initialize widgets and panel.
     */
    private void initWidgets() {
        fullNamePanel = new VerticalPanel();
        boxFirstName = new TextBox();
        boxMiddleName = new TextBox();
        boxLastName = new TextBox();

        fullNamePanel.add(boxFirstName);
        fullNamePanel.add(boxMiddleName);
        fullNamePanel.add(boxLastName);
    }

    /**
     * Set styles to text boxes.
     */
    private void setStyles() {
        boxFirstName.setStyleName("user-form-text-boxes-fio");
        boxMiddleName.setStyleName("user-form-text-boxes-fio");
        boxLastName.setStyleName("user-form-text-boxes-fio");
    }

    /**
     * Set placeholders to text boxes.
     */
    private void setPlaceHolders() {
        Utility.setPlaceHolder(boxFirstName, "Имя");
        Utility.setPlaceHolder(boxMiddleName, "Отчество");
        Utility.setPlaceHolder(boxLastName, "Фамилия");
    }

    public String getFirstName() {
        return boxFirstName.getText();
    }

    public String getMiddleName() {
        return boxMiddleName.getText();
    }

    public String getLastName() {
        return boxLastName.getText();
    }

    public void setFirstName(String text) {
        boxFirstName.setText(text);
    }

    public void setMiddleName(String text) {
        boxMiddleName.setText(text);
    }

    public void setLastName(String text) {
        boxLastName.setText(text);
    }

    public TextBox getBoxFirstName() {
        return boxFirstName;
    }

    public TextBox getBoxMiddleName() {
        return boxMiddleName;
    }

    public TextBox getBoxLastName() {
        return boxLastName;
    }

}
