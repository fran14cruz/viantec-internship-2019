package rubin.ru.dao.enums;

public enum Standard {

    BGN("bgn"),
    A("a"),
    UNKNOWN("-");

    private final String standard;

    Standard(String standard) {
        this.standard = standard;
    }

    public String getName() {
        return standard;
    }
}
