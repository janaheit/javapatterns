package be.abis.lan.model;

public class PacketArrivedEvent  {
    private PacketHandler source;


    public PacketArrivedEvent(PacketHandler packetHandler) {
        this.source = packetHandler;
    }

    // getters and setters

    public PacketHandler getSource() {
        return source;
    }

}
