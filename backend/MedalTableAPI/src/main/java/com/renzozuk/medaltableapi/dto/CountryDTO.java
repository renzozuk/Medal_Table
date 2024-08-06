package com.renzozuk.medaltableapi.dto;

import java.util.Objects;

public class CountryDTO {
    private String id;
    private String name;
    private String photoPath;
    private Integer goldMedals;
    private Integer silverMedals;
    private Integer bronzeMedals;

    public CountryDTO() {
    }

    public CountryDTO(String id, String name, String photoPath, Integer goldMedals, Integer silverMedals, Integer bronzeMedals) {
        this.id = id;
        this.name = name;
        this.photoPath = photoPath;
        this.goldMedals = goldMedals;
        this.silverMedals = silverMedals;
        this.bronzeMedals = bronzeMedals;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Integer getGoldMedals() {
        return goldMedals;
    }

    public void setGoldMedals(Integer goldMedals) {
        this.goldMedals = goldMedals;
    }

    public Integer getSilverMedals() {
        return silverMedals;
    }

    public void setSilverMedals(Integer silverMedals) {
        this.silverMedals = silverMedals;
    }

    public Integer getBronzeMedals() {
        return bronzeMedals;
    }

    public void setBronzeMedals(Integer bronzeMedals) {
        this.bronzeMedals = bronzeMedals;
    }

    public int getAllMedals() {
        return this.goldMedals + this.silverMedals + this.bronzeMedals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryDTO that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "CountryDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", goldMedals=" + goldMedals +
                ", silverMedals=" + silverMedals +
                ", bronzeMedals=" + bronzeMedals +
                '}';
    }
}
