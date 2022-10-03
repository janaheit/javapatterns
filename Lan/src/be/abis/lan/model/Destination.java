package be.abis.lan.model;

public interface Destination {

    void addDestinationListener(DestinationListener destListener);
    void removeDestinationListener(DestinationListener destListener);

}
