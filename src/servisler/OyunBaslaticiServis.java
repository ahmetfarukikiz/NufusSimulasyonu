/**
*
* @author Ahmet Faruk İkiz faruk.ikiz@ogr.sakarya.edu.tr
* @since 14.04.2026
* <p>
* Aldığı sayıları BaslangicKuralHesaplayici sınıfı yardımıyla kullanmaya uygun hale getirir. 
* Bu sayılarla Yerleşke ve kişi modellerini oluşturur. Oyun sınıfına içi dolu Şehir listesi döndürür.
* </p>
*/

package servisler;

import java.util.List;

import araclar.BaslangicKuralHesaplayici;

import java.util.ArrayList;

import modeller.Ilce;
import modeller.Kisi;
import modeller.Mahalle;
import modeller.Sehir;

public class OyunBaslaticiServis {

	public OyunBaslaticiServis() {

	}

	// Oyunun başlangıç değerlerini ayarlar ve içi dolu şehir listesini döndürür
	public List<Sehir> yerleskeOlustur(int[] sayiDizi) {
		List<Sehir> sehirler = new ArrayList<Sehir>();

		// birim sayıları tutan değişkenler
		int sehirSayisi, ilceSayisi, b_mahalleSayisi, nufus;
		sehirSayisi = sayiDizi.length;

		// şehirler döngüsü
		for (int sayi : sayiDizi) {

			sayi = BaslangicKuralHesaplayici.gercekSayiHesapla(sayi); // mahalleler ilcelere esit paylasılabiliyor

			short onlar, birler;
			onlar = (short) ((sayi % 100) / 10);
			birler = (short) (sayi % 10);

			ilceSayisi = onlar;

			nufus = BaslangicKuralHesaplayici.gercekNufusHesapla(sayi, birler); // nufus mahallelere eşit
																				// paylaştırılabiliyor

			Sehir sehir = new Sehir(nufus);

			// ilçe başına mahalle sayısı
			b_mahalleSayisi = birler / onlar;

			ilceleriOlustur(sehir, ilceSayisi, b_mahalleSayisi);

			sehirler.add(sehir);
		}
		return sehirler;
	}

	// şehir döngüsü
	private void ilceleriOlustur(Sehir sehir, int ilceSayisi, int mahalleSayisi) {

		int ilceNufusu = sehir.getNufus() / ilceSayisi; // eşit paylaştır bölünmeme ihtimali yok çünkü tüm sayı birlere,
														// birler onlara bölünüyor.

		for (int i = 0; i < ilceSayisi; i++) {
			Ilce ilce = new Ilce(ilceNufusu);

			mahalleleriOlustur(ilce, mahalleSayisi);

			sehir.ilceEkle(ilce);

		}
	}

	// ilçe döngüsü
	private void mahalleleriOlustur(Ilce ilce, int mahalleSayisi) {

		int mahalleNufusu = ilce.getNufus() / mahalleSayisi;

		for (int i = 0; i < mahalleSayisi; i++) {
			Mahalle mahalle = new Mahalle(mahalleNufusu);
			kisileriOlustur(mahalle);
			ilce.mahalleEkle(mahalle);
		}
	}

	// mahalle döngüsü
	private void kisileriOlustur(Mahalle mahalle) {
		int kisiSayisi = mahalle.getNufus();

		for (int i = 0; i < kisiSayisi; i++) {
			Kisi kisi = new Kisi();
			mahalle.kisiEkle(kisi);
		}
	}

}
