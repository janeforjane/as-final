package db;

import entity.CityInfo;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.ArrayList;
import java.util.List;

@Stateless
@LocalBean
@TransactionManagement(value= TransactionManagementType.BEAN)
public class DbManagerImpl implements DbManager {


    @PersistenceUnit(unitName = "input-message")
    private EntityManagerFactory entityManagerFactory; // need for db

    public void newString(CityInfo cityInfo) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();


        entityManager.getTransaction().begin();
        entityManager.persist(cityInfo);
        entityManager.getTransaction().commit();

        System.out.println("it's ok with dbManager_new");

    }

    public void removeString(String nameOfTheCity) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CityInfo cityInfo1 = entityManager.find(CityInfo.class, nameOfTheCity);

        if (cityInfo1 == null) {

            System.out.println("town is null");

        }else {

            entityManager.getTransaction().begin();
            entityManager.remove(cityInfo1);
            entityManager.getTransaction().commit();

            System.out.println("it's ok with dbManager_remove");
        }
    }

    public List<CityInfo> getList() {

        //TODO return list of CityInfos (not strings)
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        List cityInfoArrayList = entityManager.createQuery("from CityInfo ").getResultList();
        entityManager.getTransaction().commit();

        return cityInfoArrayList;
    }

    public CityInfo get(String nameOfTheCity) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CityInfo cityInfo1 = entityManager.find(CityInfo.class, nameOfTheCity);

        if (cityInfo1 != null) {
                  return cityInfo1;

        }else {
            System.out.println("City " + nameOfTheCity + " doesn`t exist");
            return null;
        }
    }
}


