package Activities;

import java.util.ArrayList;
import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        hs.add("Apple");
        hs.add("Mango");
        hs.add("Orange");
        hs.add("PineApple");
        hs.add("Banana");
        hs.add("Grape");
        String anticipatedString = "Apple";
        int count =0;
        System.out.println("Printing all elements in the List");
        System.out.println("Total number of elements present in the set " + hs.size());
        hs.remove("Banana");
        //Trying to remove element not present in SET

        if(hs.remove("Muskmelon")) {
            System.out.println("'Muskmelon'' removed from the Set");
        } else {
            System.out.println("'Muskmelon' is not present in the Set");
        }
        System.out.println("Checking if a particular element exists in the list");
        for (String set: hs)
        {
            if(hs.contains(anticipatedString))
            {
                count++;
            }
        }
        if(count > 0)
        {
            System.out.println("The given name " + " - " + anticipatedString + " is present in the Set");
        }
        System.out.println("Updated set size is : " + hs.size());
        System.out.println("The updated Set");
        for (String set: hs)
        {
            System.out.println(set);
        }
    }
}