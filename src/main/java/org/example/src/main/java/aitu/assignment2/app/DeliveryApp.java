package org.example.src.main.java.aitu.assignment2.app;
import org.example.src.main.java.aitu.assignment2.abstractfactory.Button;
import org.example.src.main.java.aitu.assignment2.abstractfactory.Checkbox;
import org.example.src.main.java.aitu.assignment2.abstractfactory.GUIFactory;
import org.example.src.main.java.aitu.assignment2.factorymethod.Logistics;
public class DeliveryApp {
    private final GUIFactory guiFactory;
    private final Logistics logistics;
    public DeliveryApp(GUIFactory guiFactory, Logistics logistics) {
        this.guiFactory = guiFactory;
        this.logistics = logistics;
    }
    public void run(String cargo, String destination) {
        Button button = guiFactory.createButton();
        Checkbox checkbox = guiFactory.createCheckbox();
        button.paint();
        checkbox.paint();
        logistics.planDelivery(cargo, destination);
    }
}
