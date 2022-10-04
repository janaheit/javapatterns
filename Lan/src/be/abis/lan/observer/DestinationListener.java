package be.abis.lan.observer;

public interface DestinationListener {

    void confirm(PacketArrivedEvent packetArrivedEvent);
}
