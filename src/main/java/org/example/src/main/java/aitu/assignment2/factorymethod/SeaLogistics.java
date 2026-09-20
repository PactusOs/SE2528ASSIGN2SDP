package org.example.src.main.java.aitu.assignment2.factorymethod;

public class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
