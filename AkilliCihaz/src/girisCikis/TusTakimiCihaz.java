package girisCikis;

import java.util.Scanner;

public class TusTakimiCihaz implements ITusTakimiCihaz {

	  @Override
	    public String stringVeriAl() {
	        Scanner giris = new Scanner(System.in);
	        return giris.nextLine();
	    }

	    @Override
	    public int intVeriAl() {
	        Scanner giris = new Scanner(System.in);

	        int sayi = 0;
	        boolean girisHataliMi;

	        do {
	            if (giris.hasNextInt()){
	                sayi = giris.nextInt();
	                girisHataliMi = false;
	            }
	            else {
	                System.out.println("\nHATALI GİRİŞ YAPTINIZ");
	                System.out.println("Lütfen sayı giriniz:");
	                giris.next();
	                girisHataliMi = true;
	            }
	        } while (girisHataliMi);
	        return sayi;
	    }

}
