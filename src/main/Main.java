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
import servisler.TestYazdirServis;
import servisler.YazdirServis;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		try {

			System.out.println("Tur sayısını girin: ");
			int turSayisi = input.nextInt();
			
			input.nextLine(); // "önceki nextInt()'ten kalma '\n' karakterini yakalaması için"
			
			System.out.println("Sayilari girin");
			String sayilarString = input.nextLine();

			Oyun oyun = new Oyun(turSayisi, sayilarString, new YazdirServis()); //gerçek uygulama esnasında
			//Oyun oyun = new Oyun(turSayisi, sayilarString, new TestYazdirServis()); //test amaçlı çıktı
			oyun.baslat();

		} catch (Exception e) {
			System.err.println("Hata meydana geldi: " + e.getMessage());
		} finally {
			System.out.println("\n------------------------------------------------");
			System.out.println("Programdan cikmak icin ENTER tusuna basiniz...");
			
			if (input.hasNextLine()) {
			    input.nextLine();
			}
			
			input.close();
			System.out.println("Simülasyon sonlandırıldı");
		}

	}

}
