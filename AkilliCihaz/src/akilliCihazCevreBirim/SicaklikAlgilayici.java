package akilliCihazCevreBirim;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import veritabani.IObserver;
import veritabani.ISicaklikLog;
import veritabani.SicaklikLog;

public class SicaklikAlgilayici implements ISicaklikAlgilayici {
	
	private volatile boolean exit = false;
    private List<IObserver> subscribers = new ArrayList<IObserver>();
	private ISicaklikLog sicaklikLog;
	private int sicaklik;
	private static boolean sogutucuAcikMi;
	protected SicaklikAlgilayici() {
		
		sicaklikLog=new SicaklikLog();
		
		Random rand=new Random();
		sicaklik=rand.nextInt(100)-50;
		
		sogutucuAcikMi=true;
	}
	
    @Override
    public void run() {
       
        while (true) {
        	if(exit) break;
            try {
            	
                if(sogutucuAcikMi) {
                	if(sicaklik>-50)
                		sicaklik--;
                }else {
                	if(sicaklik<40)
                		sicaklik++;
                	
                }
                this.notify(sicaklik);
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void stop() {
        exit = true;
     }
    @Override
    public void attach(IObserver subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void detach(IObserver subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notify(int message) {
        for (IObserver subscriber : subscribers){
            subscriber.update(message);
        }
    }
	
	@Override
	public int sicaklikOku() {
		
		return sicaklikLog.loglardanSicaklikGetir();
	}

	@Override
	public void setSogutucuAcikMi(boolean acikMi) {
		this.sogutucuAcikMi=acikMi;
		
	}

}
