package be.abis.lan.factory;

import be.abis.lan.model.Packet;
import be.abis.lan.model.PacketComponent;
import be.abis.lan.model.Superpacket;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SuperpacketFactory extends PacketFactory {

    private static SuperpacketFactory superpacketFactory;

    public SuperpacketFactory() {
    }

    @Override
    public PacketComponent createPacket(String destinationAddress, String contents) {

        List<PacketComponent> subPackets = new ArrayList<>();


        String regexSplitSentence = "(?<=[.,?!]\\s)";
        Pattern p = Pattern.compile(regexSplitSentence);
        String[] subSentences = p.split(contents);
        if (subSentences.length > 1) {
            for (String sentence : subSentences){
                System.out.println("Superpacket/ " + sentence);
                List<PacketComponent> listOfPackets = splitSentenceIntoListOfPackets(destinationAddress, sentence);
                subPackets.add(new Superpacket(destinationAddress, listOfPackets));
            }
        } else {
            subPackets = splitSentenceIntoListOfPackets(destinationAddress, contents);
        }

        return new Superpacket(destinationAddress, subPackets);
    }

    private List<PacketComponent> splitSentenceIntoListOfPackets(String destinationAddress, String sentence){
        String[] subStrings = sentence.split(" ");
        List<PacketComponent> packetComponents = new ArrayList<>();

        for(String s: subStrings){
            System.out.println("Packet/ " + s);
            if (!s.equals("")) packetComponents.add(new Packet(destinationAddress, s));
        }
        return packetComponents;
    }

    public static SuperpacketFactory getInstance(){
        if (superpacketFactory==null) superpacketFactory = new SuperpacketFactory();
        return superpacketFactory;
    }
}
