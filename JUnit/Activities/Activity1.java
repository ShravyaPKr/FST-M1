package Activities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;

public class Activity1 {
    static ArrayList<String> list = null;

    @BeforeAll
    public static void setUp(){
        // Initialize a new ArrayList
        list = new ArrayList<>();
        list.add("alpha");
        list.add("beta");
    }

    @Test
    public void insertTest(){
        assertEquals(list.size(),2,"Array Size is different");
        list.add("gamma");
        assertEquals(list.size(),3,"Updated Array Size is different");
        assertEquals("alpha",list.get(0),"Wrong Element");
        assertEquals("beta",list.get(1),"Wrong Element");
        assertEquals("gamma",list.get(2),"Wrong Element");
    }

    @Test
    public void replaceTest(){
        assertEquals(list.size(),2,"Array Size is different");
        list.add("Gamma - Replace");
        assertEquals(list.size(),3,"Updated Array Size is different");
        list.set(1,"Alpha - Replaced");
        assertEquals("alpha",list.get(0),"Wrong Element");
        assertEquals("Alpha - Replaced",list.get(1),"Wrong Element");
        assertEquals("Gamma - Replace",list.get(2),"Wrong Element");
    }
}
