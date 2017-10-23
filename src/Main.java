import java.util.Scanner;

/**
 * Created by student on 10/18/17.
 */
public class Main {

    private static Event yourRoom;

    private static Event startingRoom;

    public Main() {
        yourRoom = new Event(null, null, "yee");

        startingRoom = new Event("*Thunder Claps* *Lightning flashes* You wake up in a daze. Where am I? What is this place? It appears to be a dark room with high vaulted ceilings. There are three doors, each labeled 1-3. The room is empty except for a large dresser in the corner.");
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
