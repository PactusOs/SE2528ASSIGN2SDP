package org.example.src.main.java.aitu.assignment2;
import org.example.src.main.java.aitu.assignment2.abstractfactory.GUIFactory;
import org.example.src.main.java.aitu.assignment2.abstractfactory.MacOSFactory;
import org.example.src.main.java.aitu.assignment2.abstractfactory.WindowsFactory;
import aitu.assignment2.app.DeliveryApp;
import org.example.src.main.java.aitu.assignment2.factorymethod.Logistics;
import org.example.src.main.java.aitu.assignment2.factorymethod.RoadLogistics;
import org.example.src.main.java.aitu.assignment2.factorymethod.SeaLogistics;

import java.util.Scanner;

public class Main {
    private static final String CARGO="laboratory equipment";
    private static final String DESTINATION="Aktau warehouse";
    public static void main(String[] args){
        try {
            String[] choices=readChoices(args);
            validateChoices(choices[0], choices[1]);
            Logistics logistics = createLogistics(choices[0]);
            GUIFactory guiFactory = createGuiFactory(choices[1]);
            System.out.println("Delivery mode: "+choices[0]);
            System.out.println("UI platform: "+choices[1]);

            DeliveryApp application=new DeliveryApp(guiFactory, logistics);
            application.run(CARGO, DESTINATION);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static String[] readChoices(String[] args) {
        if (args.length == 2) {
            return new String[]{normalize(args[0]), normalize(args[1])};
        }
        if (args.length == 1 || args.length > 2) {
            throw new IllegalArgumentException("Missing or incorrect input. Provide both delivery mode and UI platform.");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter delivery mode (ROAD or SEA): ");
        if (!scanner.hasNextLine()) {
            throw new IllegalArgumentException("Missing input. Delivery mode and UI platform are required.");
        }
        String deliveryMode = normalize(scanner.nextLine());
        System.out.print("Enter UI platform (WINDOWS or MACOS): ");
        if (!scanner.hasNextLine()) {
            throw new IllegalArgumentException("Wrong input. UI platform is required.");
        }
        String platform = normalize(scanner.nextLine());
        return new String[]{deliveryMode, platform};
    }
    private static String normalize(String value) {
        return value.trim().toUpperCase();
    }
    private static void validateChoices(String deliveryMode, String platform) {
        if (!deliveryMode.equals("ROAD")&&!deliveryMode.equals("SEA")){
            throw new IllegalArgumentException("Wrong delivery mode: "+deliveryMode);
        }
        if (!platform.equals("WINDOWS")&&!platform.equals("MACOS")){
            throw new IllegalArgumentException("Wrong UI platform: "+platform);
        }
    }
    private static Logistics createLogistics(String deliveryMode) {
        return switch (deliveryMode) {
            case "ROAD" -> new RoadLogistics();
            case "SEA" -> new SeaLogistics();
            default -> throw new IllegalArgumentException("Unsupported delivery mode: " + deliveryMode);
        };
    }
    private static GUIFactory createGuiFactory(String platform) {
        return switch (platform) {
            case "WINDOWS" -> new WindowsFactory();
            case "MACOS" -> new MacOSFactory();
            default -> throw new IllegalArgumentException("Unsupported UI platform: " + platform);
        };
    }
}
