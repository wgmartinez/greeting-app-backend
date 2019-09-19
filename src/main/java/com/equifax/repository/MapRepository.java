package com.equifax.repository;

import java.util.HashMap;
import java.util.Map;

public class MapRepository {

    static Map<String, String> repo = new HashMap<>();
    static {
        repo.put("EN", "Hello");
        repo.put("ES", "Hola");
        repo.put("FR", "Bonjour");
        repo.put("IND", "Namaste");
        repo.put("PH", "Kumusta");
        repo.put("ITA", "Ciao");
        repo.put("MAN", "Ni hao");
        repo.put("KOR", "Yeoboseyo");
    }

}
