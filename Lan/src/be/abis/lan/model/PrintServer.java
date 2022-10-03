package be.abis.lan.model;

public class PrintServer extends PacketHandler {
    private PrintingStrategy printingStrategy;

    public PrintServer(String address, PrintingStrategy printingStrategy) {
        super(address);
        this.printingStrategy = printingStrategy;
    }

    @Override
    public void handle(PacketComponent packet) {
        print(packet);
    }

    private void print(PacketComponent packet){
        System.out.println(getAddress() + " is printing with ");
        printingStrategy.print(packet);
        //System.out.println(getAddress() + " printed: " + packet.getContents());
    }

    // GETTERS AND SETTERS

    public PrintingStrategy getPrintingStrategy() {
        return printingStrategy;
    }

    public void setPrintingStrategy(PrintingStrategy printingStrategy) {
        this.printingStrategy = printingStrategy;
    }
}
