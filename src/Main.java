import java.util.Scanner;

/**
 * Created by student on 10/18/17.
 */
public class Main {

    private static Event yourRoom;
    private static Actions yourAction;

    private static Event startingRoom;
    private static Event dresser, dresserdoor;
    private static Event nerd;

    private static Event bathroom, bathroomdoor;
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

    private static Event kitchenMicrowave, kitchenMicrowavedoor;
    private static Event kitchenDishwasher;


    private static Event livingRoom;
    private static Event livingRoomCouch;
    private static Event livingRoomCouchUnder;
    private static Event livingRoomCouchCushion;

    private static Event livingRoomTrapDoor, livingRoomTrapDoordoor, darkStairs, basementBefore, basementAfter, bomb, bagel, fireplacedog, fireplace, outside;




    static {
        dresserdoor = new Event("You pull the door but it seems to be locked. There is a muffled sound coming from inside…", "Door 1");

        dresser = new Event("You open the dresser to see suction cups and a nerd stuffed in the corner.", "Dresser", false);
        dresser.addItem("Suction Cups");
        nerd = new Event("text", "Nerd");
        dresser.addEvent(nerd);
        dresserdoor.addEvent(dresser);


        bathroomdoor = new Event("“Door “2” is locked. Maybe if I had something to pick the lock it will open.", "Door 2");

        bathroom = new Event("", "Bathroom", false);
        bathroomShower = new Event("You go to the shower, reach down and try the knob, but it is stuck, so you twist it hard and it turns on. But you are immediately engulfed in fire and die.", "Shower");
        bathroomToilet = new Event("You see the out of place toilet because it looks brand new. You go over to it", "Toilet");
        bathroomToiletBowl = new Event("You look in the toilet bowl, and see a flashlight and a goldfish", "Toilet bowl");
        bathroomToiletBowl.addItem("Goldfish");
        bathroomToiletBowl.addItem("Flashlight");
        bathroomToiletBack = new Event("You look in the back of the toilet and see a large brick, it is somehow not eroded at all and very strong.", "Toilet back");
        bathroomToiletBack.addItem("Brick");
        bathroomToiletFlush = new Event("You flush the toilet to see what it does, bad call. You hear the door shut with a metallic click. You notice the toilet is not flushing, but it is filling up and flooding the room very fast. You run to the door to try to get out, but as you thought it is locked. Use the brick to escape", "Toilet flusher");
        bathroomToilet.addEvent(bathroomToiletBack);
        bathroomToilet.addEvent(bathroomToiletBowl);
        bathroomToilet.addEvent(bathroomToiletFlush);

        bathroomCabinet = new Event("While in the bathroom, you see a cabinet, the hinges are rusted over, and there is a hole in one of the doors. When you open the door you see two items covered in cobwebs. A blacklight, and bullets.", "Cabinet");
        bathroomCabinet.addItem("Bullets");
        bathroomCabinet.addItem("Blacklight");

        bathroomdoor.addEvent(bathroom);
        bathroom.addEvent(bathroomShower);
        bathroom.addEvent(bathroomToilet);
        bathroom.addEvent(bathroomCabinet);

        kitchen = new Event("You open door 1 to find a small kitchen. You see a sink, a Dishwasher, and a microwave.", "Kitchen");
        kitchenSink = new Event("The sink looks rusty, maybe the water still works.", "Sink");
        kitchenSinkWater = new Event("You turn the knob and a few drops come out along with a clothespin. You pick up the clothes pin", "Water");
        kitchenSinkWater.addItem("Clothespin");
        kitchenSinkDrain = new Event("You look down the rusty drain, there is nothing to be found.", "Drain");
        kitchenSink.addEvent(kitchenSinkWater);
        kitchenSink.addEvent(kitchenSinkDrain);

        kitchenMicrowave = new Event("The microwave pops open and you look inside…", "Microwave", false);
        kitchenMicrowave.addItem("gun");

        kitchenMicrowavedoor = new Event("You try to open the microwave but it won’t budge. The display seems to be flashing something… it says “enter code”", "Microwave");
        kitchenMicrowavedoor.addEvent(kitchenMicrowave);

        kitchenDishwasher = new Event("You pull open the dishwasher. It clearly hasn’t been run in a while, there are cobwebs everywhere along with a couple objects: a Knife, a bagel, and batteries.", "Dishwasher");
        kitchenDishwasher.addItem("Knife");
        kitchenDishwasher.addItem("Batteries");
        kitchenDishwasher.addItem("Bagel");
        kitchen.addEvent(kitchenSink);
        kitchen.addEvent(kitchenMicrowavedoor);
        kitchen.addEvent(kitchenDishwasher);

        livingRoom = new Event("Door 3 opens to reveal a living room with an old couch in the middle.", "Living Room");
        livingRoomCouch = new Event("There’s a large cushion, a book sitting on the side, and also seems to be something under the couch.", "Couch");
        livingRoomCouchCushion = new Event("You lift the cushion and see a rotting, smelly dead mouse, maybe there’s something inside", "Couch Cushion");
        livingRoomCouchUnder = new Event("You feel under the couch and there seems to be a door, what you suspect to be a trap door.", "Couch under");

        livingRoomTrapDoordoor = new Event("You try to move the couch but you can’t move it. Look around the room for help", "Trapdoor");
        livingRoomTrapDoor = new Event("You open the trapdoor", "Trapdoor", false);
        livingRoomTrapDoordoor.addEvent(livingRoomTrapDoor);

        livingRoomCouch.addEvent(livingRoomCouchCushion);
        livingRoomCouch.addEvent(livingRoomCouchUnder);
        livingRoomCouchUnder.addEvent(livingRoomTrapDoordoor);
        livingRoom.addEvent(livingRoomCouch);

        darkStairs = new Event("The stairs are pitch black", "stairs");
        livingRoomTrapDoor.addEvent(darkStairs);

        basementBefore = new Event("You step down into the basement and see Santa fighting the Bagel boy. \n You should probably stop the fight somehow...", "Basement");
        darkStairs.addEvent(basementBefore);

        basementAfter = new Event("You see a fireplace in the basement. An angry dog is guarding it. Maybe it's just hangry...", "Basement", false);
        basementBefore.addEvent(basementAfter);

        fireplacedog = new Event("The angry dog growls at you threateningly.", "fireplace");
        basementAfter.addEvent(fireplacedog);

        fireplace = new Event("huh", "fireplace", false);
        fireplacedog.addEvent(fireplace);

        outside = new Event("", "outside", false);
        fireplace.addEvent(outside);

        startingRoom = new Event("There are three doors, each labeled 1-3. The room is empty except for a large dresser in the corner. \n You reach into your pocket and pull out a small piece of paper, written on it in chicken scratch handwriting ‘KCIUQ TUO TEG’", "start");
        startingRoom.addEvent(dresserdoor);
        startingRoom.addEvent(kitchen);
        startingRoom.addEvent(bathroomdoor);
        startingRoom.addEvent(livingRoom);

        fireplacedog.setPriorEvent(basementAfter);
        basementAfter.setPriorEvent(darkStairs);
        basementBefore.setPriorEvent(darkStairs);
        livingRoomTrapDoordoor.setPriorEvent(livingRoomCouchUnder);
        kitchenMicrowavedoor.setPriorEvent(kitchen);
        dresserdoor.setPriorEvent(startingRoom);
        bathroomdoor.setPriorEvent(startingRoom);
        fireplace.setPriorEvent(basementAfter);
        bathroomToiletBack.setPriorEvent(bathroomToilet);
        bathroomToiletBowl.setPriorEvent(bathroomToilet);
        bathroomToiletFlush.setPriorEvent(bathroomToilet);
        bathroomShower.setPriorEvent(bathroom);
        bathroomToilet.setPriorEvent(bathroom);
        bathroomCabinet.setPriorEvent(bathroom);
        kitchenSinkWater.setPriorEvent(kitchenSink);
        kitchenSinkDrain.setPriorEvent(kitchenSink);
        kitchenSink.setPriorEvent(kitchen);
        kitchenDishwasher.setPriorEvent(kitchen);
        kitchenMicrowave.setPriorEvent(kitchen);
        livingRoomCouchUnder.setPriorEvent(livingRoomCouch);
        livingRoomCouchCushion.setPriorEvent(livingRoomCouch);
        livingRoomCouch.setPriorEvent(livingRoom);
        darkStairs.setPriorEvent(livingRoomTrapDoor);
        livingRoomTrapDoor.setPriorEvent(livingRoom);
        dresser.setPriorEvent(startingRoom);
        kitchen.setPriorEvent(startingRoom);
        bathroom.setPriorEvent(startingRoom);
        livingRoom.setPriorEvent(startingRoom);

        yourRoom = startingRoom;
        yourAction = new Actions();


    }

    public static void main(String[] args) {
        System.out.println("Begin the Game?");

//        System.out.println(yourRoom.getOptions().size());
        if(getInput().equalsIgnoreCase("yes")) {
            System.out.println("*Thunder Claps* *Lightning flashes* You wake up in a daze. Where am I? What is this place? It appears to be a dark room with high vaulted ceilings. ");
            examineRoom();
        }


    }

    public static void examineRoom(){
        while(yourRoom.getNumberOfOptions() > 0 || yourRoom.getPriorEvent() != null) {
            System.out.println(yourRoom.getRoomExplaination());
            String input = getInput();
            int connection = yourAction.callOption(input, yourRoom);
            yourRoom = yourAction.makeConnection(yourRoom, connection);
        }
        System.out.println("You made it out!");
    }

    public static String getInput() {
        Scanner s = new Scanner(System.in);
        return s.nextLine().toLowerCase();
    }
}
