package client;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.*;

class MainWidgets {

    private static final int MATRIX_MAX_SIZE = 10;
    private static VerticalPanel mainPanel = new VerticalPanel();
    private static HorizontalPanel checkServerPanel = new HorizontalPanel();
    private static HorizontalPanel buttonsPanel = new HorizontalPanel();
    private static Label serverInfoLabel = new Label();
    private static Image checkImage = new Image();

    static Element getLoading() {
        return loading;
    }

    private static ListBox sizeListBox = new ListBox();
    private static Element loading = RootPanel.get("loading").getElement();

    static ListBox getSizeListBox() {
        return sizeListBox;
    }

    private static FlexTable matrixTable = new FlexTable();
    private static Button calculateButton = new Button("Calculate");
    private static Button clearButton = new Button("Clear");

    static FlexTable getMatrixTable() {
        return matrixTable;
    }

    private static Button randomButton = new Button("Random");
    private static TextBox resultTextBox = new TextBox();

    static Button getCalculateButton() {
        return calculateButton;
    }

    static TextBox getResultTextBox() {
        return resultTextBox;
    }

    static Button getClearButton() {
        return clearButton;

    }

    static Button getRandomButton() {
        return randomButton;
    }

    static Label getServerInfoLabel() {
        return serverInfoLabel;
    }

    static Image getCheckImage() {
        return checkImage;
    }

    static void createUI() {

        RootPanel.get("detMatrix").add(mainPanel);
        addWidgetsToPanel();
        setItemsToSizeListBox();
        sizeListBox.addChangeHandler(event -> Matrix.createMatrixTable(sizeListBox.getSelectedValue()));
        resultTextBox.setEnabled(false);
        setCSS();
        ServerAvailability.checkServerAvailability();
    }

    private static void addWidgetsToPanel() {
        mainPanel.add(checkServerPanel);
        mainPanel.add(sizeListBox);
        mainPanel.add(matrixTable);
        mainPanel.add(buttonsPanel);
        mainPanel.add(resultTextBox);

        checkServerPanel.add(checkImage);
        checkServerPanel.add(serverInfoLabel);

        buttonsPanel.add(calculateButton);
        buttonsPanel.add(clearButton);
        buttonsPanel.add(randomButton);
    }

    private static void setItemsToSizeListBox() {

        sizeListBox.addItem("", "0");
        for (int i = 2; i <= MATRIX_MAX_SIZE; i++) {
            sizeListBox.addItem(i + "x" + i, i + "");
        }
    }

    private static void setCSS() {

        checkImage.setStyleName("checkImage");
        serverInfoLabel.setStyleName("serverInfoLabel");
        calculateButton.setStyleName("calculateButton");
        clearButton.setStyleName("clearButton");
        randomButton.setStyleName("randomButton");
        resultTextBox.setStyleName("resultTextBox");

    }

}
