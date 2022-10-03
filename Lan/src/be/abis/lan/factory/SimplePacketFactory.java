package be.abis.lan.factory;

import be.abis.lan.model.Packet;
import be.abis.lan.model.PacketComponent;

public class SimplePacketFactory extends PacketFactory {
    private static SimplePacketFactory simplePacketFactory;

    private SimplePacketFactory() {
    }

    public PacketComponent createPacket(String destinationAddress, String contents){
        return new Packet(destinationAddress, contents);
    }

    public static SimplePacketFactory getInstance(){
        if (simplePacketFactory==null) simplePacketFactory = new SimplePacketFactory();
        return simplePacketFactory;
    }
}
