package client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("yes")
public interface GWTService extends RemoteService {

    void setLoadingProgressNull();

    Double checkLoading();

    void checkConnection();

 Double calculate(double matrix[][]);

}
