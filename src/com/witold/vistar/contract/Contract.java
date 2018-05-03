package com.witold.vistar.contract;

import java.util.ArrayList;
import java.util.List;

public class Contract {
    private String number;
    private String place;
    private String date;
    private String paymentType;
    private String priceNet;
    private String currency;
    private Contractor seller;
    private Contractor buyer;
    private List<Good> goods;

    public Contract(){
//        this.seller=new Contractor();
//        this.buyer=new Contractor();
//        this.goods = new ArrayList<>();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPriceNet() {
        return priceNet;
    }

    public void setPriceNet(String priceNet) {
        this.priceNet = priceNet;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Contractor getSeller() {
        return seller;
    }

    public void setSeller(Contractor seller) {
        this.seller = seller;
    }

    public Contractor getBuyer() {
        return buyer;
    }

    public void setBuyer(Contractor buyer) {
        this.buyer = buyer;
    }

    public List<Good> getGoods() {
        return goods;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "number='" + number + '\'' +
                ", place='" + place + '\'' +
                ", date='" + date + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", priceNet='" + priceNet + '\'' +
                ", currency='" + currency + '\'' +
                ", seller=" + seller.getFullName() +
                ", buyer=" + buyer.getFullName() + "}";
    }
}
