/**
 * Класс описывает единицы измерения товара
 */
package com.witold.vistar.contract.entity;

import com.witold.vistar.contract.localisationClass.LocalText;

public class Um extends Entity {

    private LocalText name;
    private LocalText fullName;
    private String cod; // Поле для записи сода (ID) который указан в БД при парсинге документов

    public Um() {
        super();
        this.name = new LocalText();
        this.fullName = new LocalText();
        this.cod = "";
    }

    public Um(LocalText name, LocalText fullName, String cod) {
        this.name = name;
        this.fullName = fullName;
        this.cod = cod;
    }

    public void setName(int language, String name) {
        this.name.setLocal(language,name);
    }

    public void setFullName(LocalText fullName) {
        this.fullName = fullName;
    }

    public void setFullName(int language, String fullName) {
        this.fullName.setLocal(language,fullName);
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getCod(){
        return this.cod;
    }
}
