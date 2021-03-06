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
    private boolean open;

    public Event(Event priorEvent, ArrayList<Event> options, ArrayList<String> items, String roomExplaination, String name) {
        this.priorEvent = priorEvent;
        this.options = options;
        this.numberOfOptions = options.size();
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
        this.options = new ArrayList<Event>();
        this.items = new ArrayList<String>();
        this.roomExplaination = roomExplaination;
        this.name = name;
        this.open = true;
    }

    public Event(String roomExplaination, String name, boolean open) {
        this.priorEvent = null;
        this.numberOfOptions = 0;
        this.options = new ArrayList<Event>();
        this.items = new ArrayList<String>();
        this.roomExplaination = roomExplaination;
        this.name = name;
        this.open = open;
    }

    public void addEvent(Event event) {
        options.add(event);
    }

    public void addEvent(Event event, int ind) {
        options.add(ind, event);
    }

    public void addItem(String item) {
        items.add(item.toLowerCase());
    }

    public Event getPriorEvent() {
        return priorEvent;
    }

    public void setPriorEvent(Event priorEvent) {
        this.priorEvent = priorEvent;
        addEvent(this.priorEvent);
    }

    public int getNumberOfOptions() {
        return options.size();
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

    public void removeItemFromRoom(String item) {
        items.remove(item.toLowerCase());
        System.out.println(items);
    }

    public String getRoomExplaination() {
        return roomExplaination + "\n" + surroundingOptions();
    }

    public String surroundingOptions() {
        String rooms = "Go to the";

        for (Event room: options) {
            if(room.isOpen())
                rooms += " " + room.getName() + ",";
        }
        rooms.substring(0,rooms.length()-1);


        String itemString = "";
        if (items.size() > 0) {
            itemString = "You see a";
            for (String item : this.items) {
                itemString += " " + item + ",";
            }
            rooms.substring(0,rooms.length()-1);
        }
        return rooms + "\n" + itemString;

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

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}
