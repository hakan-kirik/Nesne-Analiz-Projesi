package akilliCihazCevreBirim;

import veritabani.IObserver;

public interface ISicaklikAlgilayici extends Runnable {
	int sicaklikOku();
	public void setSogutucuAcikMi(boolean acikMi);
	public void attach(IObserver subscriber);
	public void detach(IObserver subscriber);
	public void notify(int message);
	void stop();
}
