package ua.rd.springtkach;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.rd.springtkach.beans.Client;
import ua.rd.springtkach.beans.Event;
import ua.rd.springtkach.loggers.ConsoleEventLogger;

/**
 *
 */
public class App {
    private Client client;
    private ConsoleEventLogger eventLogger;

    public App() {
    }

    public App(Client client, ConsoleEventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        //App app = new App();
        App app = (App) ctx.getBean("app");
        Event event = (Event) ctx.getBean("event");
        System.out.println(event);

        //client = new Client("1", "John Smith");
        //app.eventLogger = new ConsoleEventLogger();
        app.logEvent("Some event for user 1", event);
        event = (Event) ctx.getBean("event");
        app.logEvent("Some event for user 2", event);
        //System.out.println(client);
    }

    private void logEvent(String msg, Event event) {
        event.setMsg(msg.replaceAll(client.getId(), client.getFullName()));
        eventLogger.logEvent(event);
    }
}
