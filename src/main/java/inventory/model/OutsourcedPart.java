
package inventory.model;


import java.util.Objects;

public class OutsourcedPart extends Part {
    
    // Declare fields
    private String companyName;

    // Constructor
    public OutsourcedPart(int partId, String name, double price, int inStock, int min, int max, String companyName) {
        super(partId, name, price, inStock, min, max);
        this.companyName = companyName;
    }
    
    // Getter
    public String getCompanyName() {
        return companyName;
    }
    
    // Setter
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "O,"+super.toString()+","+getCompanyName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OutsourcedPart that = (OutsourcedPart) o;
        return Objects.equals(companyName, that.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), companyName);
    }
}
