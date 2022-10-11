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
        // the subpackets should be added via add component and not in the constructor -> this is more of the decorator already

    }

    @Override
    public String getContents() {
        StringBuilder content = new StringBuilder();
        for (PacketComponent pc: subPackets){

            if (pc instanceof Superpacket){
                content.append(pc.getContents());
            } else {
                content.append(pc.getContents());
                content.append(" ");
            }
        }

        return content.toString();
    }

    private Boolean hasSuperPackets(){
        for (PacketComponent pc: subPackets){
            if (pc instanceof Superpacket) return true;
        }
        return false;
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
