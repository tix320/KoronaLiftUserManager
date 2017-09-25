package client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.TextBox;

 class Matrix {

    private static boolean isCalculating = false;
    private static int matrixSize;

    static {
        enableButtons(false);

        MainWidgets.getCalculateButton().addClickHandler(event -> calculateDet());

        MainWidgets.getClearButton().addClickHandler(event -> clearMatrixTable());

        MainWidgets.getRandomButton().addClickHandler(event -> initRandomMatrix());
    }

    static void createMatrixTable(String size) {
        MainWidgets.getResultTextBox().setText("");
        MainWidgets.getRandomButton().setEnabled(true);
        MainWidgets.getClearButton().setEnabled(false);
        MainWidgets.getCalculateButton().setEnabled(false);
        int instanceSize = Integer.parseInt(size);
        matrixSize = instanceSize;
        MainWidgets.getMatrixTable().removeAllRows();
        if (MainWidgets.getSizeListBox().getValue(0).equals("0")) MainWidgets.getSizeListBox().removeItem(0);

        if (instanceSize != 0) {

            for (int i = 0; i < instanceSize; i++) {
                for (int j = 0; j < instanceSize; j++) {

                    TextBox textBox = new TextBox();

                    textBox.addKeyPressHandler(keyPressEvent ->
                    {
                        if (keyPressEvent.getCharCode() < 48 || keyPressEvent.getCharCode() > 57)
                            textBox.cancelKey();

                        if (keyPressEvent.getCharCode() == 13) calculateDet();

                    });
                    textBox.addKeyUpHandler(keyPressEvent -> {

                        row:
                        for (int k = 0; k < matrixSize; k++) {
                            for (int l = 0; l < matrixSize; l++) {

                                TextBox tmp = (TextBox) MainWidgets.getMatrixTable().getWidget(k, l);

                                if (tmp.getText().equals("")) {
                                    MainWidgets.getCalculateButton().setEnabled(false);
                                    break row;
                                } else {
                                    MainWidgets.getClearButton().setEnabled(true);
                                }
                            }
                            if (k == MainWidgets.getMatrixTable().getRowCount() - 1 && !isCalculating)
                                MainWidgets.getClearButton().setEnabled(true);
                        }
                    });

                    MainWidgets.getMatrixTable().setWidget(i, j, textBox);
                }
            }
        }
    }

    private static void clearMatrixTable() {
        MainWidgets.getCalculateButton().setEnabled(false);
        MainWidgets.getClearButton().setEnabled(false);
        MainWidgets.getResultTextBox().setText("");

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                TextBox textBox = (TextBox) MainWidgets.getMatrixTable().getWidget(i, j);
                textBox.setText("");
            }
        }
    }

    private static void calculateDet() {
        enableTextBoxes(false);
        MainWidgets.getSizeListBox().setEnabled(false);
        isCalculating = true;
        MainWidgets.getLoading().getStyle().setVisibility(Style.Visibility.VISIBLE);
        enableButtons(false);

        double[][] matrix = new double[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                TextBox textBox = (TextBox) MainWidgets.getMatrixTable().getWidget(i, j);
                double cellValue = Double.parseDouble(textBox.getText());
                matrix[i][j] = cellValue;
            }
        }
        GWTServiceAsync calculateRequest = GWT.create(GWTService.class);
        calculateRequest.calculate(matrix, new AsyncCallback<Double>() {
            @Override
            public void onFailure(Throwable caught) {
                MainWidgets.getSizeListBox().setEnabled(true);
                isCalculating = false;
                enableButtons(true);
                enableTextBoxes(true);
            }

            @Override
            public void onSuccess(Double result) {
                MainWidgets.getSizeListBox().setEnabled(true);
                MainWidgets.getResultTextBox().setText("Result: " + result);
                MainWidgets.getLoading().setAttribute("value", "100");
                isCalculating = false;
                enableButtons(true);
                enableTextBoxes(true);
                GWTServiceAsync loadinNullRequest = GWT.create(GWTService.class);
                loadinNullRequest.setLoadingProgressNull(new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        MainWidgets.getLoading().getStyle().setVisibility(Style.Visibility.HIDDEN);
                    }

                    @Override
                    public void onSuccess(Void result) {
                        MainWidgets.getLoading().getStyle().setVisibility(Style.Visibility.HIDDEN);
                    }
                });
            }
        });
    }

    private static void initRandomMatrix() {

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                TextBox textBox = (TextBox) MainWidgets.getMatrixTable().getWidget(i, j);
                textBox.setText(Random.nextInt(100) + "");
            }
        }
        if (!isCalculating) {
            enableButtons(true);
        }
    }

    private static void enableTextBoxes(boolean value) {
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                TextBox textBox = (TextBox) MainWidgets.getMatrixTable().getWidget(i, j);
                textBox.setEnabled(value);
            }
        }
    }

    private static void enableButtons(boolean value) {
        MainWidgets.getCalculateButton().setEnabled(value);
        MainWidgets.getClearButton().setEnabled(value);
        MainWidgets.getRandomButton().setEnabled(value);
    }
}
