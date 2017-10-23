import java.util.Scanner;

/**
 * Created by student on 10/18/17.
 */
public class Main {

    private static Event yourRoom;

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

    private static Event livingRoomTrapDoor;




    public Main() {
        yourRoom = new Event(null, null, "yee");

        startingRoom = new Event("*Thunder Claps* *Lightning flashes* You wake up in a daze. Where am I? What is this place? It appears to be a dark room with high vaulted ceilings. There are three doors, each labeled 1-3. The room is empty except for a large dresser in the corner.");
        dresser = new Event("text");

        bathroom = new Event("Text");
        bathroomShower = new Event("Text");
        bathroomToilet = new Event("text");
        bathroomToiletBowl = new Event("Text");
        bathroomToiletBack = new Event("Text");
        bathroomToiletFlush = new Event("text");
        bathroomToilet.addEvent(bathroomToiletBack);
        bathroomToilet.addEvent(bathroomToiletBowl);
        bathroomToilet.addEvent(bathroomToiletFlush);
        bathroomCabinet = new Event("text");
        bathroom.addEvent(bathroomShower);
        bathroom.addEvent(bathroomToilet);
        bathroom.addEvent(bathroomCabinet);

        kitchen = new Event("Text");
        kitchenSink = new Event("text");
        kitchenSinkWater = new Event("text");
        kitchenSinkDrain = new Event("text");
        kitchenSink.addEvent(kitchenSinkWater);
        kitchenSink.addEvent(kitchenSinkDrain);
        kitchenMicrowave = new Event("text");
        kitchenDishwasher = new Event("text");
        kitchen.addEvent(kitchenSink);
        kitchen.addEvent(kitchenMicrowave);
        kitchen.addEvent(kitchenDishwasher);

        livingRoom = new Event("text");
        startingRoom.addEvent(dresser);
        startingRoom.addEvent(kitchen);
        startingRoom.addEvent(bathroom);
        startingRoom.addEvent(livingRoom);
    }

    public static void main(String[] args) {
        System.out.println("Begin the Game?");

        if(getInput().equals("yes"))
            examineRoom();


    }

    public static void examineRoom(){
        while(true) {


        }
    }

    public static String getInput() {
        Scanner s = new Scanner(System.in);
        return s.nextLine().toLowerCase();
    }
}
