package db;

import entity.CityInfo;

import java.util.ArrayList;
import java.util.List;

public interface DbManager {

    void newString(CityInfo cityInfo);
    void removeString(String nameOfTheCity);
    List<CityInfo> getList ();
    CityInfo get(String nameOfTheCity);


}
