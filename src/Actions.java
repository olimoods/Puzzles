/**
 * Created by student on 10/18/17.
 */

//Matches a user input to a connection between events
public class  Actions {
    private String keywords[];
    private Inventory userInventory;
    private String item;
    public Actions() {
        keywords = new String[]{"use", "take", "examine"};
        userInventory = new Inventory();
        item = null;
    }

    public int callOption(String userInput, Event room) {
        String[] input= userInput.split(" ");
        String action = input[0];
        String thing = "";
        for (int i = 1; i < input.length; i++) {
            thing += input[i];
            if (i != input.length-1)
                thing += " ";
        }

        for (int i = 0; i < keywords.length; i++) {
            if (keywords[i].equalsIgnoreCase(action)) {
                if (i == 0) {
                    item = thing;
                    return -1;
                } else if (i == 1) {
                    for (int j = 0; j < room.getItems().size(); j++) {
                        if (thing.equalsIgnoreCase(room.getItems().get(j))) {
                            take(thing);
                            return i;
                        }
                    }
                } else {
                    for (int q = 0; q < room.getOptions().size(); q++) {
                        if (thing.equalsIgnoreCase(room.getOptions().get(q).getName())) {
                            return q;
                        }
                    }                }
            }
        }
        return -2;
    }

    public Event makeConnection(Event room, int index){
        if (index == -2)
            return room;
        if (index == -1){
            userInventory.useItem(item, room);
        }
        return room.getOptions().get(index);
    }

//    private boolean use(String item) {
//        return userInventory.useItem(item);
//    }

    private void take(String item) {
        userInventory.addObject(item);
    }

}
