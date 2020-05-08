package com.company;

public class KullaniciHesabi
{
	private Kullanici kullanici;

	public Kullanici getKullanici() {
		return kullanici;
	}

	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
	}

	public KullaniciHesabi(Kullanici kullanici)
	{
		this.kullanici = kullanici;
	}

	@Override
	public String toString() {
		return "KullaniciHesabi{" + " adi: "+ kullanici.getAd()+

				'}';
	}
}
