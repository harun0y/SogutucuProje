package com.company;

import java.util.Random;

public class DusukSicaklik implements IAlgilayici{
    private static DusukSicaklik instance;
    public static synchronized DusukSicaklik getInstance(){
        if(instance==null)
            instance = new DusukSicaklik();
        return instance;
    }
    @Override
    public double getSicaklik(Algilayici algilayici) {
        Random random = new Random();
        int a = random.nextInt(12)-23;
        if(a == -23)
            return a;
        return a;
    }
}
