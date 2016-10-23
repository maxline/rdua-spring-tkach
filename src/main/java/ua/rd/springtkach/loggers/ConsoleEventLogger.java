package ua.rd.springtkach.loggers;

import ua.rd.springtkach.beans.Event;

/**
 *
 */
public class ConsoleEventLogger implements  EventLogger {
    @Override
    public void logEvent(Event event){
        System.out.println(event);
    }
}
