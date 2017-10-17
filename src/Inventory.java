import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 10/17/17.
 */
public class Inventory {
    private Map<String, Integer> objectsInInventory = new HashMap<>();

    //Adds the initial items
    public Inventory() {

    }

    public void addObject(String object) {
        if (objectsInInventory.containsKey(object)) {
            int numberOfElements = objectsInInventory.get(object);
            objectsInInventory.remove(object);
            objectsInInventory.put(object, numberOfElements + 1);
        } else {
            objectsInInventory.put(object, 1);
        }
    }

    public void addObject(String object, int numberOfObjects) {
        if (objectsInInventory.containsKey(object)) {
            int numberOfElements = objectsInInventory.get(object);
            objectsInInventory.remove(object);
            objectsInInventory.put(object, numberOfElements + numberOfObjects);
        } else {
            objectsInInventory.put(object, numberOfObjects);
        }
    }


    public boolean useItem(String object) {
        if (objectsInInventory.containsKey(object)) {
            int numberOfElements = objectsInInventory.get(object);
            objectsInInventory.remove(object);
            objectsInInventory.put(object, numberOfElements - 1);
            return true;
        } else {
            return false;
        }
    }

    public boolean useItem(String object, int numberOfObjects) {
        if (objectsInInventory.containsKey(object)) {
            int numberOfElements = objectsInInventory.get(object);
            if (numberOfElements >= numberOfObjects) {
                objectsInInventory.remove(object);
                objectsInInventory.put(object, numberOfElements - numberOfObjects);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
