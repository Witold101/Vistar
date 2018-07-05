/**
 * Класс описывающий инвойс
 */

package com.witold.vistar.contract.entity;

import java.util.ArrayList;
import java.util.List;

public class Invoice extends Entity {
    private String number;
    private String date;
    private Contractor seller;
    private Contractor buyer;
    private List<Good> goods;

    public Invoice() {
        super();
        this.number="";
        this.date="";
        this.seller=new Contractor();
        this.buyer=new Contractor();
        this.goods=new ArrayList<>();
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSeller(Contractor seller) {
        this.seller = seller;
    }

    public void setBuyer(Contractor buyer) {
        this.buyer = buyer;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }

    public void addGood(Good good){
        goods.add(good);
    }
}
