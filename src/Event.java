import java.util.ArrayList;

/**
 * Created by student on 10/17/17.
 */
public class Event {

    private Event priorEvent;
    private int numberOfOptions;
    private ArrayList<Event> options;
    private String roomExplaination;

    public Event(Event priorEvent, ArrayList<Event> options, String roomExplaination) {
        this.priorEvent = priorEvent;
        this.numberOfOptions = options.size();
        this.options = options;
        this.roomExplaination = roomExplaination;
    }

    public Event(ArrayList<Event> options, String roomExplaination) {
        this.priorEvent = null;
        this.numberOfOptions = options.size();
        this.options = options;
        this.roomExplaination = roomExplaination;
    }

    public Event(String roomExplaination) {
        this.priorEvent = null;
        this.numberOfOptions = 0;
        this.options = null;
        this.roomExplaination = roomExplaination;
    }

    public void addEvent(Event event) {
        options.add(event);
    }

    public Event getPriorEvent() {
        return priorEvent;
    }

    public void setPriorEvent(Event priorEvent) {
        this.priorEvent = priorEvent;
    }

    public int getNumberOfOptions() {
        return numberOfOptions;
    }

    public void setNumberOfOptions(int numberOfOptions) {
        this.numberOfOptions = numberOfOptions;
    }

    public ArrayList<Event> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Event> options) {
        this.options = options;
    }

    public String getRoomExplaination() {
        return roomExplaination;
    }

    public void setRoomExplaination(String roomExplaination) {
        this.roomExplaination = roomExplaination;
    }
}
