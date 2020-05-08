package com.company;

import java.security.PublicKey;

import static java.lang.Thread.sleep;

public class Sogutucu {

    private IEkran ekran;
    private IKlavye klavye;

    private static final String SOGUTUCU_AKTIFLIK = "1";
    private static final String SICAKLIK_GORUNTULE = "2";
    private static final String CIKIS = "3";

    public Sogutucu()
    {
        ekran = new Ekran();
        klavye = new Klavye();

    }

    public void Basla() throws InterruptedException {
        int x = 0;
        String ad ="";
        String sifre = "";
        ekran.mesajGoruntule("Lütfen Giris Yapiniz...");
        while(x != 3){
                ekran.mesajGoruntule("Kullanıcı Adı Giriniz: ");
                ad = klavye.veriAl();
                ekran.mesajGoruntule("Şifre Giriniz: ");
                sifre = klavye.veriAl();

                System.out.println("Giriş Yapılıyor...");
                Thread.sleep(1000);
                if (kullaniciDogrulama(ad,sifre))
                {
                    System.out.println("Giriş Başarılı!");
                    break;

                } else{
                    System.out.println("Hatalı Giriş, Tekrar Dene(3 yanlış girme hakkınız var!)");
                    x++;
                    if(x==3){
                        System.out.println("Hatalı giriş hakkınız bitti!");
                        System.exit(0);
                    }

                }
            }

            Kullanici kullanici = new Kullanici(ad);
            KullaniciHesabi kullaniciHesabi = new KullaniciHesabi(kullanici);


            if (kullaniciHesabi != null) {
                ekran.mesajGoruntule(kullaniciHesabi.toString());
                islemSecimi(kullaniciHesabi);

            } else {
                ekran.mesajGoruntule("doğrulanamadı");

            }
    }

    private void islemSecimi(KullaniciHesabi kullaniciHesabi) throws InterruptedException {
        Subscriber1 sub = new Subscriber1();
        Publisher pub = new Publisher();
        pub.attach(sub);
        String secim;
        Algilayici algilayici = new Algilayici();
        //IAlgilayici iAlgilayici = DusukSicaklik.getInstance();  //dusuk sıcaklık ölçer
        IAlgilayici iAlgilayici = YuksekSicaklik.getInstance();   //yuksek sıcaklık ölçer
        do{
            secim = anaMenuyuGoster();
            switch (secim) {
                case SOGUTUCU_AKTIFLIK:
                    ekran.mesajGoruntule("Eyleyici Kontrol Merkezi" + "\non(1)/off(0)\n");
                    IEyleyici eyleyici = new Eyleyici();
                    ekran.mesajGoruntule(eyleyici.Eyleme(klavye.veriAl()));
                    Thread.sleep(1000);
                    break;
                case SICAKLIK_GORUNTULE:
                    Thread.sleep(1000);
                    double sicaklikk = algilayici.getSicaklik(iAlgilayici);
                    sub.update("sicaklik " + sicaklikk + " olarak ölçüldü!");
                    //ekran.mesajGoruntule("Sıcaklık:" + sicaklikk);
                    break;
                case CIKIS:
                    ekran.mesajGoruntule("Çıkılıyor...");
                    Thread.sleep(1000);
                    System.exit(0);
                    break;
                default:
                    ekran.mesajGoruntule("1-3 arasında bir sayı girmelisiniz");
            }
        }while(secim!="3");
    }

    private String anaMenuyuGoster()
    {
        ekran.mesajGoruntule("******************************************");
        ekran.mesajGoruntule("Ana Menu");
        ekran.mesajGoruntule("1-Sogutucu Ac/Kapa");
        ekran.mesajGoruntule("2-Sıcaklık Oku");
        ekran.mesajGoruntule("3-Çıkış");
        ekran.mesajGoruntule("Seciminiz:");
        ekran.mesajGoruntule("******************************************");

        return klavye.veriAl();
    }

    private boolean kullaniciDogrulama(String ad, String sifre) {
        for (int i = 0; i<4; i++){
            KullaniciVeritabani data = new KullaniciVeritabani();
            if(data.kontrol(ad,sifre,i))
                return true;
        }
        return false;
    }
}
