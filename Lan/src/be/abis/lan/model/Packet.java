package be.abis.lan.model;

public class Packet implements PacketComponent {
    private String destinationAddress;
    private String originAddress;
    private String contents;

    public Packet(String destinationAddress, String contents) {
        this.destinationAddress = destinationAddress;
        this.contents = contents;
    }

    // GETTERS AND SETTERS

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }


    @Override
    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getOriginAddress() {
        return originAddress;
    }

    public void setOriginAddress(String originAddress) {
        this.originAddress = originAddress;
    }
}


