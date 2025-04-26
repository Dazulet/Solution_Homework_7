public abstract class Aircraft {
    protected String id;
    protected TowerMediator tower;

    public Aircraft(String id, TowerMediator tower) {
        this.id = id;
        this.tower = tower;
    }

    public void send(String msg) {
        tower.broadcast(msg, this);
    }

    public abstract void receive(String msg);

    public String getId() {
        return id;
    }

    public void requestRunway() {
        boolean granted = tower.requestRunway(this);
        if (granted) {
            System.out.println(id + ": Runway granted, proceeding.");
        } else {
            System.out.println(id + ": Waiting for runway.");
        }
    }
}
