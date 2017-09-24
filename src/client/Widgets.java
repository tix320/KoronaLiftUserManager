package client;


import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

class Widgets {

    private static final int MATRIX_MAX_SIZE = 10;
    private static boolean isCalculating = false;
    private static boolean serverAvailability = false;
    private static VerticalPanel mainPanel = new VerticalPanel();
    private static HorizontalPanel checkServerPanel = new HorizontalPanel();
    private static HorizontalPanel buttonsPanel = new HorizontalPanel();
    private static Label serverInfoLabel = new Label();
    private static Image checkImage = new Image();
    private static ListBox sizeListBox = new ListBox();
    private static FlexTable matrixTable = new FlexTable();
    private static Button calculateButton = new Button("Calculate");
    private static Button clearButton = new Button("Clear");
    private static Button randomButton = new Button("Random");
    private static TextBox resultTextBox = new TextBox();
    private static Element loading = RootPanel.get("loading").getElement();

    static void createUI() {
        enableButtons(false);
        resultTextBox.setEnabled(false);
        RootPanel.get("detMatrix").add(mainPanel);
        addWidgetsToPanel();
        setListeners();
        setItemsToSizeListBox();
        setCSS();
        checkServerAvailability();
    }

    private static void checkServerAvailability() {

        GWTServiceAsync loadingRequest = GWT.create(GWTService.class);
        Timer loadingTimer = new Timer() {
            @Override
            public void run() {
                loadingRequest.checkLoading(new AsyncCallback<Double>() {
                    @Override
                    public void onFailure(Throwable caught) {

                    }

                    @Override
                    public void onSuccess(Double result) {
                        loading.setAttribute("value", String.valueOf(result));
                    }
                });
            }
        };
        loadingTimer.scheduleRepeating(10);
        GWTServiceAsync serverAvailabilityRequest = GWT.create(GWTService.class);
        Timer serverAvailabilityTimer = new Timer() {
            @Override
            public void run() {
                serverAvailabilityRequest.checkConnection(new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        if (!serverAvailability) ;
                        else {
                            setServerInfo("failed");
                        }
                        serverAvailability = false;
                    }

                    @Override
                    public void onSuccess(Void result) {
                        if (!serverAvailability) {
                            setServerInfo("rolling");
                            Timer waitTimer = new Timer() {
                                @Override
                                public void run() {
                                    setServerInfo("success");
                                }
                            };
                            waitTimer.schedule(2000);


                        }
                        serverAvailability = true;
                    }
                });
            }
        };
        serverAvailabilityTimer.run();
        serverAvailabilityTimer.scheduleRepeating(2500);
    }

    private static void setServerInfo(String status) {

        if (status.equals("failed")) {
            modifyCheckServerPanel("Подключение прервано", "red", Style.Visibility.VISIBLE);
        } else if (status.equals("rolling")) {
            modifyCheckServerPanel("Rolling.gif", "Идет подключение к серверу", "#ffcc00", Style.Visibility.VISIBLE);
        } else if (status.equals("success")) {
            modifyCheckServerPanel("Success.png", "Подключено", "green", Style.Visibility.VISIBLE);
            Timer timer = new Timer() {
                @Override
                public void run() {
                    serverInfoLabel.getElement().getStyle().setVisibility(Style.Visibility.HIDDEN);
                    checkImage.getElement().getStyle().setVisibility(Style.Visibility.HIDDEN);
                }
            };
            timer.schedule(2000);
        }

    }

    private static void modifyCheckServerPanel(String imageURL, String labelText, String labelTextColor, Style.Visibility visibility){
        checkImage.setUrl(imageURL);
        serverInfoLabel.setText(labelText);
        serverInfoLabel.getElement().getStyle().setColor(labelTextColor);
        serverInfoLabel.getElement().getStyle().setVisibility(visibility);
        checkImage.getElement().getStyle().setVisibility(visibility);
    }

    private static void modifyCheckServerPanel(String labelText, String labelTextColor, Style.Visibility visibility){
        serverInfoLabel.setText(labelText);
        serverInfoLabel.getElement().getStyle().setColor(labelTextColor);
        serverInfoLabel.getElement().getStyle().setVisibility(visibility);
        checkImage.getElement().getStyle().setVisibility(visibility);
    }

    private static void enableButtons(boolean value) {
        calculateButton.setEnabled(value);
        clearButton.setEnabled(value);
        randomButton.setEnabled(value);
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

    private static void setListeners() {

        sizeListBox.addChangeHandler(event -> createMatrixTable(sizeListBox.getSelectedValue()));

        calculateButton.addClickHandler(event -> calculateDet(matrixTable.getRowCount()));

        clearButton.addClickHandler(event -> clearMatrixTable(matrixTable.getRowCount()));

        randomButton.addClickHandler(event -> initRandomMatrix(matrixTable.getRowCount()));

    }

    private static void initRandomMatrix(int size) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                TextBox textBox = (TextBox) matrixTable.getWidget(i, j);
                textBox.setText(Random.nextInt(100) + "");
            }
        }
        if (!isCalculating) {
            enableButtons(true);
        }
    }

    private static void setItemsToSizeListBox() {

        sizeListBox.addItem("", "0");
        for (int i = 2; i <= MATRIX_MAX_SIZE; i++) {
            sizeListBox.addItem(i + "x" + i, i + "");
        }
    }

    private static void setCSS() {

        serverInfoLabel.getElement().setId("connecting");
        calculateButton.setStyleName("calculateButton");
        clearButton.setStyleName("clearButton");
        randomButton.setStyleName("randomButton");
        resultTextBox.setStyleName("resultTextBox");
        checkImage.setStyleName("checkImage");
        serverInfoLabel.setStyleName("serverInfoLabel");
        loading.getStyle().setVisibility(Style.Visibility.HIDDEN);
    }

    private static void clearMatrixTable(int size) {
        calculateButton.setEnabled(false);
        clearButton.setEnabled(false);
        resultTextBox.setText("");

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                TextBox textBox = (TextBox) matrixTable.getWidget(i, j);
                textBox.setText("");
            }
        }
    }

    private static void calculateDet(int size) {
        isCalculating = true;
        loading.getStyle().setVisibility(Style.Visibility.VISIBLE);

        enableButtons(false);
        GWTServiceAsync gwtServiceAsync = GWT.create(GWTService.class);

        double[][] matrix = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                TextBox textBox = (TextBox) matrixTable.getWidget(i, j);
                double cellValue = Double.parseDouble(textBox.getText());
                matrix[i][j] = cellValue;
            }
        }

        gwtServiceAsync.calculate(matrix, new AsyncCallback<Double>() {
            @Override
            public void onFailure(Throwable caught) {
                isCalculating = false;
                enableButtons(true);
            }

            @Override
            public void onSuccess(Double result) {
                resultTextBox.setText("Result: " + result);
                loading.setAttribute("value", "100");
                isCalculating = false;
                enableButtons(true);

                gwtServiceAsync.setLoadingProgressNull(new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        loading.getStyle().setVisibility(Style.Visibility.HIDDEN);
                    }

                    @Override
                    public void onSuccess(Void result) {
                        loading.getStyle().setVisibility(Style.Visibility.HIDDEN);
                    }
                });
            }
        });
    }

    private static void createMatrixTable(String size) {
        resultTextBox.setText("");
        randomButton.setEnabled(true);
        clearButton.setEnabled(false);
        calculateButton.setEnabled(false);
        int instanceSize = Integer.parseInt(size);
        matrixTable.removeAllRows();
        if (sizeListBox.getValue(0).equals("0")) sizeListBox.removeItem(0);

        if (instanceSize != 0) {

            for (int i = 0; i < instanceSize; i++) {
                for (int j = 0; j < instanceSize; j++) {

                    TextBox textBox = new TextBox();

                    textBox.addKeyPressHandler(keyPressEvent ->
                    {
                        if (keyPressEvent.getCharCode() < 48 || keyPressEvent.getCharCode() > 57)
                            textBox.cancelKey();

                        if (keyPressEvent.getCharCode() == 13) calculateDet(matrixTable.getRowCount());

                    });
                    textBox.addKeyUpHandler(keyPressEvent -> {

                        row:
                        for (int k = 0; k < matrixTable.getRowCount(); k++) {
                            for (int l = 0; l < matrixTable.getRowCount(); l++) {

                                TextBox tmp = (TextBox) matrixTable.getWidget(k, l);

                                if (tmp.getText().equals("")) {
                                    calculateButton.setEnabled(false);
                                    break row;
                                } else {
                                    clearButton.setEnabled(true);
                                }
                            }
                            if (k == matrixTable.getRowCount() - 1 && !isCalculating) calculateButton.setEnabled(true);
                        }
                    });

                    matrixTable.setWidget(i, j, textBox);
                }
            }
        }
    }
}
