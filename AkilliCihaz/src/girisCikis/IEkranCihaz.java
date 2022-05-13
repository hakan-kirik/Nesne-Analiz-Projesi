package girisCikis;

import akilliCihazCevreBirim.IArayuz;
import veritabani.Kullanici;

public interface IEkranCihaz {

	void acilisMesajı();

	Kullanici kullaniciGirisEkrani(ITusTakimiCihaz tusTakimi);

	void kullaniciDogrulanmaMesaji(boolean dogrulandiMi);

	void kullaniciCıkısEkrani();

	int kullaniciSecenekleri(ITusTakimiCihaz tusTakimi);

	void sicaklikGoruntule(IArayuz arayuz);

}
