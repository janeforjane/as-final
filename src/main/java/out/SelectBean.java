package out;

import entity.CityInfo;

import java.util.ArrayList;

public interface SelectBean {

    CityInfo getItem(String nameOfTheCity);

    ArrayList<String> getList ();

    ArrayList<String> getFilterList (String someString);


}
