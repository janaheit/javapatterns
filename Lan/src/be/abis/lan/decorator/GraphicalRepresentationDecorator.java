package be.abis.lan.decorator;

public class GraphicalRepresentationDecorator extends RepresentationDecorator {

    public GraphicalRepresentationDecorator(Representation representation) {
        super(representation);
    }

    @Override
    public void represent(){
        super.represent();
        System.out.println("(graphics)");
    }
}
