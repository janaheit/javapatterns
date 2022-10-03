package be.abis.lan.model;

public interface DestinationListener {

    void confirm(PacketArrivedEvent packetArrivedEvent);
}
