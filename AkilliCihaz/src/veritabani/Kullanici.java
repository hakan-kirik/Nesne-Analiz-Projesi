package veritabani;

public class Kullanici implements IKullanici {
	private String kullaniciAdi;
	private String sifre;
	
	public Kullanici(String kAdi,String sifre){
		this.kullaniciAdi=kAdi;
		this.sifre=sifre;
		
	}
	
	@Override
	public String getKullaniciAdi() {
		
		return this.kullaniciAdi;
	}

	@Override
	public String getSifre() {
		
		return this.sifre;
	}
	
	
}
