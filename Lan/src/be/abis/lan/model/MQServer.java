package be.abis.lan.model;

public class MQServer extends PacketHandler {

    public MQServer(String address) {
        super(address);
    }

    @Override
    public void handle(PacketComponent packet) {
        process(packet);
    }

    private void process(PacketComponent packet){
        System.out.println(getAddress() + " is processing " + packet.getContents());
    }
}
