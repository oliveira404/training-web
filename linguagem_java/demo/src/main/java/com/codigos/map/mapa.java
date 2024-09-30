package com.codigos.map;

import java.util.HashMap;

public class mapa {
    public static void main(String[] args) {
        
        var medias = new HashMap<String, Double>();
        medias.put("Carlos", 10.0);
        medias.put("Bruno", 7.0);
        medias.put("Alice", 5.0);

        System.out.println(medias);
        System.out.println(medias.get("Alice"));
    }
}
