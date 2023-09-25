package Activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("Apple");
        myList.add("Mango");
        myList.add("Orange");
        String anticipatedString = "Apple";
        int count =0;
        System.out.println("Printing all elements in the List");
        for (String list: myList)
             {
                 System.out.println(list);
             }
        System.out.println("Checking if a particular element exists in the list");
        for (String list: myList)
        {
            if(myList.contains(anticipatedString))
            {
                count++;
            }
        }
        if(count > 0)
        {
            System.out.println("The given name " + " - " + anticipatedString + " is present in the list");
        }
        System.out.println("Total number of elements present in the list " + myList.size());
        myList.remove("Orange");
        System.out.println("Size of the list after removing an element is " + myList.size());



        }
    }
