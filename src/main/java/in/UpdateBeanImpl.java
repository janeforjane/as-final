package in;

import db.DbManager;
import db.DbManagerImpl;
import entity.CityInfo;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class UpdateBeanImpl implements UpdateBean {

    @EJB
    db.DbManagerImpl dbManager;



    public void saveNew(String nameOfTheCity, int populationSize) {
        //TODO check string and int
        //TODO object CityInfo

        String s = nameOfTheCity.trim();
        int stringSize = s.length();


        if (stringSize >0 && stringSize <256) {
            CityInfo cityInfo = new CityInfo();
            cityInfo.setName(s);
            cityInfo.setPopulationSize(populationSize);

            dbManager.newString(cityInfo);

        } else {

            System.out.println("данные так-себе");
        }


    }

    public void remove(String nameOfTheCity) {
        //TODO check string and int
        //TODO object CityInfo

        String s = nameOfTheCity.trim();
        int stringSize = s.length();


        if (stringSize >0 && stringSize <256) {
            CityInfo cityInfo = new CityInfo();
            cityInfo.setName(s);
            cityInfo.setPopulationSize(3);

            dbManager.removeString(nameOfTheCity);

        } else {

            System.out.println("данные так-себе");
        }

    }
}
