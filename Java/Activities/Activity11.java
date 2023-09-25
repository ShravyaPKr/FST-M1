package Activities;

import java.util.Collection;
import java.util.HashMap;


public class Activity11 {
    public static void main(String[] args) {
        HashMap<Integer, String> colours = new HashMap<Integer, String>();
        //Adding values to map
        colours.put(1,"Red");
        colours.put(2,"Yellow");
        colours.put(3,"Blue");
        colours.put(4,"Marron");
        colours.put(5,"Green");

        //Removing a value
        colours.remove(2);

        //Check if Green exists in Ma
        if(colours.containsValue("Green")) {
            System.out.println("Green exists in the Map");
        } else {
            System.out.println("Green does not exist in the Map");
        }

        //Size of the Map
        System.out.println("Size of the Map is : " + colours.size());

        // Printing the Final Map
        System.out.println("The Final map: " + colours);

    }
}
