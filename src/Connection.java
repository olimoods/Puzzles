/**
 * Created by student on 10/17/17.
 */
public class Connection {
    private Event eventFrom, eventTo;
    private Main main;
    private String optionLine;

    public Connection(Event eventFrom, Event eventTo, String optionLine) {
        this.eventFrom = eventFrom;
        this.eventTo = eventTo;
        this.optionLine = optionLine;
        main = new Main();
    }

    public Connection(Event eventFrom, String optionLine) {
        this.eventFrom = eventFrom;
        this.optionLine = optionLine;
        main = new Main();
    }

    public Event getEventFrom() {
        return eventFrom;
    }

    public Event connectForward() {
        return eventTo;
    }

    public Event connectBack() {
        return eventFrom;
    }

    public void setEventFrom(Event eventFrom) {
        this.eventFrom = eventFrom;
    }

    public Event getEventTo() {
        return eventTo;
    }

    public void setEventTo(Event eventTo) {
        this.eventTo = eventTo;
    }

    public String getOptionLine() {
        return optionLine;
    }

    public void setOptionLine(String optionLine) {
        this.optionLine = optionLine;
    }
}
