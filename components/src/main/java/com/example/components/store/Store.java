package com.example.components.store;

import com.example.components.props.ComponentProperties;

import java.util.HashMap;
import java.util.Map;

public class Store {
    private static final Store ourInstance = new Store();

    public static Store getInstance() {
        return ourInstance;
    }

    private Store() {
    }

    private Map<Integer, ComponentProperties> componentPropertiesMap = new HashMap<>();

    public Map<Integer, ComponentProperties> getComponentPropertiesMap() {
        return componentPropertiesMap;
    }

    public <T> void setComponentPropertiesMap(Integer componentId, ComponentProperties<T> componentProperties) {
        componentPropertiesMap.put(componentId, componentProperties);
    }
}
