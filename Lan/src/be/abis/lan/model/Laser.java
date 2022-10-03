package be.abis.lan.model;

public class Laser implements PrintingStrategy {
    @Override
    public void print(PacketComponent packet) {
        System.out.println("(Laser Printer): " + packet.getContents());
    }
}
