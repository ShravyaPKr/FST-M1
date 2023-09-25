package Activities;

public class car {
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

    car(){
        tyres = 4;
        doors = 4;
    }

    public void displayCharacteristics(){
        System.out.println("Color of the Car: " + color);
        System.out.println("Transmission of the Car: " + transmission);
        System.out.println("Make of the Car: " + make);
        System.out.println("Number of types for the Car: " + tyres);
        System.out.println("Number of doors for the Car: " + doors);
    }
    public void accelerate() {
        System.out.println("Car is moving forward.");
    }
    public void brake() {
        System.out.println("Car has stopped.");
    }
}

