package be.abis.lan.model;

import be.abis.lan.exception.DestinationNotFoundException;
import be.abis.lan.observer.Destination;
import be.abis.lan.observer.DestinationListener;
import be.abis.lan.observer.PacketArrivedEvent;

import java.util.ArrayList;
import java.util.List;

public abstract class PacketHandler extends Node implements Destination {

    private List<DestinationListener> destinationListeners = new ArrayList<>();

    public PacketHandler(String address) {
        super(address);
    }

    @Override
    public void receive(PacketComponent packet) throws DestinationNotFoundException {
        if (packet.getDestinationAddress().equals(getAddress())){
            handle(packet);
            notifyOrigin(new PacketArrivedEvent(this), packet);
        } else {
            send(packet);
        }
    }

    public abstract void handle(PacketComponent packet);

    @Override
    public void addDestinationListener(DestinationListener destListener) {
        destinationListeners.add(destListener);
    }

    @Override
    public void removeDestinationListener(DestinationListener destListener) {
        destinationListeners.remove(destListener);
    }

    private void notifyOrigin(PacketArrivedEvent packetArrivedEvent, PacketComponent packet){
        // notify only the listener that originated the packet
        for (DestinationListener l: this.destinationListeners){
            if (packet.getOriginAddress().equals(((WorkStation)l).getAddress())){
                l.confirm(packetArrivedEvent);
            }
        }
    }
}
