package akilliCihazCevreBirim;

public class Eyleyici implements IEyleyici{

	protected Eyleyici() {
		
	}
	
	@Override
	public void sogutucuAc() {
		System.out.println("sogutuluyor");
		
	}

	@Override
	public void sogutucuKapat() {
		System.out.println("sogutucu kapatildi");
		
	}

}
