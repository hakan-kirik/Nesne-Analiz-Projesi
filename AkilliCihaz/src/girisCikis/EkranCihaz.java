package girisCikis;

import akilliCihazCevreBirim.IArayuz;

import veritabani.Kullanici;

public class EkranCihaz implements IEkranCihaz {
	@Override
    public void acilisMesajı() {
        System.out.println("Akıllı soğutucuya baglanıldı");
        System.out.println("-----------------------------\n");
    }

    @Override
    public Kullanici kullaniciGirisEkrani(ITusTakimiCihaz tusTakimi) {
        System.out.println("Kullanıcı adını giriniz:");
        String kullaniciAdi = tusTakimi.stringVeriAl();

        System.out.println("Şifre giriniz:");
        String sifre = tusTakimi.stringVeriAl();

        return new Kullanici(kullaniciAdi,sifre);
    }

    @Override
    public void kullaniciDogrulanmaMesaji(boolean dogrulandiMi) {
    	 System.out.println("");
        if (dogrulandiMi)  System.out.println("--- Hoşgeldiniz! ---");
        else  System.out.println("--- Kullanici sistemde kayitli değil!!! ---");
        System.out.println("");
    }

    @Override
    public void kullaniciCıkısEkrani() {
    	 System.out.println("\n--- Hoşçakalın, yine bekleriz ---\n");
    }

    @Override
    public int kullaniciSecenekleri(ITusTakimiCihaz tusTakimi) {
        boolean secenekHataliMi = false;
        int secenek;

        do {
        	 System.out.println("--- Kullanıcı Seçenekleri ---");
        	 System.out.println("1 - Sıcaklığı görüntüle");
        	 System.out.println("2 - Soğutucuyu aç");
        	 System.out.println("3 - Soğutucuyu kapat");
        	 System.out.println("0 - Çıkış");

            secenek = tusTakimi.intVeriAl();

            if (secenek < 0 || secenek > 3) {
            	 System.out.println("Lütfen aşağıdaki seçeneklerden birini giriniz:");
                secenekHataliMi = true;
            }
        } while (secenekHataliMi);

        return secenek;
    }

    

    @Override
    public void sicaklikGoruntule(IArayuz arayuz) {
        int sicaklik = arayuz.sicaklikGonder();
        System.out.println("\n--- Son okunan sıcaklık : " + sicaklik +  " C ---\n");
    }
}
