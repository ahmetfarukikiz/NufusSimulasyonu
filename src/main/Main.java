/**
*
* @author Ahmet Faruk İkiz faruk.ikiz@ogr.sakarya.edu.tr
* @since 11.04.2026
* <p>
* Programı başlatan main sınıfı
* </p>
*/
package main;
import java.util.Scanner;


import servisler.FakeDataServis;

public class Main {

	public static void main(String[] args) {
				
		
		System.out.println(FakeDataServis.getKisiAd());
		System.out.println(FakeDataServis.getKisiSoyad());
		System.out.println(FakeDataServis.getSehirAd());
		System.out.println(FakeDataServis.getIlceAd());
		System.out.println(FakeDataServis.getMahalleAd());
	}

}
