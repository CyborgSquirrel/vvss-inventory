package inventory.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutsourcedPartTest {

    @Test
    void getCompanyName() {
        OutsourcedPart outsourcedPart = new OutsourcedPart(1,
                "n-ai carte n-ai parte",
                10.1,
                64,
                1,
                100,
                "conor roi");
        assertEquals("conor roi", outsourcedPart.getCompanyName());
    }

    @Test
    void setCompanyName() {
        OutsourcedPart outsourcedPart = new OutsourcedPart(1,
                "n-ai carte n-ai parte",
                10.1,
                64,
                1,
                100,
                "conor roi");
        outsourcedPart.setCompanyName("ubebe");
        assertEquals("ubebe", outsourcedPart.getCompanyName());
    }
}