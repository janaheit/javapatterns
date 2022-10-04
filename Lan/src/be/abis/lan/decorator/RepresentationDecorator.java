package be.abis.lan.decorator;

public abstract class RepresentationDecorator implements Representation {

    private Representation representation;

    public RepresentationDecorator(Representation representation) {
        this.representation = representation;
    }

    @Override
    public void represent() {
        representation.represent();
    }

    public Representation getRepresentation() {
        return representation;
    }
}
