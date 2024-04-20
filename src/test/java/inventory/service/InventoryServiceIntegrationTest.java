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

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InventoryServiceIntegrationTest {


    @Test
    void findAPartWithTheSameNameAsThisOne() {
        InventoryRepository inventoryRepository = new InventoryRepository("data/mokko.txt");
        InventoryService inventoryService = new InventoryService(inventoryRepository);
        inventoryService.addInhousePart("Legionnaire's Shield Generator", 499.99, 100, 20, 200, 101);

        InhousePart inhousePart = Mockito.spy(InhousePart.class);

        inventoryService.findAPartWithTheSameNameAsThisOne(inhousePart);
        Mockito.verify(inhousePart, Mockito.atLeastOnce()).getName();
    }

    @Test
    void findAPartWithTheSamePriceAsThisOne() {
        InventoryRepository inventoryRepository = new InventoryRepository("data/mokko.txt");
        InventoryService inventoryService = new InventoryService(inventoryRepository);
        inventoryService.addInhousePart("Legionnaire's Shield Generator", 499.99, 100, 20, 200, 101);

        InhousePart inhousePart = Mockito.spy(InhousePart.class);

        inventoryService.findAPartWithTheSamePriceAsThisOne(inhousePart);
        Mockito.verify(inhousePart, Mockito.atLeastOnce()).getPrice();
    }
    @Test
    void findAPartWithTheSameNameAsThisOneNotMock() {
        InventoryRepository inventoryRepository = new InventoryRepository("data/mokko.txt");
        InventoryService inventoryService = new InventoryService(inventoryRepository);
        inventoryService.addInhousePart("Legionnaire's Shield Generator", 499.99, 100, 20, 200, 101);

        InhousePart inhousePart = new InhousePart(0, "Legionnaire's Shield Generator", 499.99, 100, 20, 200, 101);

        Part aPartWithTheSameNameAsThisOne = inventoryService.findAPartWithTheSameNameAsThisOne(inhousePart);
        assertEquals(inhousePart.getName(), aPartWithTheSameNameAsThisOne.getName());
    }

    @Test
    void findAPartWithTheSamePriceAsThisOneNotMock() {
        InventoryRepository inventoryRepository = new InventoryRepository("data/mokko.txt");
        InventoryService inventoryService = new InventoryService(inventoryRepository);
        inventoryService.addInhousePart("Legionnaire's Shield Generator", 499.99, 100, 20, 200, 101);

        InhousePart inhousePart = new InhousePart(0, "Legionnaire's Shield Generator", 499.99, 100, 20, 200, 101);

        Part aPartWithTheSameNameAsThisOne = inventoryService.findAPartWithTheSamePriceAsThisOne(inhousePart);
        assertEquals(inhousePart.getPrice(), aPartWithTheSameNameAsThisOne.getPrice());
    }
}