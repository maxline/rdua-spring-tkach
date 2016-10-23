package ua.rd.springtkach;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.rd.springtkach.beans.Client;
import ua.rd.springtkach.beans.Event;
import ua.rd.springtkach.beans.EventType;
import ua.rd.springtkach.loggers.EventLogger;

import java.util.Map;

/**
 *
 */
public class App {
    private Client client;
    private EventLogger eventLogger;
    private Map<EventType, EventLogger> loggers;

    public App() {
    }

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers = loggers;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) ctx.getBean("app");
        Event event = (Event) ctx.getBean("event");
        System.out.println(app.client.toString());
        System.out.println(event);

        app.logEvent("Some event for user 1", event, EventType.INFO);
        event = (Event) ctx.getBean("event");
        app.logEvent("Some event for user 2", event, EventType.INFO);

        ctx.close();
        //App app = new App();
        //client = new Client("1", "John Smith");
        //app.eventLogger = new ConsoleEventLogger();
        //System.out.println(client);
    }

    private void logEvent(String msg, Event event, EventType type) {
        event.setMsg(msg.replaceAll(client.getId(), client.getFullName()));
        EventLogger logger = loggers.get(type);
        if (logger == null) {
            logger = eventLogger;
        }
        logger.logEvent(event);
    }
}
