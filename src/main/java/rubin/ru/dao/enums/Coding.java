package rubin.ru.dao.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Coding {
    OPN("OPN"),
    WPA2("WPA2"),
    WPA2WPA("WPA2WPA"),
    @JsonProperty("-")
    UNKNOWN("-");

    private final String coding;

    Coding(String s) {
        this.coding = s;
    }

    public static Coding setCoding(String coding) {
        for (Coding c : Coding.values()) {
            if (c.coding.equals(coding)) {
                return c;
            }
        }
        return Coding.UNKNOWN;
    }
}
