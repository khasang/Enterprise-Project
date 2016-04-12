package io.khasang.enterprise.model;

import javax.xml.bind.annotation.*;


@XmlRootElement(name = "region")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Region {

    @XmlElement(name = "id")
    private Integer regionId;

    @XmlElement(name = "name")
    private String regionName;

    @XmlElement
    private Integer population;

    public Region() {
    }

    public Region(Integer regionId, String regionName, Integer population) {
        this.regionId = regionId;
        this.regionName = regionName;
        this.population = population;
    }


    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}