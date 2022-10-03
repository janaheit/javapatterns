package be.abis.lan.model;

public class FileServer extends PacketHandler {

    public FileServer(String address) {
        super(address);
    }

    @Override
    public void handle(PacketComponent packet) {
        save(packet);
    }

    private void save(PacketComponent packet){
        System.out.println(getAddress() + " is saving " + packet.getContents());
    }
}
