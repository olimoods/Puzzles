/**
 * Created by student on 10/18/17.
 */

//Matches a user input to a connection between events
public class  Actions {
    private String keywords[];
    private Inventory userInventory;
    private String item;
    public Actions() {
        keywords = new String[]{"use", "take", "go to"};
        userInventory = new Inventory();
        item = null;
    }

    public int callOption(String userInput, Event room) {
        String[] input= userInput.split(" ");
        String action = input[0];
        int ts = 1;
        if (action.equalsIgnoreCase("go") && input[1].equalsIgnoreCase("to")) {
            action += " " + input[1];
            ts++;
        }
        String thing = "";
        for (int i = ts; i < input.length; i++) {
            thing += input[i];
            if (i != input.length-1)
                thing += " ";
        }

        for (int i = 0; i < keywords.length; i++) {
            if (keywords[i].equalsIgnoreCase(action)) {
                if (i == 0) {
                    item = thing;
//                    System.out.println("use");
                    return -1;
                } else if (i == 1) {
                    for (int j = 0; j < room.getItems().size(); j++) {
                        if (thing.equalsIgnoreCase(room.getItems().get(j))) {
                            take(thing, room);
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
            return userInventory.useItem(item, room);
        }
        return room.getOptions().get(index);
    }

//    private Event use(String item, Event room) {
//        if (room.getName().equals("Microwave")) {
//            if (item.equals("Code")) {
//                return userInventory.useItem(item, room);
//
//            }
//        }
//        return null;
//    }

    private void take(String item, Event room) {
        room.removeItemFromRoom(item);
        userInventory.addObject(item);
    }

}
