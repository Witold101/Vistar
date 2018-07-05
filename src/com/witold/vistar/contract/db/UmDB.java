/**
 * Класс для хранения данных о единице измерения
 */

package com.witold.vistar.contract.db;

import com.witold.vistar.contract.entity.Entity;
import com.witold.vistar.contract.entity.Um;

import java.util.ArrayList;
import java.util.List;

public class UmDB implements DBManipulation {
    private int id; // ID для подстановки в элементы
    private List<Um> ums;
    private static UmDB instance;

    private UmDB() {
        this.ums = new ArrayList<>();
        this.id = 0;
    }

    public static synchronized UmDB getInstance() {
        if (instance == null)
            synchronized (UmDB.class) {
                if (instance == null) {
                    instance = new UmDB();
                }
            }
        return instance;
    }

    public void add(Entity entity) {
        if (entity instanceof Um) {
            Um um = (Um) entity;
            um.setId(setNewDBId());
            this.ums.add(um);
        }
    }


    @Override
    public void dell(Entity entity) {
        if (entity instanceof Um) {
            Um um = (Um) entity;
            ums.remove(um);
        }
    }

    @Override
    public void dell(int entityId) {
        ums.remove(entityId);
    }

    @Override
    public Entity getElement(int idElement) {
        return ums.get(idElement);
    }

    public Um getElementFromCod(String cod) {
        for (int i = 0; i < ums.size(); i++) {
            if (ums.get(i).getCod().equals(cod)){
                return ums.get(i);
            }
        }
        return null;
    }

    @Override
    public void rewriteElement(Entity entity) {
        if (entity instanceof Um) {
            Um um = (Um) entity;
            ums.set(um.getId(),um);
        }
    }

    @Override
    public synchronized int setNewDBId() {
        this.id++;
        return this.id;
    }

    @Override
    public boolean isElement(Entity element) {
        Um um = null;
        if (element instanceof Um) {
            um = (Um) element;
        }
        for (int i = 0; i < ums.size(); i++) {
            if (ums.get(i).getCod().equals(um.getCod())){
                return true;
            }
        }
        return false;
    }
}
