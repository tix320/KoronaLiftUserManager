package client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

 class ServerAvailability {

    private static boolean serverAvailability = true;
    private static boolean isStarted=false;

     static void checkServerAvailability() {

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
                        MainWidgets.getLoading().setAttribute("value", String.valueOf(result));
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
                        isStarted=true;
                        if (serverAvailability) {
                            setServerInfo("failure");
                        }
                        serverAvailability = false;
                    }

                    @Override
                    public void onSuccess(Void result) {
                        if(isStarted){
                            isStarted=true;
                            if (!serverAvailability) {
                                setServerInfo("success");
                            }
                        }
                        serverAvailability = true;
                    }
                });
            }
        };
        serverAvailabilityTimer.scheduleRepeating(200);
    }

    private static void setServerInfo(String status) {

        if (status.equals("failure")) {
            modifyCheckServerPanel("Rolling.gif", "Соединеине с сервером прервано,идет подключение...", "#ffcc00");
        } else if (status.equals("success")) {
            modifyCheckServerPanel("Success.png", "Подключено", "green");
            Timer timer = new Timer() {
                @Override
                public void run() {
                    MainWidgets.getServerInfoLabel().getElement().getStyle().setVisibility(Style.Visibility.HIDDEN);
                    MainWidgets.getCheckImage().getElement().getStyle().setVisibility(Style.Visibility.HIDDEN);
                }
            };
            timer.schedule(2000);
        }

    }

    private static void modifyCheckServerPanel(String imageURL, String labelText, String labelTextColor){
        MainWidgets.getCheckImage().setUrl(imageURL);
        if(!MainWidgets.getCheckImage().getUrl().equals("Rolling.gif")){
            MainWidgets.getCheckImage().getElement().getStyle().setVisibility(Style.Visibility.HIDDEN);
        }
        else{
            MainWidgets.getCheckImage().getElement().getStyle().setVisibility(Style.Visibility.VISIBLE);
        }
        MainWidgets.getServerInfoLabel().setText(labelText);
        MainWidgets.getServerInfoLabel().getElement().getStyle().setColor(labelTextColor);
        MainWidgets.getServerInfoLabel().getElement().getStyle().setVisibility(Style.Visibility.VISIBLE);
    }
}
