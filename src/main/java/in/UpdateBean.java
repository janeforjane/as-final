package in;

import entity.CityInfo;

public interface UpdateBean {

    void saveNew(String nameOfTheCity, int populationSize);

    void remove(String nameOfTheCity);
}
