package com.witold.vistar.contract.db;

import com.witold.vistar.contract.entity.Entity;
import com.witold.vistar.contract.entity.Good;
import com.witold.vistar.contract.entity.Um;

import java.util.ArrayList;
import java.util.List;

public class GoodDB implements DBManipulation {
    private int id; // ID для подстановки в элементы
    private List<Good> goods;
    private static GoodDB instance;

    private GoodDB() {
        this.goods = new ArrayList<>();
        this.id = 0;
    }

    public static synchronized GoodDB getInstance() {
        if (instance == null)
            synchronized (GoodDB.class) {
                if (instance == null) {
                    instance = new GoodDB();
                }
            }
        return instance;
    }
    
    
    @Override
    public void add(Entity element) {
        if (element instanceof Good) {
            Good good = (Good) element;
            good.setId(setNewDBId());
            this.goods.add(good);
        }        
    }

    @Override
    public void dell(Entity element) {
        if (element instanceof Good) {
            Good good = (Good) element;
            this.goods.remove(good);
        }
    }

    @Override
    public void dell(int idElementDB) {
        this.goods.remove(idElementDB);
    }

    @Override
    public Entity getElement(int idElement) {
        return this.goods.get(idElement);
    }

    @Override
    public void rewriteElement(Entity element) {
        if (element instanceof Good) {
            Good good = (Good) element;
            this.goods.set(good.getId(),good);
        }
    }

    @Override
    public int setNewDBId() {
        return this.id++;
    }

    @Override
    public boolean isElement(Entity element) {
        Good good=null;
        if (element instanceof Good) {
            good = (Good) element;
        }
        for (int i = 0; i < goods.size(); i++) {
            if (good.getCod() == goods.get(i).getCod()){
                return true;
            }
        }
        return false;
    }
}
