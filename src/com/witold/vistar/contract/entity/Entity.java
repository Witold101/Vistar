package com.witold.vistar.contract.entity;

/**
 * Супер класс для всех Entity
 */

public class Entity {
    private int id;

    public Entity() {
        this.id = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
