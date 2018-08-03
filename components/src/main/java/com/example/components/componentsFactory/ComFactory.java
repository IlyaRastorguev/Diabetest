package com.example.components.componentsFactory;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.components.interfaces.Action;
import com.example.components.interfaces.Subscriber;
import com.example.components.props.ComponentProperties;
import com.example.components.store.Store;

import java.util.List;

public class ComFactory{

    private static final ComFactory COM_FACTORY = new ComFactory();

    private ComponentProperties componentProperties;

    private ComFactory() {

    }

    public static ComFactory get() {
        return COM_FACTORY;
    }

    public ComFactory setView(View view) {
        return this;
    }


    public ComFactory setTextValue(String value) {
        componentProperties.setTextValue(value);
        return this;
    }

    public ComFactory setLayoutId(int id) {
        componentProperties.setLayoutId(id);
        return this;
    }

    public ComFactory setWidth(int width) {
        componentProperties.setWidth(width);
        return this;
    }


    public ComFactory setHeight(int height) {
        componentProperties.setHeight(height);
        return this;
    }

    public ComFactory setAction(Object action) {
        componentProperties.setAction((Action) action);
        return this;
    }

    public ComFactory setVisibility(int visibility) {
        componentProperties.setVisibility(visibility);
        return this;
    }

    public ComFactory setSubscribers(List<Subscriber> subscribers) {
        componentProperties.setSubscribers(subscribers);
        return this;
    }

    public ComFactory setBackgroundId(int backgroundId) {
        componentProperties.setBackgroundId(backgroundId);
        return this;
    }

    public ComFactory setCoordinates(Integer x, Integer y) {
        if (x != null) componentProperties.setPositionX(x);
        if (y != null) componentProperties.setPositionY(y);
        return this;
    }

    public ComFactory setEventType(String eventType) {
        componentProperties.setEventType(eventType);
        return this;
    }

    public ComFactory setNeedFocus(Boolean needFocus) {
        componentProperties.setNeedFocus(needFocus);
        return this;
    }

    public ComFactory findType() {
        View component = componentProperties.getComponent();
        if (component instanceof Button) {
            componentProperties.setComponentClass(Button.class);
        } else if (component instanceof EditText){
            componentProperties.setComponentClass(EditText.class);
        } else if (component instanceof TextView){
            componentProperties.setComponentClass(TextView.class);
        } else if (component instanceof ImageView){
            componentProperties.setComponentClass(ImageView.class);
        } else if (component instanceof ListView){
            componentProperties.setComponentClass(ListView.class);
        }
        return this;
    }

   public void connectToStore(Integer componentId) {
        if (componentProperties != null) {
            componentProperties.setLayoutId(componentId);
            Store.getInstance().setComponentPropertiesMap(componentId, componentProperties);
        }
        componentProperties = null;
   }
}
