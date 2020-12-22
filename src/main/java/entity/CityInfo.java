package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cityInfos", schema = "public")
public class CityInfo {


    @Column(name = "name")
    @Id
    private String name;

    @Column(name = "populationSize")
    private int populationSize;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityInfo cityInfo = (CityInfo) o;

        if (getPopulationSize() != cityInfo.getPopulationSize()) return false;
        return getName() != null ? getName().equals(cityInfo.getName()) : cityInfo.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getPopulationSize();
        return result;
    }
}
