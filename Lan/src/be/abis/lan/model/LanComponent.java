package be.abis.lan.model;

import be.abis.lan.exception.DestinationNotFoundException;

public abstract class LanComponent {

    private String address;
    private LanComponent nextComponent;

    public LanComponent(String address) {
        this.address = address;
    }

    // BUSINESS METHODS
    public abstract void send(PacketComponent packet) throws DestinationNotFoundException;

    public abstract void receive(PacketComponent packet) throws DestinationNotFoundException;


    // GETTERS AND SETTERS
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LanComponent getNextComponent() {
        return nextComponent;
    }

    public void setNextComponent(LanComponent nextComponent) {
        this.nextComponent = nextComponent;
    }
}
