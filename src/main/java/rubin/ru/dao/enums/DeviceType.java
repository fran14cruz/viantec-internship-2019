package rubin.ru.dao.enums;

public enum DeviceType {
    BS("BS"),
    CL("CL");

    private String name;

    DeviceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;

    }

}
