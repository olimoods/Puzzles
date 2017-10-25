import java.util.Scanner;

/**
 * Created by student on 10/18/17.
 */
public class Main {

    private static Event yourRoom;
    private static Actions yourAction;

    private static Event startingRoom;
    private static Event dresser;
    private static Event nerd;

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

        dresser.addItem("Suction Cups");
        nerd = new Event("text", "Nerd");
        dresser.addEvent(nerd);


        bathroom = new Event("Text", "Bathroom");
        bathroomShower = new Event("Text", "Shower");
        bathroomToilet = new Event("text", "Toilet");
        bathroomToiletBowl = new Event("Text", "Toilet bowl");
        bathroomToiletBowl.addItem("Goldfish");
        bathroomToiletBowl.addItem("Flashlight");
        bathroomToiletBack = new Event("Text", "Toilet back");
        bathroomToiletBack.addItem("Brick");
        bathroomToiletFlush = new Event("text", "Toilet flusher");
        bathroomToilet.addEvent(bathroomToiletBack);
        bathroomToilet.addEvent(bathroomToiletBowl);
        bathroomToilet.addEvent(bathroomToiletFlush);

        bathroomToiletBack.setPriorEvent(bathroomToilet);
        bathroomToiletBowl.setPriorEvent(bathroomToilet);
        bathroomToiletFlush.setPriorEvent(bathroomToilet);

        bathroomCabinet = new Event("text", "Cabinet");
        bathroomCabinet.addItem("Bullets");
        bathroomCabinet.addItem("Blacklight");

        bathroomShower.setPriorEvent(bathroom);
        bathroomToilet.setPriorEvent(bathroom);
        bathroomCabinet.setPriorEvent(bathroom);

        bathroom.addEvent(bathroomShower);
        bathroom.addEvent(bathroomToilet);
        bathroom.addEvent(bathroomCabinet);

        kitchen = new Event("Text", "Kitchen");
        kitchenSink = new Event("text", "Sink");
        kitchenSinkWater = new Event("text", "Water");
        kitchenSinkWater.addItem("Clothes Pin");
        kitchenSinkDrain = new Event("text", "Drain");
        kitchenSink.addEvent(kitchenSinkWater);
        kitchenSink.addEvent(kitchenSinkDrain);

        kitchenSinkWater.setPriorEvent(kitchenSink);
        kitchenSinkDrain.setPriorEvent(kitchenSink);

        kitchenMicrowave = new Event("text", "Microwave");
        kitchenDishwasher = new Event("text", "Dishwasher");
        kitchenDishwasher.addItem("Knife");
        kitchenDishwasher.addItem("Oven Mitt");
        kitchenDishwasher.addItem("Bagel");
        kitchen.addEvent(kitchenSink);
        kitchen.addEvent(kitchenMicrowave);
        kitchen.addEvent(kitchenDishwasher);

        kitchenSink.setPriorEvent(kitchen);
        kitchenDishwasher.setPriorEvent(kitchen);
        kitchenMicrowave.setPriorEvent(kitchen);

        livingRoom = new Event("text", "Living Room");
        livingRoomCouch = new Event("text", "Couch");
        livingRoomCouchCushion = new Event("text", "Couch Cushion");
        livingRoomCouchUnder = new Event("text", "Couch under");
        livingRoomTrapDoor = new Event("text", "Trapdoor");
        livingRoomCouch.addEvent(livingRoomCouchCushion);
        livingRoomCouch.addEvent(livingRoomCouchUnder);

        livingRoomCouchUnder.setPriorEvent(livingRoomCouch);
        livingRoomCouchCushion.setPriorEvent(livingRoomCouch);

        livingRoom.addEvent(livingRoomCouch);
        livingRoom.addEvent(livingRoomTrapDoor);

        livingRoomCouch.setPriorEvent(livingRoom);
        livingRoomTrapDoor.setPriorEvent(livingRoom);


        startingRoom = new Event("*Thunder Claps* *Lightning flashes* You wake up in a daze. Where am I? What is this place? It appears to be a dark room with high vaulted ceilings. There are three doors, each labeled 1-3. The room is empty except for a large dresser in the corner.", "start");
        startingRoom.addEvent(dresser);
        startingRoom.addEvent(kitchen);
        startingRoom.addEvent(bathroom);
        startingRoom.addEvent(livingRoom);

        dresser.setPriorEvent(startingRoom);
        kitchen.setPriorEvent(startingRoom);
        bathroom.setPriorEvent(startingRoom);
        livingRoom.setPriorEvent(startingRoom);

        startingRoom = new Event("*Thunder Claps* *Lightning flashes* You wake up in a daze. Where am I? What is this place? It appears to be a dark room with high vaulted ceilings. There are three doors, each labeled 1-3. The room is empty except for a large dresser in the corner.", "start");
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
