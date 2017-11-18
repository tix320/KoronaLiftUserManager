package client;

import client.widgets.main.UserControlPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.typedarrays.shared.ArrayBuffer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import java.util.Date;
import org.realityforge.gwt.websockets.client.WebSocket;
import org.realityforge.gwt.websockets.client.WebSocketListener;
import server.entity.City;
import server.entity.User;
import shared.models.CityDto;
import shared.models.UserDto;
import shared.types.Gender;

/**
 * Main class, where the program is launched.
 */
public class Main implements EntryPoint {

    @Override
    public final void onModuleLoad() {
        RootPanel.get().add(new UserControlPanel());
    }
}
