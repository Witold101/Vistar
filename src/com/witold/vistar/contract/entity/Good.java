package com.witold.vistar.contract.entity;

import com.witold.vistar.contract.db.UmDB;
import com.witold.vistar.contract.localisationClass.LocalText;

/**
 * Класс описывает товар
 */

public class Good extends Entity {

    private LocalText name;
    private LocalText fullName;
    private Um um; //Единица измерения
    private String value;
    private String cost;
    private String vat;
    private String sum;
    private String cod;

    public Good() {
        super();
        this.name = new LocalText();
        this.fullName = new LocalText();
        this.um = new Um();
        this.value = "";
        this.cost = "";
        this.vat = "";
        this.sum = "";
        this.cod = "";
    }

    public Good(LocalText name, LocalText fullName, Um um, String value, String cost, String vat, String sum, String cod) {
        this.name = name;
        this.fullName = fullName;
        this.um = um;
        this.value = value;
        this.cost = cost;
        this.vat = vat;
        this.sum = sum;
        this.cod = cod;
    }

    public int getName() {
        return this.name.getId();
    }

    public String getName(int language) {
        return this.name.getLocalText(language);
    }

    public int getFullName() {
        return this.fullName.getId();
    }

    public String getFullName(int language) {
        return this.fullName.getLocalText(language);
    }

    public void setName(int language, String text) {
        this.name.setLocal(language, text);
    }

    public void setUm(Um um) {
        this.um = um;
    }

    public void setUmFromDB(String cod) {
        UmDB umDB = UmDB.getInstance();
        if (umDB.getElementFromCod(cod) != null) {
            this.um = umDB.getElementFromCod(cod);
        }
    }

    public Um getUm() {
        return um;
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

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + getId() +
                "Cod=" + getCod() +
                ", name='" + getName() + '\'' +
                ", nameFull='" + getFullName() + '\'' +
                ", um='" + getUm() + '\'' +
                ", value='" + getValue() + '\'' +
                ", cost='" + getCost() + '\'' +
                ", vat='" + getVat() + '\'' +
                ", summ='" + getSum() + '\'' +
                '}';
    }
}
