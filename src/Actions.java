/**
 * Created by student on 10/18/17.
 */

//Matches a user input to a connection between events
public class  Actions {
    private String keywords[];
    private Inventory userInventory;
    public Actions() {
        keywords = new String[]{"use", "take", "examine"};
        userInventory = new Inventory();
    }

    public int callOption(String userInput, Event room) {
        String action = userInput.split(" ")[0];
        String thing = userInput.split(" ")[1];
        for (int i = 0; i < keywords.length; i++) {
            if (keywords[i].equalsIgnoreCase(action)) {
                if (i == 0) {
                    if(use(thing))
                        return i;
                } else if (i == 1) {
                    for (int j = 0; j < room.getItems().size(); j++) {
                        if (thing.equalsIgnoreCase(room.getItems().get(j))) {
                            take(thing);
                            return i;
                        }
                    }
                } else {
                    for (int q = 0; q < room.getItems().size(); q++) {
                        if (thing.equalsIgnoreCase(room.getOptions().get(q).getName())) {
                            return i;
                        }
                    }                }
            }
        }
        return 4;
    }

    public Event makeConnection(Event room, int index){
        if (index == 4)
            return room;
        return room.getOptions().get(index);
    }

    private boolean use(String item) {
        return userInventory.useItem(item);
    }

    private void take(String item) {
        userInventory.addObject(item);
    }

}
