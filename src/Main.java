import java.util.Scanner;

/**
 * Created by student on 10/18/17.
 */
public class Main {

    private static Event yourRoom;
    private static Actions yourAction;

    private static Event startingRoom;
    private static Event dresser;
    private static Event bathroom;
    private static Event bathroomShower;
    private static Event bathroomToilet;
    private static Event bathroomToiletBowl;
    private static Event bathroomToiletBack;
    private static Event bathroomToiletFlush;
    private static Event bathroomCabinet;



    private static Event kitchen;
    private static Event kitchenSink;
    private static Event kitchenSinkWater;
    private static Event kitchenSinkDrain;

    private static Event kitchenMicrowave;
    private static Event kitchenDishwasher;


    private static Event livingRoom;
    private static Event livingRoomCouch;
    private static Event livingRoomCouchUnder;
    private static Event livingRoomCouchCushion;

    private static Event livingRoomTrapDoor, darkStairs, basement, shootSanta, shootbBoy, bomb, bagel, fireplace, chimney, outside;




    static {
        dresser = new Event("text", "Dresser");

        bathroom = new Event("Text", "Bathroom");
        bathroomShower = new Event("Text", "Bathroom shower");
        bathroomToilet = new Event("text", "Bathroom toilet");
        bathroomToiletBowl = new Event("Text", "Toilet bowl");
        bathroomToiletBack = new Event("Text", "Toilet back");
        bathroomToiletFlush = new Event("text", "Toilet flusher");
        bathroomToilet.addEvent(bathroomToiletBack);
        bathroomToilet.addEvent(bathroomToiletBowl);
        bathroomToilet.addEvent(bathroomToiletFlush);
        bathroomCabinet = new Event("text", "Cabinet");
        bathroom.addEvent(bathroomShower);
        bathroom.addEvent(bathroomToilet);
        bathroom.addEvent(bathroomCabinet);

        kitchen = new Event("Text", "Kitchen");
        kitchenSink = new Event("text", "Sink");
        kitchenSinkWater = new Event("text", "Water");
        kitchenSinkDrain = new Event("text", "Drain");
        kitchenSink.addEvent(kitchenSinkWater);
        kitchenSink.addEvent(kitchenSinkDrain);
        kitchenMicrowave = new Event("text", "Microwave");
        kitchenDishwasher = new Event("text", "Dishwasher");
        kitchen.addEvent(kitchenSink);
        kitchen.addEvent(kitchenMicrowave);
        kitchen.addEvent(kitchenDishwasher);

        livingRoom = new Event("text", "Living Room");
        startingRoom = new Event("*Thunder Claps* *Lightning flashes* You wake up in a daze. Where am I? What is this place? It appears to be a dark room with high vaulted ceilings. There are three doors, each labeled 1-3. The room is empty except for a large dresser in the corner.", "Start room");

        startingRoom.addEvent(dresser);
        startingRoom.addEvent(kitchen);
        startingRoom.addEvent(bathroom);
        startingRoom.addEvent(livingRoom);
        yourRoom = startingRoom;
        yourAction = new Actions();


    }

    public static void main(String[] args) {
        System.out.println("Begin the Game?");

        if(getInput().equalsIgnoreCase("yes"))
            examineRoom();


    }

    public static void examineRoom(){
        System.out.println("yee");
        while(yourRoom.getNumberOfOptions() > 0) {
            System.out.println("yee");
            System.out.println(yourRoom.getRoomExplaination());
            String input = getInput();
            int connection = yourAction.callOption(input, yourRoom);
            yourRoom = yourAction.makeConnection(yourRoom, connection);
        }
    }

    public static String getInput() {
        Scanner s = new Scanner(System.in);
        return s.nextLine().toLowerCase();
    }
}
