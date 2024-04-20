package inventory.service;

import inventory.model.InhousePart;
import inventory.model.OutsourcedPart;
import inventory.model.Part;
import inventory.repository.InventoryRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InventoryServiceTest {

    @Test
    void getAllParts() {
        ArrayList<Part> partsList = new ArrayList<>();

        // Adding some parts with Indian-inspired names to the list
        partsList.add(new OutsourcedPart(1, "Masala Mixer", 499.99, 100, 20, 200, "Spices Emporium Pvt. Ltd."));
        partsList.add(new InhousePart(2, "Chai Kettle", 799.50, 50, 10, 100, 201));
        partsList.add(new OutsourcedPart(3, "Papad Press", 299.75, 200, 50, 500, "Crisp Creations Inc."));
        partsList.add(new InhousePart(4, "Samosa Maker", 599.99, 80, 15, 150, 202));
        partsList.add(new OutsourcedPart(5, "Roti Roller", 399.99, 120, 30, 300, "Flatbread Fabricators Pvt. Ltd."));

        InventoryRepository mock = Mockito.mock(InventoryRepository.class);
        Mockito.when(mock.getAllParts()).thenReturn(FXCollections.observableArrayList(partsList));

        InventoryService inventoryService = new InventoryService(mock);
        ObservableList<Part> allParts = inventoryService.getAllParts();

        assertEquals(partsList.size(), allParts.size());
        for (int i = 0; i < partsList.size(); ++i) {
            assertEquals(partsList.get(i), allParts.get(i));
        }
    }

    @Test
    void lookupPart() {
        ArrayList<Part> partsList = new ArrayList<>();

        OutsourcedPart thePart = new OutsourcedPart(3, "Apocalypse Cannon", 1945.75, 200, 50, 500, "Doomsday Arms Inc.");

        // Adding some parts with aggressive names
        partsList.add(new OutsourcedPart(1, "Warrior's Fury Engine", 1945.99, 100, 20, 200, "Battle Machines Pvt. Ltd."));
        partsList.add(new InhousePart(2, "Titanium Thunder Reactor", 1945.50, 50, 10, 100, 201));
        partsList.add(thePart);
        partsList.add(new InhousePart(4, "Raging Inferno Lathe", 1945.99, 80, 15, 150, 202));
        partsList.add(new OutsourcedPart(5, "Steel Storm Gearbox", 1945.99, 120, 30, 300, "Warforge Engineers Pvt. Ltd."));

        InventoryRepository mock = Mockito.mock(InventoryRepository.class);
        Mockito.when(mock.getAllParts()).thenReturn(FXCollections.observableArrayList(partsList));
        Mockito.when(mock.lookupPart("Apocal")).thenReturn(thePart);

        InventoryService inventoryService = new InventoryService(mock);
        assertEquals(thePart, inventoryService.lookupPart("Apocal"));
    }
}