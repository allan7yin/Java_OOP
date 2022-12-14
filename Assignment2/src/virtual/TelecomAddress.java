package virtual;

import address.Address;

public class TelecomAddress extends Address {
    private String completeNumber;
    private int IDD;
    private int NDD;
    private int areaCode;
    private int number;
    private int extension;
    private String type;

    public TelecomAddress(int IDD, int NDD, int areaCode, int number, int extension, String type, String validFrom, String validTo) {
        super(validFrom, validTo);
        this.IDD = IDD;
        this.NDD = NDD;
        this.areaCode = areaCode;
        this.number = number;
        this.extension = extension;
        this.type = type;
        this.completeNumber = "+" + IDD + " (" + NDD + ")" + areaCode + " " + number + " ext. " + extension + " " + type;
    }

    public TelecomAddress() {
        this(1, 0, 647, 2080565, 777, "mobile", "2003-01-07", "2023-05-01");
    }

    public TelecomAddress(TelecomAddress other) {
        this(other.IDD, other.NDD, other.areaCode, other.number, other.extension, other.type, other.validFrom, other.validTo);
    }

    @Override
    public String toString() {
        return "The number " + completeNumber + " is valid from " + validFrom + " to " + validTo;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (!(other instanceof TelecomAddress)) {
            return false;
        }

        TelecomAddress temp = (TelecomAddress) other;
        if (completeNumber == temp.completeNumber) {
            return true;
        } else {
            return false;
        }
    }

    // GETTERS
    public String getCompleteNumber() {
        return completeNumber;
    }

    public int getIDD() {
        return IDD;
    }

    public int getNDD() {
        return NDD;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public int getNumber() {
        return number;
    }

    public int getExtension() {
        return extension;
    }

    public String getType() {
        return type;
    }

    public void setIDD(int IDD) {
        this.IDD = IDD;
    }

    public void setNDD(int NDD) {
        this.NDD = NDD;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    public void setType(String type) {
        this.type = type;
    }
}
