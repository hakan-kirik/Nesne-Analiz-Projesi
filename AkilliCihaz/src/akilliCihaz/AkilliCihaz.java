package akilliCihaz;




import akilliCihazCevreBirim.*;
import girisCikis.EkranCihaz;
import girisCikis.IEkranCihaz;
import girisCikis.ITusTakimiCihaz;
import girisCikis.TusTakimiCihaz;
import veritabani.IKullanicilarPostgreSql;
import veritabani.ISicaklikLog;
import veritabani.Kullanici;
import veritabani.KullanicilarPostgreSql;
import veritabani.SicaklikLog;

public class AkilliCihaz {


		IEkranCihaz ekran;
	    ITusTakimiCihaz tusTakimi;
	    IArayuz arayuz;
	    ISicaklikAlgilayici sicaklikAlgilayici;
	    IKullanicilarPostgreSql kisilerVeritabani;
	    ISicaklikLog sicaklikVeritabani;
	   
	    AkilliCihaz(){
	        ekran = new EkranCihaz();
	        tusTakimi = new TusTakimiCihaz();
	        arayuz = new Arayuz();
	        kisilerVeritabani = new KullanicilarPostgreSql();
	        sicaklikVeritabani = new SicaklikLog();
	        sicaklikAlgilayici=arayuz.AlgilayiciOlustur();
	        sicaklikAlgilayici.attach(sicaklikVeritabani);
	    }

	   
		
		public void basla(){
	        ekran.acilisMesajı();
	        Kullanici kullanici;

	        Thread run =new Thread(sicaklikAlgilayici);
	        run.start();

	        boolean cikisYapilsinMi = false;
	        int secenek = 0;

	        kullanici = ekran.kullaniciGirisEkrani(tusTakimi);
	        boolean kullaniciDogrulandiMi = kisilerVeritabani.kullaniciDogrula(kullanici);
	        ekran.kullaniciDogrulanmaMesaji(kullaniciDogrulandiMi);
	        do {
	            if (kullaniciDogrulandiMi){
	                secenek = ekran.kullaniciSecenekleri(tusTakimi);
	                cikisYapilsinMi = kullaniciIslemleri(secenek);
	            }
	            else {
	                System.out.println("Tekrar denemek ister misiniz? (E/H)");
	                boolean tekrarDenensinMi = tusTakimi.stringVeriAl().equalsIgnoreCase("E");
	                if (tekrarDenensinMi){
	                    kullanici = ekran.kullaniciGirisEkrani(tusTakimi);
	                    kullaniciDogrulandiMi = kisilerVeritabani.kullaniciDogrula(kullanici);
	                }
	                else
	                    cikisYapilsinMi = true;
	            }
	        }while (!cikisYapilsinMi);

	        ekran.kullaniciCıkısEkrani();
	        sicaklikAlgilayici.stop();
	    }

	    private boolean kullaniciIslemleri(int secenek){
	        boolean cikisYapilsinMi = false;

	        switch (secenek){
	            case 0:
	                cikisYapilsinMi = true;
	                break;
	            case 1:
	                ekran.sicaklikGoruntule(arayuz);
	                break;
	            case 2:
	                arayuz.sogutucuAc();
	                break;
	            case 3:
	               arayuz.SogutucuKapat();
	                break;
	        }

	        return cikisYapilsinMi;
	    }

}
