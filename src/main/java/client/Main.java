package client;

import client.widgets.MainPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class Main implements EntryPoint {

    @Override
    public void onModuleLoad() {

        RootPanel.get().add(new MainPanel().createUI());
    }
}