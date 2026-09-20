package org.example.src.main.java.aitu.assignment2.factorymethod;

public class Ship implements Transport{
    @Override
    public void deliver(String cargo, String destination){
        System.out.println("Ship delivers "+cargo+" by sea to "+destination);
    }
}
