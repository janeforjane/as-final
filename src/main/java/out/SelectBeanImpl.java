package out;

import entity.CityInfo;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
@LocalBean
public class SelectBeanImpl implements  SelectBean{

    @EJB
    db.DbManagerImpl dbManager;


    public CityInfo getItem(String someString) {

        return dbManager.get(someString);

    }

    public ArrayList<String> getList() {


        List cityInfoArrayList =  dbManager.getList();
        ArrayList<String> stringArrayList = new ArrayList<>();

        for (int i= 0; i < cityInfoArrayList.size() ; i++) {

            CityInfo cityInfo = (CityInfo) cityInfoArrayList.get(i);
            String s1 = cityInfo.getName();
            String s2 = String.valueOf(cityInfo.getPopulationSize());
            String resultString = s1 + " " + s2;

            stringArrayList.add(resultString);

        }
        return stringArrayList;
    }

    public ArrayList<String> getFilterList(String someString) {

        List cityInfoArrayList =  dbManager.getList();
        ArrayList<String> stringArrayList = new ArrayList<>();

        for (int i= 0; i < cityInfoArrayList.size() ; i++) {

            CityInfo cityInfo = (CityInfo) cityInfoArrayList.get(i);
            String s1 = cityInfo.getName();

            if (s1.contains(someString)) {
                String s2 = String.valueOf(cityInfo.getPopulationSize());
                String resultString = s1 + " " + s2;

                stringArrayList.add(resultString);
            }
        }
        return stringArrayList;
    }
}
