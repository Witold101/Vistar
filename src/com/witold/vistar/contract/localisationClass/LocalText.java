package com.witold.vistar.contract.localisationClass;

import com.witold.vistar.contract.entity.Entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс хранит записи текста для использования в разных языковых вариантах.
 * В счетчике МАР устанавливаются следующие правила:
 * 1- Русский язык
 * 2- Английский язык
 * 3- Польский язык
 * В дальнейшем возможно добавления любого языка
 * ID записи должно генерится само
 */

public class LocalText extends Entity {
    private Map<Integer, String> local;

    public LocalText() {
        super();
        local = new HashMap<>();
    }

    public Map<Integer, String> getLocal() {
        return local;
    }

    public void setLocal(Map<Integer, String> local) {
        this.local = local;
    }

    public void setLocal(int language, String text){
        this.local.put(language,text);
    }

    public String getLocalText(int id){
        return local.get(id);
    }
}
