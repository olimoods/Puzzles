/**
 * Created by student on 10/18/17.
 */

//Matches a user input to a connection between events
public class Actions {
    private String keywords[];
    public Actions() {
        keywords = new String[]{"use", "open", "take", "examine"};
    }

    public boolean callOption(String userInput, Inventory userInventory) {
        String action = userInput.split(" ")[0];
        for (int i = 0; i < keywords.length; i++) {
            if (keywords[i].equalsIgnoreCase(action)) {
                if (i == 0) {
                    use(userInventory);
                }
            }
        }
        return false;
    }

    public void makeConnection(Event room, int index){
        if(room == room.getOptions()[index].getEventTo())
            room.getOptions()[index].connectBack(); //connect forward or back based on the action class
        else
            room.getOptions()[index].connectBack();
    }

    private void use(Inventory userInventory) {

    }

}
