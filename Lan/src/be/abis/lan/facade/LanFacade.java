package be.abis.lan.facade;

import be.abis.lan.factory.LanFactory;
import be.abis.lan.model.Node;

import java.util.List;

public class LanFacade {
    private LanFactory lanFactory;

    public LanFacade(LanFactory lanFactory) {
        this.lanFactory = lanFactory;
    }

    public List<Node> constructLan(){
        List<Node> nodes = this.lanFactory.createNodes();
        this.lanFactory.linkListeners(nodes);
        this.lanFactory.createLan(nodes);
        return nodes;
    }
}
