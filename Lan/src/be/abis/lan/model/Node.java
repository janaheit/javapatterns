package be.abis.lan.model;

import be.abis.lan.decorator.Representation;
import be.abis.lan.exception.DestinationNotFoundException;

public class Node extends LanComponent implements Representation {

    public Node(String address) {
        super(address);
    }

    @Override
    public void send(PacketComponent packet) throws DestinationNotFoundException {
        getNextComponent().receive(packet);
    }

    @Override
    public void receive(PacketComponent packet) throws DestinationNotFoundException {
        send(packet);
    }


    @Override
    public void represent() {
        System.out.println("(circle)");
    }
}
