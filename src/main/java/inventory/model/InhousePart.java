package inventory.model;


import java.util.Objects;

public class InhousePart extends Part {

    // Declare fields
    private int machineId;

    public InhousePart() {

    }

    // Constructor
    public InhousePart(int partId, String name, double price, int inStock, int min, int max, int machineId) {
        super(partId, name, price, inStock, min, max);
        this.machineId = machineId;
    }
    
    // Getter
    public int getMachineId() {
        return machineId;
    }
    
    // Setter
    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    @Override
    public String toString() {
        return "I,"+super.toString()+","+getMachineId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        InhousePart that = (InhousePart) o;
        return machineId == that.machineId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), machineId);
    }
}


