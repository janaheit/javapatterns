package be.abis.lan.factory;

import be.abis.lan.model.*;

import java.util.ArrayList;
import java.util.List;

public class ExtendedLanFactory extends LanFactory {
    private static ExtendedLanFactory extendedLanFactory;

    private ExtendedLanFactory() {
    }

    public static ExtendedLanFactory getInstance(){
        if (extendedLanFactory==null) extendedLanFactory = new ExtendedLanFactory();
        return extendedLanFactory;
    }

    @Override
    public List<Node> createNodes() {
        Node workStation = new WorkStation("workstation1");
        Node node1 = new Node("node1");
        Node printServer1 = new PrintServer("printserver1", new ThreeD());
        Node node2 = new Node("node2");
        Node printServer2 = new PrintServer("printserver2", new InkJet());
        Node node3 = new Node("node3");
        Node fileServer1 = new FileServer("fileserver1");
        Node node4 = new Node("node4");
        Node node5 = new Node("node5");
        Node mqServer1 = new MQServer("mqserver1");
        Node node6 = new Node("node6");
        Node tapeStreamer = new TapeStreamAdapter(new TapeStreamer("tapestreamer1"));

        List<Node> nodes = new ArrayList<>();

        nodes.add(workStation);
        nodes.add(node1);
        nodes.add(printServer1);
        nodes.add(node2);
        nodes.add(printServer2);
        nodes.add(node3);
        nodes.add(fileServer1);
        nodes.add(node4);
        nodes.add(node5);
        nodes.add(mqServer1);
        nodes.add(node6);
        nodes.add(tapeStreamer);

        return nodes ;
    }


}
