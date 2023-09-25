package Activities;

public class Activity1 {
    public static void main(String[] args) {
        car c1 = new car();
        c1.make = 2014;
        c1.color = "Black";
        c1.transmission = "Manual";

        c1.displayCharacteristics();
        c1.accelerate();
        c1.brake();
    }
}
