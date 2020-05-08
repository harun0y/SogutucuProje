package com.company;

public class Eyleyici implements IEyleyici {
    public String Eyleme(String giris) {
        switch (giris){
            case "1":
                return "Sogutucu Aciliyor...";
            case "0":
                return "Sogutucu Kapatiliyor...";
            default:
                return "hatali";
        }
    }
}
