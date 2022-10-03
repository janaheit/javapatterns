package be.abis.lan.factory;

import be.abis.lan.enums.PacketType;
import be.abis.lan.model.PacketComponent;

public abstract class PacketFactory {

    public static PacketFactory createFactory(PacketType packetType){
        switch (packetType){
            default:
            case SIMPLE:
                return SimplePacketFactory.getInstance();
            case SUPERPACKET:
                return SuperpacketFactory.getInstance();
        }
    }

    public abstract PacketComponent createPacket(String destinationAddress, String contents);
}
