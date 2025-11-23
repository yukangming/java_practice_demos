package org.example;

import java.util.HashMap;
import java.util.Map;

public class NotificationContext {

    Map<String, NotificationStrategy> stategys = new HashMap<>();


    public void addStrategy(String name, NotificationStrategy strategy) {
        stategys.put(name, strategy);
    }

    public void process(String name) {
        stategys.get(name).strategy();
    }
}
