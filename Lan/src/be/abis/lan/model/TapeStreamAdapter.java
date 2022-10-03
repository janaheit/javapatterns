package be.abis.lan.model;

public class TapeStreamAdapter extends PacketHandler {

    private TapeStreamer tapeStreamer;

    public TapeStreamAdapter(TapeStreamer tapeStreamer) {
        super(tapeStreamer.getAddress());
        this.tapeStreamer = tapeStreamer;
    }

    @Override
    public void handle(PacketComponent packet) {
        tapeStreamer.stream(packet);
    }
}
