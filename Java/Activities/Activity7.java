package Activities;

public class Activity7 {
    public static void main(String[] args) {
        MountainBike mb = new MountainBike(2,15,1);
        mb.bicycleDesc();
        mb.speedUp(4);
        mb.applyBrake(2);
        mb.setHeight(2);
        mb.bicycleDesc();

    }
}
