/**
*
* @author Ahmet Faruk İkiz faruk.ikiz@ogr.sakarya.edu.tr
* @since 11.04.2026
* <p>
* Oyun döngüsünü ve servis sınıflarını yöneten motor sınıfı
* </p>
*/

package motor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modeller.Sehir;
import servisler.OyunBaslaticiServis;

public class Oyun {
	private OyunBaslaticiServis oyunBaslaticiServis;
	private IYazdirici yazdirici;
	private int toplamTurSayisi;
	private int[] sayiDizi;
	private List<Sehir> sehirler;

	public Oyun(int turSayisi, int[] sayiDizi, IYazdirici yazdirici) {
		this.toplamTurSayisi = turSayisi;
		this.sayiDizi = sayiDizi;
		sehirler = new ArrayList<Sehir>();
		oyunBaslaticiServis = new OyunBaslaticiServis();
		this.yazdirici = yazdirici; // gelen yazdırma nesnesine göre test amaçlı veya gerçek formatta çıktı
									// üretilebilir

	}

	public void baslat() {
		sehirler = oyunBaslaticiServis.yerleskeOlustur(sayiDizi);

		System.out.println("Başlangıç Durumu:");
		yazdirici.TurYazdir(sehirler);

		// ana loop (TUR DÖNGÜSÜ)
		for (int tur = 1; tur <= toplamTurSayisi; tur++) {

			// her tur bölünmeyle oluşacak şehirleri tutacak geçici liste
			List<Sehir> yeniSehirler = new ArrayList<Sehir>();

			// tur işlemleri
			for (Sehir sehir : sehirler) {
				sehir.nufusArttir();
				sehir.yaslandir();

				// şehrin tur işlemlerinden sonra dört basamaklıysa böl
				if (sehir.dortBasamakli()) {
					Sehir yeniSehir = sehir.bolun();
					yeniSehirler.add(yeniSehir);
				}
			}

			// tur bittikten sonra bölünmeyle gelen şehirleri asıl listeye ekle
			sehirler.addAll(yeniSehirler);

			System.out.println(tur + ".tur sonu:");
			yazdirici.TurYazdir(sehirler);
			yazdirici.ekraniTemizle();
		}

		System.out.println("oyun sonu:");
		yazdirici.TurYazdir(sehirler);

		oyunSonuSatirSutunSor();

	}

	private void oyunSonuSatirSutunSor() {

		Scanner input = new Scanner(System.in);

		int satir, sutun, index;

		// uygunsuz index veya harf girilirse döngü devam eder
		while (true) {
			try {
				System.out.println("Satır Girin (0'dan başlar):");
				// int'e dönüştüremezse NumberFormatException döndürür ve catch bunu yakalar
				satir = Integer.parseInt(input.nextLine().trim());

				System.out.println("Sütun Girin (0'dan başlar):");
				sutun = Integer.parseInt(input.nextLine().trim());

				index = satir * 5 + sutun; // her satırda 5 eleman var

				if (index < 0 || index >= sehirler.size()) {
					System.out.println("Hatalı index tekrar deneyin.");
					continue;
				}

				break;
			} catch (NumberFormatException e) {
				System.out.println("Hata, sadece tam sayı giriniz");
			}
		}

		yazdirici.detayYazdir(sehirler, index);
	}
}
