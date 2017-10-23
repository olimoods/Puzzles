import java.util.Scanner;

/**
 * Created by student on 10/18/17.
 */
public class Main {

    private static Event yourRoom;

    public Main() {
        yourRoom = new Event(null, null, "yee");
    }

    public static void main(String[] args) {
        System.out.println("Begin the Game?");

        if(getInput().equals("yes"))
            examineRoom();
    }

    public static void examineRoom(){
        while(true) {
            System.out.println(yourRoom.getRoomExplaination());

        }
    }

    public static String getInput() {
        Scanner s = new Scanner(System.in);
        return s.nextLine().toLowerCase();
    }
}
