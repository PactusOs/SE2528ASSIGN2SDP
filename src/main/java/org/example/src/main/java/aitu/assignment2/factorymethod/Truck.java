package org.example.src.main.java.aitu.assignment2.factorymethod;

public class Truck implements Transport {
    @Override
    public void deliver(String cargo, String destination) {
        System.out.println("Truck delivers"+cargo+" by road to "+destination);
    }
}
