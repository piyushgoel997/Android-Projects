package com.example.piyush.lect10netconnect;

/**
 * Created by Piyush on 05-07-2016.
 */

public class Event {
    String eventName;
    String eventType;
    String eventLoc;
    String eventTopic;



    public String getEventLoc() {
        return eventLoc;
    }

    public String getEventTopic() {
        return eventTopic;
    }
public Event(String name, String location_name, String topic, String type) {
    eventLoc = location_name;
    eventName = name;
    eventTopic = topic;
    eventType = type;
    }
    public String getEventName() {
        return eventName;
    }

    public String getEventType() {
        return eventType;
    }


}
