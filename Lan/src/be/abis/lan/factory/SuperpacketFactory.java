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
        PacketComponent pc = new Superpacket(destinationAddress);

        String[] subSentences = splitSentences(contents);
        System.out.println("This will contain "+ subSentences.length + " superpacket(s).");
        for(String sentence: subSentences){
            PacketComponent superpacket = new Superpacket(destinationAddress);
            String[] words = splitSentence(sentence);
            System.out.println("This will contain " + words.length + " packet(s).");
            for (String word: words){
                PacketComponent packet = new Packet(destinationAddress, word.trim());
                ((Superpacket)superpacket).addPacketComponent(packet);
            }
            ((Superpacket)pc).addPacketComponent(superpacket);
        }

        return pc;
    }

    private String[] splitSentences(String contents){
        String regexSplitSentence = "(?<=[.,?!]\\s)";
        Pattern p = Pattern.compile(regexSplitSentence);
        String[] subSentences = p.split(contents);
        return subSentences;
    }

    private String[] splitSentence(String contents){
        return contents.split(" ");
    }

    private List<PacketComponent> splitSentenceIntoListOfPackets(String destinationAddress, String sentence){
        String[] subStrings = splitSentence(sentence);
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
