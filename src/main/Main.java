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

import motor.Oyun;
import servisler.FakeDataServis;

public class Main {

	public static void main(String[] args) {
				
		Scanner input = new Scanner(System.in);
		
		try {
			
			System.out.println("Tur sayısını girin: ");
			int turSayisi = input.nextInt();
			System.out.println("Sayilari girin");
			String sayilarString = input.nextLine();

			Oyun oyun = new Oyun(turSayisi, sayilarString);
			// TODO oyun.baslat ekle
		} catch (Exception e) {
			System.err.println("Hata meydana geldi" + e.getMessage());
		} finally {
			input.close();
			System.out.println("Simülasyon sonlandırıldı");
		}
		
		
		System.out.println(FakeDataServis.getKisiAd());
		System.out.println(FakeDataServis.getKisiSoyad());
		System.out.println(FakeDataServis.getSehirAd());
		System.out.println(FakeDataServis.getIlceAd());
		System.out.println(FakeDataServis.getMahalleAd());
	}

}
