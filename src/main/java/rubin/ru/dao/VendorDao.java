package rubin.ru.dao;

import rubin.ru.model.Vendor;

public interface VendorDao {

    void update(Vendor vendor);

    Long getVendorIdByMac(String mac);

}
