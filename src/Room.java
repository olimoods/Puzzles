/**
 * Created by student on 10/17/17.
 */
public class Room {

    private Room priorRoom;
    private int numberOfOptions;
    private Connection[] options;
    private String roomExplaination;

    public Room(Room priorRoom, int numberOfOptions, Connection[] options, String roomExplaination) {
        this.priorRoom = priorRoom;
        this.numberOfOptions = numberOfOptions;
        this.options = options;
        this.roomExplaination = roomExplaination;
    }

    public Room getPriorRoom() {
        return priorRoom;
    }

    public void setPriorRoom(Room priorRoom) {
        this.priorRoom = priorRoom;
    }

    public int getNumberOfOptions() {
        return numberOfOptions;
    }

    public void setNumberOfOptions(int numberOfOptions) {
        this.numberOfOptions = numberOfOptions;
    }

    public Connection[] getOptions() {
        return options;
    }

    public void setOptions(Connection[] options) {
        this.options = options;
    }

    public String getRoomExplaination() {
        return roomExplaination;
    }

    public void setRoomExplaination(String roomExplaination) {
        this.roomExplaination = roomExplaination;
    }
}
