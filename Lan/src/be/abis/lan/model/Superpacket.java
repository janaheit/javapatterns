package be.abis.lan.model;

import java.util.ArrayList;
import java.util.List;

public class Superpacket implements PacketComponent {
    private List<PacketComponent> subPackets = new ArrayList<>();
    private String destinationAddress;
    private String originAddress;

    public Superpacket(String destinationAddress, List<PacketComponent> subPackets) {
        this.destinationAddress = destinationAddress;
        this.subPackets = subPackets;
    }

    @Override
    public String getContents() {
        String content = "";
        for (PacketComponent pc: subPackets){
            content = content + " " + pc.getContents();
        }
        return content;
    }

    public void addPacketComponent(PacketComponent pc){
        this.subPackets.add(pc);
    }

    // GETTERS AND SETTERS
    @Override
    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    @Override
    public String getOriginAddress() {
        return originAddress;
    }

    public void setOriginAddress(String originAddress) {
        this.originAddress = originAddress;
    }
}
