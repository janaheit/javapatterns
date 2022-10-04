package be.abis.lan.decorator;

import be.abis.lan.model.Node;

public class ShadedRepresentationDecorator extends RepresentationDecorator {

    public ShadedRepresentationDecorator(Representation representation) {
        super(representation);
    }

    @Override
    public void represent(){
        super.represent();
        System.out.println("(shaded)");
    }
}
