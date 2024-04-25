package inventory.repository;

import inventory.model.OutsourcedPart;
import inventory.model.Part;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryTest {

    @Test
    @RepeatedTest(1)
    @Timeout(10)
    void addPart1_ECP() {
        InventoryRepository repo = new InventoryRepository();
        Part part = new OutsourcedPart(0, "Screwdrivah", 2012, 1, 1, 2, "asd");
        String validation_message = Part.isValidPart(part.getName(), part.getPrice(), part.getInStock(), part.getMin(), part.getMax(), "");
        int prev_size = repo.getAllParts().size();
        if(validation_message.isEmpty()) {
            repo.addPart(part);
        }
        assert(repo.getAllParts().size() == prev_size + 1);
    }

    @Test
    @RepeatedTest(2)
    void addPart2_ECP() {
        InventoryRepository repo = new InventoryRepository();
        Part part = new OutsourcedPart(0, "Bolt2", 20122, 12, 12, 32, "asd");
        String validation_message = Part.isValidPart(part.getName(), part.getPrice(), part.getInStock(), part.getMin(), part.getMax(), "");

        int prev_size = repo.getAllParts().size();
        if(validation_message.isEmpty()) {
            repo.addPart(part);
        }
        assert(repo.getAllParts().size() == prev_size + 1);
    }

    @Test
    @RepeatedTest(1)
    @DisplayName("test 3 ECP")
    void addPart3_ECP() {
        InventoryRepository repo = new InventoryRepository();
        Part part = new OutsourcedPart(0, "Screwdrivah", 20122, -8, 12, 32, "asd");
        String validation_message = Part.isValidPart(part.getName(), part.getPrice(), part.getInStock(), part.getMin(), part.getMax(), "");

        int prev_size = repo.getAllParts().size();
        if(validation_message.isEmpty()) {
            repo.addPart(part);
        }

        assert(repo.getAllParts().size() == prev_size);
    }

    @Test
    @RepeatedTest(1)
    void addPart4_ECP() {
        InventoryRepository repo = new InventoryRepository();
        Part part = new OutsourcedPart(0, "Bolt2", -3, 12, 12, 32, "asd");
        int prev_size = repo.getAllParts().size();

        String validation_message = Part.isValidPart(part.getName(), part.getPrice(), part.getInStock(), part.getMin(), part.getMax(), "");
        if(validation_message.isEmpty()) {
            repo.addPart(part);
        }
        assert(repo.getAllParts().size() == prev_size);
    }

    @Test
    @RepeatedTest(1)
    @Timeout(10)
    @Tag("not_exec-able")
    void addPart1_BVA() {
        InventoryRepository repo = new InventoryRepository();
        Part part = new OutsourcedPart(0, "", 2012, 1, 1, 2, "asd");
        int prev_size = repo.getAllParts().size();
        String validation_message = Part.isValidPart(part.getName(), part.getPrice(), part.getInStock(), part.getMin(), part.getMax(), "");

        if(validation_message.isEmpty()) {
            repo.addPart(part);
        }
        assert(repo.getAllParts().size() == prev_size);
    }

    @Test
    @RepeatedTest(1)
    @Timeout(10)
    void addPart2_BVA() {
        InventoryRepository repo = new InventoryRepository();
        Part part = new OutsourcedPart(0, "M", 20, 3, 10, 30, "asd");
        int prev_size = repo.getAllParts().size();
        repo.addPart(part);
        assert(repo.getAllParts().size() == prev_size + 1);
    }

    @Test
    @RepeatedTest(1)
    @Timeout(10)
    @Tag("not_exec-able")
    void addPart3_BVA() {
        InventoryRepository repo = new InventoryRepository();
        Part part = new OutsourcedPart(0, "Screwdrivah", 2012, 0, 1, 2, "asd");
        String validation_message = Part.isValidPart(part.getName(), part.getPrice(), part.getInStock(), part.getMin(), part.getMax(), "");

        int prev_size = repo.getAllParts().size();
        if(validation_message.isEmpty()) {
            repo.addPart(part);
        }
        assert(repo.getAllParts().size() == prev_size);
    }

    @Test
    @RepeatedTest(1)
    @Timeout(10)
    void addPart4_BVA() {
        InventoryRepository repo = new InventoryRepository();
        Part part = new OutsourcedPart(0, "M", 49, 3, 10, 30, "asd");
        int prev_size = repo.getAllParts().size();
        repo.addPart(part);
        assert(repo.getAllParts().size() == prev_size + 1);
    }

    @Test
    void lookupPart_TC01(){
        String searchItem = "Cucaracia";
        InventoryRepository repo = new InventoryRepository();
        Part part = repo.lookupPart(searchItem);
        assert(part == null);
    }
    @Test
    void lookupPart_TC02(){
        String searchItem = "ZIMBABUE";
        InventoryRepository repo = new InventoryRepository();
        Part part = repo.lookupPart(searchItem);
        assert(part.getName().equals(searchItem));
    }
    @Test
    void lookupPart_TC03(){
        String searchItem = "1";
        InventoryRepository repo = new InventoryRepository();
        Part part = repo.lookupPart(searchItem);
        assert(part.getPartId() == Integer.parseInt(searchItem));
    }
    @Test
    void lookupPart_TC04(){
        String searchItem = "gugu";
        String filename = "data/empty_items.txt";
        InventoryRepository repo = new InventoryRepository(filename);
        Part part = repo.lookupPart(searchItem);
        assert(part == null);
    }
}
