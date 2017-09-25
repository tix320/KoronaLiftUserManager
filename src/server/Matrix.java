package server;

import java.io.Serializable;

class Matrix implements Serializable {

    private static double loadingPlus;

     static void setLoadingPlus(double loadingPlus) {
        Matrix.loadingPlus = loadingPlus;
    }

     static Double calculateDetMatrix(double [][] matrix) {

        double currentDet = 0.0;

        if (matrix.length == 2) {
            GWTServiceImpl.setLoadingProgress(GWTServiceImpl.getLoadingProgress()+Matrix.loadingPlus);
            return matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
        }
        else {
            for (int i = 0; i < matrix.length; i++) {

                double[][] tempArray = new double[matrix.length - 1][matrix.length - 1];

                int tempArrayRow = 0, tempArrayCol = 0;
                for (int k = 1; k < matrix.length; k++) {
                    for (int j = 0; j < matrix.length; j++) {
                        if (j != i) {
                            tempArray[tempArrayRow][tempArrayCol] = matrix[k][j];
                            tempArrayCol++;
                        }
                    }
                    tempArrayRow++;
                    tempArrayCol = 0;
                }
                if (i % 2 == 0)
                    currentDet += matrix[0][i] * calculateDetMatrix(tempArray);
                else
                    currentDet -= matrix[0][i] * calculateDetMatrix(tempArray);

            }
            return currentDet;
        }

    }

     static int loadersCount(int size){

        int d=1;

        for (int i = 3; i <=size ; i++) {
            d=d*i;
        }
        return d;
    }
}
