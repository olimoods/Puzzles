import java.util.Scanner;

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
        userInventory.addObject("flashlight");
        userInventory.addObject("gun");
        userInventory.addObject("bullets");
        userInventory.addObject("key");
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
                            if (thing.equalsIgnoreCase("nerd")) {
                                System.out.println("You get closer to the nerd. You can either 'run away', 'talk' to him, or 'beat' him up.");
                                String userInputNerd = getInput();
                                if (userInputNerd.equalsIgnoreCase("run away")) {
                                    System.out.println("You run straight into the wall, killing yourself instantly");
                                    return -3;
                                } else if (userInputNerd.equalsIgnoreCase("talk")) {
                                    System.out.println("The nerd gives you a piece of paper with a code on it");
                                    userInventory.addObject("Code");
                                    System.out.println("You can either 'lock him up' or 'let him go'");
                                    String userInputNerd2 = getInput();
                                    if (userInputNerd2.equalsIgnoreCase("lock him up")) {
                                        System.out.println("You lock the nerd up, and close the dresser");
                                        return -3;
                                    } else if (userInputNerd2.equalsIgnoreCase("let him go")) {
                                        System.out.println("The nerd sprints away, you chase after him, but run straight into a wall, killing yourself instantly.");
                                        return -3;
                                    }
                                } else if (userInputNerd.equalsIgnoreCase("beat")) {
                                    System.out.println("The nerd curls up, silent. He's used to this.");
                                    return -3;
                                }
                            }
                            return q;
                        }
                    }
                }
            }
        }
        return -2;
    }

    public static String getInput() {
        Scanner s = new Scanner(System.in);
        return s.nextLine().toLowerCase();
    }

    public Event makeConnection(Event room, int index){
        if (index == -2)
            return room;
        if (index == -1){
            return userInventory.useItem(item, room);
        }
        if (index == -3) {
            return room.getPriorEvent();
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
