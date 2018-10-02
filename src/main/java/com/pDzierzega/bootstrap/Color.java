package com.pDzierzega.bootstrap;


import java.util.*;

public enum Color {
    RED,
    GREEN,
    YELLOW,
    PURPLE,
    BLUE;

    public static final int[] move={1,2};

    public static Color getRandom(){
        List<Color> list= Arrays.asList(Color.values());
        Collections.shuffle(list);
        return list.get(0);
    }
}
