import java.util.*;

public class AirportSimulator {
    public static void main(String[] args) throws InterruptedException {
        ControlTower tower = new ControlTower();

        List<Aircraft> aircrafts = Arrays.asList(
                new PassengerPlane("Flight-101", tower),
                new CargoPlane("Cargo-77", tower),
                new Helicopter("Helo-5", tower),
                new PassengerPlane("Flight-202", tower)
        );

        for (Aircraft a : aircrafts) {
            a.requestRunway();
            Thread.sleep(500);
        }

        System.out.println("\n⚠ EMERGENCY!\n");
        aircrafts.get(2).send("MAYDAY");

        tower.freeRunway();
        aircrafts.get(2).requestRunway();
    }
}
