package inventory.repository;

import inventory.model.InhousePart;
import inventory.model.OutsourcedPart;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryTestMock {
    @Test
    void mockOutsourcedPart() throws IOException {
        String fileName = "data/mosqito.txt";
        String toString = "alpaca SRL";

        OutsourcedPart moque = Mockito.mock(OutsourcedPart.class);
        Mockito.when(moque.toString()).thenReturn(toString);

        InventoryRepository repo = new InventoryRepository(fileName);
        repo.addPart(moque);

        String result = new String(Files.readAllBytes(Path.of(fileName)), StandardCharsets.UTF_8);
        assertEquals(toString, result.trim());
    }

    @Test
    void mockInhousePart() throws IOException {
        String fileName = "data/mosqito.txt";
        String toString = "mosquisos";

        InhousePart moque = Mockito.mock(InhousePart.class);
        Mockito.when(moque.toString()).thenReturn(toString);

        InventoryRepository repo = new InventoryRepository(fileName);
        repo.addPart(moque);

        String result = new String(Files.readAllBytes(Path.of(fileName)), StandardCharsets.UTF_8);
        assertEquals(toString, result.trim());
    }
}