package com.company;

import java.util.Random;

public class YuksekSicaklik implements IAlgilayici {
    private static YuksekSicaklik instance;
    public static synchronized YuksekSicaklik getInstance(){
        if(instance==null)
            instance = new YuksekSicaklik();
        return instance;
    }

    @Override
    public double getSicaklik(Algilayici algilayici) {
        Random random = new Random();
        return random.nextInt(12)+23;
    }
}
