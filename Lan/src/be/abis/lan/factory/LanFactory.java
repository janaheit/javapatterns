package be.abis.lan.factory;

import be.abis.lan.enums.LanType;
import be.abis.lan.exception.NodeNotFoundException;
import be.abis.lan.model.Node;
import be.abis.lan.model.PacketHandler;
import be.abis.lan.model.WorkStation;

import java.util.ArrayList;
import java.util.List;

public abstract class LanFactory {

    public static LanFactory createFactory(LanType lanType){
        switch (lanType){
            default:
            case SIMPLE:
                return SimpleLanFactory.getInstance();
            case EXTENDED:
                return ExtendedLanFactory.getInstance();
        }
    }

    public abstract List<Node> createNodes();

    public void createLan(List<Node> nodes){
        int len = nodes.size();

        // link to the nextComponent
        for(int x=0; x<len-1; x++){
            nodes.get(x).setNextComponent(nodes.get(x+1));
        }

        // link last one to first one
        nodes.get(len-1).setNextComponent(nodes.get(0));
    }

    public void linkListeners(List<Node> nodes){
        List<WorkStation> workStations = new ArrayList<>();
        for (Node n:nodes){
            if (n instanceof WorkStation) workStations.add((WorkStation) n);
        }

        for (Node node: nodes){
            if (node instanceof PacketHandler) {
                for(WorkStation ws: workStations){
                    ((PacketHandler)node).addDestinationListener(ws);
                }
            }
        }
    }


    public WorkStation findWorkStation(List<Node> nodes, String address) throws NodeNotFoundException {
        for (Node n: nodes){
            if (n instanceof WorkStation && n.getAddress().equals(address)) return (WorkStation) n;
        }
        throw new NodeNotFoundException("Workstation not found.");
    }

}
