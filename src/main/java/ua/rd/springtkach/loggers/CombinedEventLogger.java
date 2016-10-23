package ua.rd.springtkach.loggers;

import ua.rd.springtkach.beans.Event;

import java.util.List;

/**
 * @author Sergey Mikhluk.
 */
public class CombinedEventLogger implements EventLogger {

    private List<EventLogger> loggers;

    public CombinedEventLogger(List<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger logger : loggers) {
            logger.logEvent(event);
        }
    }
}
