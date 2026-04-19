/**
*
* @author Ahmet Faruk İkiz faruk.ikiz@ogr.sakarya.edu.tr
* @since 11.04.2026
* <p>
* Programı yöneten Oyun sınıfını başlatır.
* Kullanıcının girdiği sayıları BaslangicStringCevirici sınıfı ile int[] formatına
* çevirip tur sayısı ve uygun yazdırma sınıfıyla beraber Oyun sınıfına gönderir.
* Global hata Kontrolü yapar.
* </p>
*/
package main;

import java.util.Scanner;

import araclar.BaslangicStringCevirici;
import motor.Oyun;
import servisler.TestYazdirServis;
import servisler.YazdirServis;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		try {

			System.out.println("Tur sayısını girin: ");
			int turSayisi = input.nextInt();

			// "önceki nextInt()'ten kalma '\n' karakterini yakalaması için"
			input.nextLine();

			System.out.println("Sayilari girin");
			String sayilarString = input.nextLine();
			int[] sayiDizi = BaslangicStringCevirici.stringiSayiyaCevir(sayilarString);

			Oyun oyun = new Oyun(turSayisi, sayiDizi, new YazdirServis()); // gerçek uygulama esnasında
			//Oyun oyun = new Oyun(turSayisi, sayiDizi, new TestYazdirServis()); //test amaçlı çıktı
			oyun.baslat();

		} catch (Exception e) {
			System.err.println("Hata meydana geldi: " + e.getMessage());
		} finally {

			System.out.println("Programdan cikmak icin ENTER tusuna basiniz...");

			if (input.hasNextLine()) {
				input.nextLine();
			}

			input.close();
			System.out.println("Simülasyon sonlandırıldı");
		}

	}

}
