import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 10/17/17.
 */
public class Inventory {
//    private Map<String, Integer> objectsInInventory = new HashMap<>();
    private ArrayList<String> objectsInInventory;
    private Main main;
    //Adds the initial items
    public Inventory() {
        main = new Main();
        objectsInInventory = new ArrayList<String>();
    }

    public void addObject(String object) {
//        if (objectsInInventory.containsKey(object)) {
//            int numberOfElements = objectsInInventory.get(object);
//            objectsInInventory.remove(object);
//            objectsInInventory.put(object, numberOfElements + 1);
//        } else {
//            objectsInInventory.put(object, 1);
//            System.out.println("added");
//        }
        objectsInInventory.add(object);
    }

//    public void addObject(String object, int numberOfObjects) {
//        if (objectsInInventory.containsKey(object)) {
//            int numberOfElements = objectsInInventory.get(object);
//            objectsInInventory.remove(object);
//            objectsInInventory.put(object, numberOfElements + numberOfObjects);
//        } else {
//            objectsInInventory.put(object, numberOfObjects);
//        }
//    }


    public Event useItem(String object, Event room) {

        if (objectsInInventory.contains(object)) {
//            int numberOfElements = objectsInInventory.get(object);
//            objectsInInventory.remove(object);
//            objectsInInventory.put(object, numberOfElements - 1);

            if (room.getName().equalsIgnoreCase("Microwave")) {
                if (object.equalsIgnoreCase("Code")) {
                    return room.getOptions().get(0);
                }
            }

            if (room.getName().equalsIgnoreCase("fire place")) {
                if(object.equalsIgnoreCase("bagel"))
                    return room.getOptions().get(0);
            }

            if (room.getName().equalsIgnoreCase("stairs")) {
                if(object.equalsIgnoreCase("flashlight")){
                    System.out.println(room.getOptions().get(0).getName());
                    return room.getOptions().get(0);
                }
            }

            if (room.getName().equalsIgnoreCase("basement 1")){
                if(object.equalsIgnoreCase("gun")){
                    if(objectsInInventory.contains("bullets")) {
                        System.out.println("Who do you want to shoot--Santa or the Bagel boy?");
                        if(main.getInput().equalsIgnoreCase("santa")){
                            System.out.println("You shot Santa");
                            System.out.println("Bagel Boy gave you his bagel");
                            addObject("bagel");
                            return room.getOptions().get(0);
                        }
                        else if(main.getInput().equalsIgnoreCase("bagel boy")){
                            System.out.println("You shot the Bagel boy");
                            System.out.println("Santa gave you a present. It's a bomb... BOOM!!");
                            return room.getPriorEvent();
                        }
                    }
                }
            }

            if (room.getName().equalsIgnoreCase("Couch Cushion")) {
                if (object.equalsIgnoreCase("knife")) {
                    System.out.println("You cut open the mouse and get a key");
                    addObject("key");
                    return room.getPriorEvent();
                }
            }

            if (room.getName().equalsIgnoreCase("Dresser")) {
                if (object.equalsIgnoreCase("key")) {
                    System.out.println("You use the key to unlock the dresser");
                    return room.getOptions().get(0);
                }
            }


        } else {
            return room;
        }
        return null;
    }

//    public boolean useItem(String object, int numberOfObjects) {
//        if (objectsInInventory.containsKey(object)) {
//            int numberOfElements = objectsInInventory.get(object);
//            if (numberOfElements >= numberOfObjects) {
//                objectsInInventory.remove(object);
//                objectsInInventory.put(object, numberOfElements - numberOfObjects);
//                return true;
//            } else {
//                return false;
//            }
//        } else {
//            return false;
//        }
//    }
}
