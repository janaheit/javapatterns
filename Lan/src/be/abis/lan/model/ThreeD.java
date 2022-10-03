package be.abis.lan.model;

public class ThreeD implements PrintingStrategy {
    @Override
    public void print(PacketComponent packet) {
        System.out.println("(3D Printer): " + packet.getContents());
    }
}
