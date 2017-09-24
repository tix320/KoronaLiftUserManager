package client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GWTServiceAsync {

    void calculate(double matrix[][], AsyncCallback<Double> async);


    void checkLoading(AsyncCallback<Double> async);

    void setLoadingProgressNull(AsyncCallback<Void> async);

    void checkConnection(AsyncCallback<Void> async);
}
