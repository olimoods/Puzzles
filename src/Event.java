import java.util.ArrayList;

/**
 * Created by student on 10/17/17.
 */
public class Event {

    private Event priorEvent;
    private int numberOfOptions;
    private ArrayList<Event> options;
    private ArrayList<String> items;
    private String roomExplaination, name;

    public Event(Event priorEvent, ArrayList<Event> options, ArrayList<String> items, String roomExplaination, String name) {
        this.priorEvent = priorEvent;
        this.numberOfOptions = options.size();
        this.options = options;
        this.items = items;
        this.roomExplaination = roomExplaination;
        this.name = name;
    }

    public Event(ArrayList<Event> options, ArrayList<String> items, String roomExplaination, String name) {
        this.priorEvent = null;
        this.numberOfOptions = options.size();
        this.options = options;
        this.items = items;
        this.roomExplaination = roomExplaination;
        this.name = name;
    }

    public Event(String roomExplaination, String name) {
        this.priorEvent = null;
        this.numberOfOptions = 0;
        this.options = null;
        this.items = null;
        this.roomExplaination = roomExplaination;
        this.name = name;
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

    public ArrayList<String> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }
}
