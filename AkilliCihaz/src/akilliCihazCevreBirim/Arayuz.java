package akilliCihazCevreBirim;



public class Arayuz implements IArayuz {
	private ISicaklikAlgilayici algilayici;
	private IEyleyici eyleyici;
	
	public Arayuz() {
		algilayici=AlgilayiciOlustur();
		eyleyici=EyleyiciOlustur();
	}
	public ISicaklikAlgilayici AlgilayiciOlustur() {
		
		ISicaklikAlgilayici algilayici=new SicaklikAlgilayici();
		return algilayici;
		
	}
	@Override
	public IEyleyici EyleyiciOlustur() {
		IEyleyici eyleyici;
		eyleyici=new Eyleyici();
		return eyleyici;
	}
	
	@Override
	public int sicaklikGonder() {
		
		return algilayici.sicaklikOku();
		
	}


	@Override
	public void sogutucuAc() {
		eyleyici.sogutucuAc();
		algilayici.setSogutucuAcikMi(true);
		
	}

	@Override
	public void SogutucuKapat() {
		eyleyici.sogutucuKapat();
		algilayici.setSogutucuAcikMi(false);
		
	}
 
}
