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
					Sehir yeniSehir = sehriBol(sehir);
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

	public Sehir sehriBol(Sehir sehir) {
		// başta 0 nüfuslu boş bir şehir oluştur
		Sehir yeniSehir = new Sehir(0);
		int ilceSayisi = sehir.getIlceler().size();

		// ilçe 1 ise
		if (ilceSayisi == 1) {
			int mahalleSayisi = sehir.getIlceler().get(0).getMahalleler().size();
			// ilçe ve mahalle sayısı 1 ise
			if (mahalleSayisi == 1) {
				System.out.println("i 1 m 1");
				// TODO
			}
			// ilçe 1, mahalle 2 veya 2+ ise
			else {
				// TODO
				System.out.println("i 1 m 2+");

			}
		}

		// ilçe 2 veya 2+ ise
		else {
			// tam sayı bölmesiyle tek sayıysa 1 eksik aktarılacak
			int aktIlceSay = ilceSayisi / 2;

			for (int i = 0; i < aktIlceSay; i++) {
				yeniSehir.ilceEkle(sehir.popIlce());

			}
		}

		yeniSehir.nufusGuncelle();
		sehir.nufusGuncelle();
		return yeniSehir;

	}

	private void oyunSonuSatirSutunSor() {

		Scanner input = new Scanner(System.in);

		int satir, sutun, index;

		// uygunsuz index girilirse döngü devam eder
		while (true) {
			System.out.println("Satır Girin (0'dan başlar):");
			satir = input.nextInt();
			System.out.println("Sütun Girin (0'dan başlar):");
			sutun = input.nextInt();

			index = satir * 5 + sutun; // her satırda 5 eleman var

			if (index < 0 || index >= sehirler.size()) {
				System.out.println("Hatalı index tekrar deneyin.");
				continue;
			}

			break;
		}

		yazdirici.detayYazdir(sehirler, index);
	}
}
