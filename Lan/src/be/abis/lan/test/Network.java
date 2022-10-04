package be.abis.lan.test;

import be.abis.lan.decorator.Representation;
import be.abis.lan.decorator.ShadedRepresentationDecorator;
import be.abis.lan.decorator.TextualRepresentationDecorator;
import be.abis.lan.enums.LanType;
import be.abis.lan.enums.PacketType;
import be.abis.lan.exception.DestinationNotFoundException;
import be.abis.lan.exception.NodeNotFoundException;
import be.abis.lan.facade.LanFacade;
import be.abis.lan.factory.LanFactory;
import be.abis.lan.factory.PacketFactory;
import be.abis.lan.model.*;

import java.util.List;

public class Network {
    public static void main(String[] args) {

        // set up network
        LanFactory lanFactory = LanFactory.createFactory(LanType.EXTENDED);
        LanFacade lanFacade = new LanFacade(lanFactory);
        List<Node> nodes= lanFacade.constructLan();

        // test decorators
        Representation node1 = nodes.get(0);

        Representation textualNode = new TextualRepresentationDecorator(node1);
        textualNode.represent();

        Representation textualShaded = new TextualRepresentationDecorator(new ShadedRepresentationDecorator(node1));
        textualShaded.represent();



        // create packet
        PacketFactory packetFactory= PacketFactory.createFactory(PacketType.SIMPLE);

        PacketComponent packet1 = packetFactory.createPacket("printserver2", "Java");
        PacketComponent packet2 = packetFactory.createPacket("fileserver1", "Patterns");
        PacketComponent packet3 = packetFactory.createPacket("mqserver1", "Document");
        PacketComponent packet4 = packetFactory.createPacket("tapestreamer1", "for");
        PacketComponent packet5 = packetFactory.createPacket("tapestreamefdr1", "beginners");


        PacketFactory superPacketFactory = PacketFactory.createFactory(PacketType.SUPERPACKET);
        PacketComponent superpacket = superPacketFactory.createPacket("printserver1", "Java Patterns Document For Beginners. lets try this");

        // send packet on its way
        WorkStation workStation1;
        try {
            workStation1 = lanFactory.findWorkStation(nodes, "workstation1");
            // workStation1.originate(packet1);
            // workStation1.originate(packet2);
            // workStation1.originate(packet3);
            // workStation1.originate(packet4);
            // workStation1.originate(packet5);

            workStation1.originate(superpacket);
        } catch (NodeNotFoundException | DestinationNotFoundException e) {
            System.out.println(e.getMessage());;
        }
    }
}
