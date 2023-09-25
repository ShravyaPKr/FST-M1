package Activities;

public class MountainBike extends Bicycle{
    int seatHeight;
    public MountainBike(int gears, int currentSpeed, int initialSeatHeight) {
        super(gears, currentSpeed);
        seatHeight = initialSeatHeight;
    }

    public void setHeight(int newValue) {
        seatHeight = newValue;
    }

    @Override
    public String bicycleDesc() {
        System.out.println("Seat Height: " + seatHeight);
        return super.bicycleDesc();
    }
}
