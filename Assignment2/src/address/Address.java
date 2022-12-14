package address;

public class Address {
    protected String validFrom; // format for this will be something like "YYYY-MM-DD", same for validTo
    protected String validTo;

    public Address() {
        this("2023-01-01", "2024-01-01");
    }

    public Address(String validFrom, String validTo) {
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    public Address(Address other) {
        this(other.validFrom, other.validTo);
    }

    // GETTER
    public String getValidFrom() {
        return validFrom;
    }

    public String getValidTo() {
        return validTo;
    }

    // SETTER
    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public void setValidTo(String validTo) {
        this.validTo = validTo;
    }
}
