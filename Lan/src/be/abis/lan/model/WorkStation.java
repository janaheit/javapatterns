package be.abis.lan.model;

import be.abis.lan.exception.DestinationNotFoundException;
import be.abis.lan.observer.DestinationListener;
import be.abis.lan.observer.PacketArrivedEvent;

public class WorkStation extends Node implements DestinationListener {
    public WorkStation(String address) {
        super(address);
    }

    public void originate(PacketComponent packet) throws DestinationNotFoundException {
        packet.setOriginAddress(getAddress());
        send(packet);
    }

    @Override
    public void receive(PacketComponent packet) throws DestinationNotFoundException {
        if (packet.getOriginAddress().equals(getAddress())) {
            throw new DestinationNotFoundException("destination of this packet (" + packet.getContents() + ") could not be found");
        }
        send(packet);
    }

    @Override
    public void confirm(PacketArrivedEvent packetArrivedEvent) {
        System.out.println(getAddress() + " was notified that a package originated here arrived at " + packetArrivedEvent.getSource().getAddress());
    }
}
