package com.witold.vistar.contract;

public class Good {

    private int id;
    private String name;
    private String nameRus;
    private String namePl;
    private String um; //Единица измерения
    private String value;
    private String cost;
    private String vat;
    private String summ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUm() {
        return um;
    }

    public void setUm(String um) {
        this.um = um;
    }

    public String getNameRus() {
        return nameRus;
    }

    public void setNameRus(String nameRus) {
        this.nameRus = nameRus;
    }

    public String getNamePl() {
        return namePl;
    }

    public void setNamePl(String namePl) {
        this.namePl = namePl;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getSumm() {
        return summ;
    }

    public void setSumm(String summ) {
        this.summ = summ;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameRus='" + nameRus + '\'' +
                ", namePl='" + namePl + '\'' +
                ", um='" + um + '\'' +
                ", value='" + value + '\'' +
                ", cost='" + cost + '\'' +
                ", vat='" + vat + '\'' +
                ", summ='" + summ + '\'' +
                '}';
    }
}
