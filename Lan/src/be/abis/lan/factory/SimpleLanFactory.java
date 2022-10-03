package be.abis.lan.factory;

import be.abis.lan.model.*;

import java.util.ArrayList;
import java.util.List;

public class SimpleLanFactory extends LanFactory {
    private static SimpleLanFactory simpleLanFactory;

    private SimpleLanFactory() {


    }

    public static SimpleLanFactory getInstance(){
        if (simpleLanFactory==null) simpleLanFactory = new SimpleLanFactory();
        return simpleLanFactory;
    }

    @Override
    public List<Node> createNodes() {
        Node workStation = new WorkStation("workstation1");
        Node node1 = new Node("node1");
        Node printServer1 = new PrintServer("printserver1", new ThreeD());
        Node node2 = new Node("node2");
        Node printServer2 = new PrintServer("printserver2", new InkJet());

        List<Node> nodes = new ArrayList<>();

        nodes.add(workStation);
        nodes.add(node1);
        nodes.add(printServer1);
        nodes.add(node2);
        nodes.add(printServer2);

        return nodes ;
    }

}
