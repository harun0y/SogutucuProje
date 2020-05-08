package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KullaniciVeritabani {
    private static KullaniciVeritabani instance;

    private Connection baglan() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ders",
                    "postgres", "123456");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public Boolean kontrol(String isimGiris, String sifreGiris, int a) {

            String sql = "SELECT *  FROM \"odev\" WHERE \"kisiNo\"=" + a;
            String isim;
            String sifre;
            Boolean sonuc = false;
            Connection conn = this.baglan();
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                //***** Bağlantı sonlandırma *****
                conn.close();
                while(rs.next()) {
                    isim = rs.getString("isim");
                    sifre = rs.getString("sifre");
                    if (isimGiris.equals(isim) && sifreGiris.equals(sifre)) {
                        sonuc = true;
                    }
                    else{
                        sonuc = false;
                    }
                }
                rs.close();
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        return sonuc; 
    }
}