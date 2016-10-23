package ua.rd.springtkach.beans;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author Sergey Mikhluk.
 */
public class Event {
    private int id;
    private String msg;
    private Date date;
    private DateFormat df;

    public Event(Date date, DateFormat df) {
        this.date = date;
        this.df = df;
        this.id = (int)(Math.random() * 100);
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + df.format(date) +
                '}'+"\n";
    }
}
