package ua.rd.springtkach;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.rd.springtkach.beans.Client;
import ua.rd.springtkach.loggers.ConsoleEventLogger;

/**
 *
 */
public class App {
    private Client client;
    private ConsoleEventLogger eventLogger;


    public App() {
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        //App app = new App();
        App app = (App) ctx.getBean("app");

        //client = new Client("1", "John Smith");
        //app.eventLogger = new ConsoleEventLogger();
        app.logEvent("Some event for user 1");
        app.logEvent("Some event for user 2");
        //System.out.println(client);
    }


    public App(Client client, ConsoleEventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    private void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        eventLogger.logEvent(message);
    }
}
