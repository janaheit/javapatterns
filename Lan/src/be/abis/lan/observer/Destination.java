package be.abis.lan.observer;

public interface Destination {

    void addDestinationListener(DestinationListener destListener);
    void removeDestinationListener(DestinationListener destListener);

}
