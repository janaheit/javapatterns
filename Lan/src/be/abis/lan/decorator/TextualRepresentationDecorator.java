package be.abis.lan.decorator;

import be.abis.lan.model.Node;

public class TextualRepresentationDecorator extends RepresentationDecorator {

    public TextualRepresentationDecorator(Representation representation) {
        super(representation);
    }

    @Override
    public void represent(){
        super.represent();
        Representation representation = getRepresentation();

        while (representation instanceof RepresentationDecorator){
            representation=((RepresentationDecorator) representation).getRepresentation();
        }

        if (representation instanceof Node){
            System.out.println("(" + ((Node)representation).getClass().getSimpleName() + ")");
        }

    }
}
