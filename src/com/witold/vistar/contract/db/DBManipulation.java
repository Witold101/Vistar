/**
 * Абстрактный класс описывающий работу классов для сопряжения с базой данных
 */

package com.witold.vistar.contract.db;

import com.witold.vistar.contract.entity.Entity;

public interface DBManipulation {
    void add(Entity entity);

    void dell(Entity entity);

    void dell(int idElementDB);

    Entity getElement(int idElement);

    void rewriteElement(Entity elementDb);

    int setNewDBId();

    boolean isElement(Entity element);
}
