package com.xuyao.utils;

import java.util.Random;

public class RandomUtils {

    private static Random random = new Random();

    /**
     * 随机int值
     * @return
     */
    public static int randomInt(){
        return random.nextInt();
    }

    /**
     * 范围内int值，0<=int<=max
     * @param max
     * @return
     */
    public static int randomInt(int max){
        return random.nextInt(max + 1);
    }

    /**
     * 范围内int值，0<=int<=max
     * @param max
     * @return
     */
    public static int randomInt1(int max){
        return (int) (Math.random() * max) + 1;
    }

    /**
     * 随机long值
     * @return
     */
    public static long randomLong(){
        return random.nextLong();
    }
}
