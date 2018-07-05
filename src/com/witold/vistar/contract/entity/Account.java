package com.witold.vistar.contract.entity;

/**
 * Класс Entity описывающий счет и банк клиента
 */

public class Account extends Entity {
    private String account;
    private String swift;
    private String nameBank;
    private Address addressBank;
    private int idContractor;


    public Account() {
        super();
    }
}
