package com.teachmeskills;

import org.apache.commons.collections4.map.Flat3Map;
import org.apache.commons.lang.text.CompositeFormat;

public class Main {
    public static void main(String[] args) {
        Flat3Map<Integer,String> flat3Map = new Flat3Map<>();
        flat3Map.put(1,"hello");
        flat3Map.put(2,"world");
        System.out.println(flat3Map);

    }
}