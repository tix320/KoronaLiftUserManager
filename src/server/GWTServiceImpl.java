package server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import client.GWTService;

import java.io.Serializable;


public class GWTServiceImpl extends RemoteServiceServlet implements GWTService,Serializable{

    private static double loadingProgress=0;

     static double getLoadingProgress() {
        return loadingProgress;
    }

     static void setLoadingProgress(double loadingProgress) {
        GWTServiceImpl.loadingProgress = loadingProgress;
    }

    @Override
    public void setLoadingProgressNull() {

        GWTServiceImpl.loadingProgress=0;
    }

    @Override
    public Double checkLoading() {

        return loadingProgress;

    }

    @Override
    public void checkConnection() {

    }

    @Override
    public Double calculate(double[][] matrix) {

        double d=100;
        int loadersCount = Matrix.loadersCount(matrix.length);
        Matrix.setLoadingPlus(d/loadersCount);

        return  Matrix.calculateDetMatrix(matrix);
    }
}