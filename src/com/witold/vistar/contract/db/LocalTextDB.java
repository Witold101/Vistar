/**
 * Класс описывающий ДБ текста для локализации
 */

package com.witold.vistar.contract.db;

import com.witold.vistar.contract.entity.Entity;
import com.witold.vistar.contract.localisationClass.LocalText;

import java.util.ArrayList;
import java.util.List;

public class LocalTextDB implements DBManipulation {
    private int id; // ID для подстановки в элементы
    List<Entity> localTextList;
    private static LocalTextDB instance;

    private LocalTextDB() {
        this.localTextList = new ArrayList<>();
        this.id = 0;
    }

    public static synchronized LocalTextDB getInstance() {
        if (instance == null)
            synchronized (LocalTextDB.class) {
                if (instance == null) {
                    instance = new LocalTextDB();
                }
            }
        return instance;
    }

    @Override
    public void add(Entity entity) {
        if (entity instanceof LocalText) {
            LocalText localText = (LocalText) entity;
            localText.setId(setNewDBId());
            this.localTextList.add(localText);
        }
    }

    @Override
    public void dell(Entity entity) {
        if (entity instanceof LocalText) {
            LocalText localText = (LocalText) entity;
            this.localTextList.remove(localText);
        }
    }

    @Override
    public void dell(int idElement) {
        this.localTextList.remove(idElement);
    }

    @Override
    public Entity getElement(int idElement) {
        return this.localTextList.get(idElement);
    }

    @Override
    public void rewriteElement(Entity elementDb) {
        this.localTextList.set(elementDb.getId(), elementDb);
    }

    @Override
    public synchronized int setNewDBId() {
        this.id++;
        return this.id;
    }

    @Override
    public boolean isElement(Entity element) {
        LocalText localText = null;
        if (element instanceof LocalText) {
            localText = (LocalText) element;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.localTextList.contains(localText);
    }
}
