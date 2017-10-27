import java.util.Scanner;

/**
 * Created by student on 10/18/17.
 */

//Matches a user input to a connection between events
public class Actions {
    private String keywords[];
    private Inventory userInventory;
    private String item;

    public Actions() {
        keywords = new String[]{"use", "take", "go to"};
        userInventory = new Inventory();
        item = null;
//        userInventory.addObject("clothespin");
//        userInventory.addObject("key");
//        userInventory.addObject("code");
//        userInventory.addObject("blacklight");
//        userInventory.addObject("flashlight");
//        userInventory.addObject("batteries");
//        userInventory.addObject("gun");
//        userInventory.addObject("bullets");
//        userInventory.addObject("bagel");
//        userInventory.addObject("flushed");
    }

    public static String getInput() {
        Scanner s = new Scanner(System.in);
        return s.nextLine().toLowerCase();
    }

    public int callOption(String userInput, Event room) {
        String[] input = userInput.split(" ");
        String action = input[0];
        int ts = 1;
        if (action.equalsIgnoreCase("go") && input[1].equalsIgnoreCase("to")) {
            action += " " + input[1];
            ts++;
        }
        String thing = "";
        for (int i = ts; i < input.length; i++) {
            thing += input[i];
            if (i != input.length - 1)
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
                            return -2;
                        }
                    }
                } else {
                    for (int q = 0; q < room.getOptions().size(); q++) {
                        if (thing.equalsIgnoreCase(room.getOptions().get(q).getName()) && room.getOptions().get(q).isOpen()) {
                            if (thing.equalsIgnoreCase("toilet flusher")) {
                                take("flushed", room);
                            }

                            if (thing.equalsIgnoreCase("nerd")) {
                                if (userInventory.isObjectInInventory("Incorrect Code")) {
                                    System.out.println("You approach the nerd again, you can either 'talk' to him, or 'beat' him up.");
                                    String userInputNerd = getInput();
                                    if (userInputNerd.equalsIgnoreCase("talk")) {
                                        System.out.println("You tell the nerd that the code didn't work, he snickers, and curls up, never to speak again.");
                                        return -3;
                                    } else if (userInputNerd.equalsIgnoreCase("beat")) {
                                        System.out.println("The nerd whimpers as you beat him into the corner of the dresser. Finally, he hands you a second sheet of paper, this one with a different code");
                                        userInventory.addObject("Code");
                                        return -3;
                                    }
                                } else {
                                    System.out.println("You get closer to the nerd. You can either 'run away', 'talk' to him, or 'beat' him up.");
                                    String userInputNerd = getInput();
                                    if (userInputNerd.equalsIgnoreCase("run away")) {
                                        System.out.println("You run straight into the wall, killing yourself instantly");
                                        return -3;
                                    } else if (userInputNerd.equalsIgnoreCase("talk")) {
                                        System.out.println("The nerd gives you a piece of paper with a code on it");
                                        userInventory.addObject("Incorrect Code");
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
                            }


                            if (thing.equalsIgnoreCase("basement") && room.getName().equalsIgnoreCase("stairs")){
                                System.out.println("You fall down a hole in the stairs into a well and die");
                                return -3;
                            }
                            return q;
                        }
                    }
                }
            }
        }
        return -2;
    }

    public Event makeConnection(Event room, int index) {
        if (index == -2)
            return room;
        if (index == -1) {
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
        if (item.equalsIgnoreCase("bagel")){
            System.out.println("You pick up the bagel and all of a sudden there is a bright flash, \n a figure dashes past you and rips the bagel from your hand \n and quickly disappears into the darkness.");
            room.removeItemFromRoom(item);
        }
        else {
            userInventory.addObject(item);
            room.removeItemFromRoom(item);
        }
    }

}
