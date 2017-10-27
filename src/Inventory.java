import java.util.ArrayList;

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

    public boolean isObjectInInventory(String object) {
        return objectsInInventory.contains(object.toLowerCase());
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
        System.out.println("You got a " + object);
        objectsInInventory.add(object.toLowerCase());
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

//            if (room.getName().equalsIgnoreCase("Microwave")) {
//                if (object.equalsIgnoreCase("Code")) {
//                    return room.getOptions().get(0);
//                }
//            }



            if (room.getName().equalsIgnoreCase("stairs")) {
                if(object.equalsIgnoreCase("flashlight")){
                    if (objectsInInventory.contains("batteries")){
                        System.out.println("You take out the flashlight and place the batteries in it. You turn it on to see the stairs \n and notice a couple steps are missing, so you jump over them.");
                        return room.getOptions().get(0);
                    }
                    else{
                        System.out.println("You take out the flashlight and try to turn it on... But it has no batteries!");
                    }

                }
            }

            if (room.getName().equalsIgnoreCase("basement")){
                if(object.equalsIgnoreCase("gun")){
                    if(objectsInInventory.contains("bullets")) {
                        System.out.println("Who do you want to shoot--Santa or the Bagel boy?");
                        if(main.getInput().equalsIgnoreCase("santa")){
                            System.out.println("You shot Santa");
                            System.out.println("Bagel Boy gave you his bagel");
                            addObject("bagel");
                            objectsInInventory.remove(objectsInInventory.indexOf("bullets"));
                            room.getOptions().get(0).setOpen(true);
                            room.setOpen(false);
                            room.getPriorEvent().addEvent(room.getOptions().get(0), 0);
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

            if (room.getName().equalsIgnoreCase("door 1")) {
                if (object.equalsIgnoreCase("key")) {
                    System.out.println("You use the key to unlock the dresser");
                    room.getOptions().get(0).setOpen(true);
                    room.getPriorEvent().addEvent(room.getOptions().get(0));
                    room.setOpen(false);
                    return room.getOptions().get(0);
                }
            }

            if (room.getName().equalsIgnoreCase("bathroom 1")){
                if(object.equalsIgnoreCase("brick")){
                    if(objectsInInventory.contains("flushed")){
                        return room.getPriorEvent();
                    }
                }
            }

            if (room.getName().equalsIgnoreCase("door 2")){
                if(object.equalsIgnoreCase("clothespin")){
                    room.getOptions().get(0).setOpen(true);
                    room.getPriorEvent().addEvent(room.getOptions().get(0));
                    room.setOpen(false);
                    return room.getOptions().get(0);
                }
            }

            if (room.getName().equalsIgnoreCase("microwave")){
                if(object.equalsIgnoreCase("code")){
                    room.getOptions().get(0).setOpen(true);
                    room.getPriorEvent().addEvent(room.getOptions().get(0));
                    room.setOpen(false);
                    objectsInInventory.remove(objectsInInventory.indexOf(object));
                    return room.getOptions().get(0);
                }
            }

            if (room.getName().equalsIgnoreCase("Couch")) {
                if (object.equalsIgnoreCase("blacklight")) {
                    System.out.println("You shine the Blacklight on the book. It reads: 'Use the Lamp.'");
                    room.getPriorEvent().addItem("Lamp");
                    return room;
                }
            }

            if (room.getName().equalsIgnoreCase("Trapdoor")) {
                if (object.equalsIgnoreCase("lamp")) {
                    System.out.println("You move the couch using the lamp as a lever");
                    room.getOptions().get(0).setOpen(true);
                    room.getPriorEvent().getPriorEvent().getPriorEvent().addEvent(room.getOptions().get(0));
                    room.setOpen(false);
                    room.getPriorEvent().setRoomExplaination("You feel under the couch... Nothing's there");
                    objectsInInventory.remove(objectsInInventory.indexOf(object));
                    return room.getOptions().get(0);
                }
            }

            if (room.getName().equalsIgnoreCase("fireplace")) {
                if (object.equalsIgnoreCase("bagel")) {
                    System.out.println("You give the bagel to the dog. The dog walks away happily.");
                    room.getOptions().get(0).setOpen(true);
                    room.getPriorEvent().addEvent(room.getOptions().get(0));
                    room.setOpen(false);
                    room.getPriorEvent().setRoomExplaination("You see a fireplace in the basement");
                    objectsInInventory.remove(objectsInInventory.indexOf(object));

                    if (objectsInInventory.contains("flushed")){
                        room.getOptions().get(0).setRoomExplaination("You notice that the water from the upstairs bathroom has overflowed \n to the basement and put out the fire in the fireplace. \n Is this your way out?");
                        room.getOptions().get(0).getOptions().get(0).setOpen(true);
                    }
                    else {
                        room.getOptions().get(0).setRoomExplaination("A fire roars in the fireplace. Maybe you should find a way to put it out...");
                    }

                    return room.getOptions().get(0);
                }
            }

            return room;


        } else {
            return room;
        }
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
