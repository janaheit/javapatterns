package be.abis.lan.model;

public class InkJet implements PrintingStrategy {
    @Override
    public void print(PacketComponent packet) {
        System.out.println("(InkJet Printer): " + packet.getContents());
    }
}
