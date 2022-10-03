package be.abis.lan.model;

public interface PacketComponent {
    String getContents();
    String getOriginAddress();
    void setOriginAddress(String originAddress);
    String getDestinationAddress();
}
