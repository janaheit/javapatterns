package be.abis.lan.model;

public class TapeStreamer  {
    private String address;

    public TapeStreamer(String address) {
        this.address = address;
    }

    public void stream(PacketComponent packet){
        System.out.println(this.address + " is streaming "+ packet.getContents());
    }


    // GETTERS AND SETTERS

    public String getAddress() {
        return address;
    }
}
