/**
*
* @author Ahmet Faruk İkiz faruk.ikiz@ogr.sakarya.edu.tr
* @since 14.04.2026
* <p>
* 
* </p>
*/

package servisler;

import java.util.List;
import java.util.ArrayList;

import modeller.Ilce;
import modeller.Kisi;
import modeller.Mahalle;
import modeller.Sehir;

public class OyunBaslaticiServis {
	public OyunBaslaticiServis() {

	}

	public List<Sehir> stringtenYerleskeOlustur(String sayilarString) {
		List<Sehir> sehirler = new ArrayList<Sehir>();

		int[] sayiDizi = stringiSayiyaCevir(sayilarString);

		// birim sayıları tutan değişkenler
		int sehirSayisi, ilceSayisi, b_mahalleSayisi, nufus;
		sehirSayisi = sayiDizi.length;

		// şehirler döngüsü
		for (int sayi : sayiDizi) {

			sayi = gercekSayiHesapla(sayi); // mahalleler ilcelere esit paylasılabiliyor

			short onlar, birler;
			onlar = (short) ((sayi % 100) / 10);
			birler = (short) (sayi % 10);

			ilceSayisi = onlar;

			nufus = gercekNufusHesapla(sayi, birler); // nufus mahallelere eşit paylaştırılabiliyor

			Sehir sehir = new Sehir(nufus);

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

	// Mahalleleri ilçelere eşit dağılabilir hale getirir
	private int gercekSayiHesapla(int sayi) {
		int gercekSayi = sayi;
		short onlar, birler;
		onlar = (short) ((sayi % 100) / 10);
		birler = (short) (sayi % 10);

		while (birler == 0 || birler % onlar != 0) {
			birler = (short) ((birler + 1) % 10);
		}

		gercekSayi = (onlar * 10) + birler;
		return gercekSayi;
	}

	// toplam nüfusu sayıyı mahalle sayısına dağılabilir (bölünebilir hale getirir) örn: 18->24  24 % 4 == 0
	private int gercekNufusHesapla(int nufus, int mahalleSayisi) {
		int gercekNufus = nufus;

		while (gercekNufus % mahalleSayisi != 0) {
			gercekNufus++;
		}

		return gercekNufus;
	}

	
	// string halinde gelen veriyi sayı dizisine çevirir
	private int[] stringiSayiyaCevir(String sayilarString) {
		String[] sayiStDizi = sayilarString.split(" ");

		// üzerinde hesaplama yapacağımız sayı dizisi
		int[] sayiDizi = new int[sayiStDizi.length];

		for (int i = 0; i < sayiStDizi.length; i++) { // stringleri sayılara çevirme 12 43 21
			sayiDizi[i] = Integer.parseInt(sayiStDizi[i]);
		}
		return sayiDizi;
	}

}
