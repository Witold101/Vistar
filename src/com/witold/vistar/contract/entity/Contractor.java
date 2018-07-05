package com.witold.vistar.contract.entity;

/**
 * Класс описывает данные сторон в сделке
 */

public class Contractor extends Entity {
    private String name;
    private String fullName;
    private String address;
    private String addressPostCode;
    private String addressesCity;
    private String addressesCountry;
    private String phone;
    private String account;
    private String bank;
    private String vat;
    private String employee;

    public Contractor() {
        super();
        this.name = "";
        this.fullName = "";
        this.address = "";
        this.addressPostCode = "";
        this.addressesCity = "";
        this.addressesCountry = "";
        this.phone = "";
        this.account = "";
        this.bank = "";
        this.vat = "";
        this.employee = "";

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getAccount() {
        return account;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getAddressPostCode() {
        return addressPostCode;
    }

    public void setAddressPostCode(String addressPostCode) {
        this.addressPostCode = addressPostCode;
    }

    public String getAddressesCity() {
        return addressesCity;
    }

    public void setAddressesCity(String addressesCity) {
        this.addressesCity = addressesCity;
    }

    public String getAddressesCountry() {
        return addressesCountry;
    }

    public void setAddressesCountry(String addressesCountry) {
        this.addressesCountry = addressesCountry;
    }

    @Override
    public String toString() {
        return "Contractor{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", account=" + account +
                ", employee=" + employee +
                '}';
    }
}
