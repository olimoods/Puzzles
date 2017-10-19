/**
 * Created by student on 10/18/17.
 */

//Matches a user input to a connection between events
public class Actions {
    private String keywords[];
    public Actions() {
        keywords = new String[]{"use", "open", "take", "examine"};
    }

    public boolean callAction(String userInput, Inventory userInventory) {
        String action = userInput.split(" ")[0];
        for (int i = 0; i < keywords.length; i++) {
            if (keywords[i].equalsIgnoreCase(action)) {
                if (i == 0) {
                    use(userInventory);
                } else if (i == 1) {
                    //Go to another room
                } else if (i == 2) {
                    take(userInventory);
                } else {
                    //Go to another "ROOM"
                }
            }
        }
        return false;
    }

    private void use(Inventory userInventory) {

    }

    private void take(Inventory userInventory) {

    }

}
