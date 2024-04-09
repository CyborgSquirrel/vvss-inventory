package inventory.repository;

import inventory.model.OutsourcedPart;
import inventory.model.Part;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryTest {

    @Test
    @Timeout(10)
    @Disabled
    void addPart1_ECP() {
        InventoryRepository repo = new InventoryRepository();
        Part part = new OutsourcedPart(0, "Screwdrivah", 2012, 1, 1, 2, "asd");
        int prev_size = repo.getAllParts().size();
        repo.addPart(part);
        assert(repo.getAllParts().size() == prev_size + 1);
    }

    @Test
    @RepeatedTest(2)
    @Disabled
    void addPart2_ECP() {
        InventoryRepository repo = new InventoryRepository();
        Part part = new OutsourcedPart(0, "Bolt2", 20122, 12, 12, 32, "asd");
        int prev_size = repo.getAllParts().size();
        repo.addPart(part);
        assert(repo.getAllParts().size() == prev_size + 1);
    }

    @Test
    @DisplayName("test 3 ECP")
    @Disabled
    void addPart3_ECP() {
        InventoryRepository repo = new InventoryRepository();
        Part part = new OutsourcedPart(0, "", 2012, 1, 1, 2, "asd");
        String validation_message = Part.isValidPart(part.getName(), part.getPrice(), part.getInStock(), part.getMin(), part.getMax(), "");

        int prev_size = repo.getAllParts().size();
        if(validation_message.isEmpty()) {
            repo.addPart(part);
        }

        assert(repo.getAllParts().size() == prev_size + 1);
    }

    @Test
    @Disabled
    void addPart4_ECP() {
        InventoryRepository repo = new InventoryRepository();
        Object not_a_number = "";
        if(not_a_number.equals("")) {
            assert false;
        }
        not_a_number = 0;
        Part part = new OutsourcedPart(0, "Bolt2", 20122, (Integer)not_a_number, 12, 32, "asd");
        int prev_size = repo.getAllParts().size();
        repo.addPart(part);
        assert(repo.getAllParts().size() == prev_size + 1);
    }

    @Test
    @Timeout(10)
    @Tag("not_exec-able")
    @Disabled
    void addPart1_BVA() {
        InventoryRepository repo = new InventoryRepository();
        Part part = new OutsourcedPart(0, "", 2012, 1, 1, 2, "asd");
        int prev_size = repo.getAllParts().size();
        repo.addPart(part);
        assert(repo.getAllParts().size() == prev_size + 1);
    }

    @Test
    @Timeout(10)
    @Disabled
    void addPart2_BVA() {
        InventoryRepository repo = new InventoryRepository();
        Part part = new OutsourcedPart(0, "M", 20, 3, 10, 30, "asd");
        int prev_size = repo.getAllParts().size();
        repo.addPart(part);
        assert(repo.getAllParts().size() == prev_size + 1);
    }

    @Test
    @Timeout(10)
    @Tag("not_exec-able")
    @Disabled
    void addPart3_BVA() {
        InventoryRepository repo = new InventoryRepository();
        Part part = new OutsourcedPart(0, "Screwdrivah", 2012, 0, 1, 2, "asd");
        String validation_message = Part.isValidPart(part.getName(), part.getPrice(), part.getInStock(), part.getMin(), part.getMax(), "");

        int prev_size = repo.getAllParts().size();
        if(validation_message.isEmpty()) {
            repo.addPart(part);
        }
        assert(repo.getAllParts().size() == prev_size + 1);
    }

    @Test
    @Timeout(10)
    @Disabled
    void addPart4_BVA() {
        InventoryRepository repo = new InventoryRepository();
        Part part = new OutsourcedPart(0, "M", 49, 3, 10, 30, "asd");
        int prev_size = repo.getAllParts().size();
        repo.addPart(part);
        assert(repo.getAllParts().size() == prev_size + 1);
    }

    @Test
    void lookupPart_TC01(){
        String searchString = "Cucaracia";
        InventoryRepository repo = new InventoryRepository();
        Part part = repo.lookupPart(searchString);
        assert(part == null);
    }
    @Test
    void lookupPart_TC02(){
        String searchString = "ZIMBABUE";
        InventoryRepository repo = new InventoryRepository();
        Part part = repo.lookupPart(searchString);
        assert(part.getName().equals(searchString));
    }
    @Test
    void lookupPart_TC03(){
        String searchString = "1";
        InventoryRepository repo = new InventoryRepository();
        Part part = repo.lookupPart(searchString);
        assert(part.getPartId() == Integer.parseInt(searchString));
    }
    @Test
    void lookupPart_TC04(){
        String searchString = "gugu";
        String filename = "data/empty_items.txt";
        InventoryRepository repo = new InventoryRepository(filename);
        Part part = repo.lookupPart(searchString);
        assert(part == null);
    }
}
