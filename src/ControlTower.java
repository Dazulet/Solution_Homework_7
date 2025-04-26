import java.util.*;

public class ControlTower implements TowerMediator {
    private LinkedList<Aircraft> landingQueue = new LinkedList<>();
    private Queue<Aircraft> takeoffQueue = new LinkedList<>();
    private boolean runwayAvailable = true;

    @Override
    public void broadcast(String msg, Aircraft sender) {
        System.out.println("Tower receives: " + msg + " from " + sender.getId());

        if (msg.equals("MAYDAY")) {
            System.out.println("⚠ EMERGENCY: Clearing runway for " + sender.getId());
            landingQueue.remove(sender);
            landingQueue.addFirst(sender); // move to front
            notifyAllOthers(sender.getId() + " is in emergency. Hold position.");
        }
    }

    private void notifyAllOthers(String msg) {
        System.out.println("Tower: " + msg);
        // In real case, would store list of aircraft and call .receive(msg)
    }

    @Override
    public boolean requestRunway(Aircraft a) {
        if (runwayAvailable) {
            runwayAvailable = false;
            System.out.println("Tower: Runway granted to " + a.getId());
            return true;
        } else {
            landingQueue.add(a);
            return false;
        }
    }

    public void freeRunway() {
        runwayAvailable = true;
    }
}
